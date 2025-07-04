package com.dyshuk.android.upworkredesigncompose.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.components.buttons.LabeledIconButton
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite

@Composable
fun BottomNavigationBar(
    navController: NavController, unreadMessagesCount: Int
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination: NavDestination? = navBackStackEntry?.destination

    val showBottomBar = TopLevelDestinations.entries.map { it.route::class }.any { route ->
        currentDestination?.hierarchy?.any {
            it.hasRoute(route)
        } == true
    }

    AnimatedVisibility(visible = showBottomBar) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.0f to Color.White.copy(alpha = 0.0f),
                            0.2f to Color.White.copy(alpha = 0.5f),
                            1.0f to Color.White.copy(alpha = 0.9f)
                        )
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp)
                    .padding(bottom = 22.dp)
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(20.dp)
                        shadowElevation = 4f
                    }
                    .clip(shape = MaterialTheme.shapes.large)
                    .background(Color.White)
                    .requiredHeight(70.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround) {
                currentDestination?.let { destination ->
                    TopLevelDestinations.entries.forEachIndexed { index, bottomNavigationItem ->

                        val isSelected = destination.hierarchy.any {
                            it.hasRoute(bottomNavigationItem.route::class)
                        }

                        val animatedIconColor by getAnimatedColor(
                            isSelected,
                            selectedColor = MaterialTheme.colorScheme.primary,
                            defaultColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        val animatedBoxColor by getAnimatedColor(
                            isSelected,
                            selectedColor = MaterialTheme.colorScheme.secondaryContainer,
                            defaultColor = SnowWhite
                        )

                        val animateTextColor by getAnimatedColor(
                            isSelected,
                            selectedColor = MaterialTheme.colorScheme.onSurface,
                            defaultColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        val animateAlpha by animateFloatAsState(
                            targetValue = if (isSelected) 1f else 0.5f,
                            animationSpec = tween(durationMillis = 500),
                            label = "animate alpha"
                        )

                        LabeledIconButton(
                            label = bottomNavigationItem.title,
                            backgroundColor = animatedBoxColor,
                            textColor = animateTextColor,
                            notificationsBadge = if (bottomNavigationItem.route is
                                        Destinations.MessagesScreen && unreadMessagesCount > 0
                            ) unreadMessagesCount else null,
                            onClick = {
                                navController.navigate(bottomNavigationItem.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            customIcon = {
                                if (bottomNavigationItem.route === Destinations.ProfileScreen) {
                                    Image(
                                        painter = painterResource(R.drawable.tony_stark_ava),
                                        contentDescription = "User Image",
                                        contentScale = ContentScale.Crop,
                                        alpha = animateAlpha,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .requiredSize(26.dp)
                                    )
                                } else {
                                    Icon(
                                        modifier = Modifier.align(Alignment.Center),
                                        imageVector = ImageVector.vectorResource(id = bottomNavigationItem.icon),
                                        tint = animatedIconColor,
                                        contentDescription = bottomNavigationItem.title
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun getAnimatedColor(isSelected: Boolean, selectedColor: Color, defaultColor: Color): State<Color> {
    return animateColorAsState(
        targetValue = if (isSelected) selectedColor else defaultColor,
        animationSpec = tween(durationMillis = 500),
        label = "Animated tab color"
    )
}