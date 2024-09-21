package com.dyshuk.android.upworkredesigncompose.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.navigation.NavigationItem
import com.dyshuk.android.upworkredesigncompose.ui.theme.CoralRed
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<NavigationItem>,
    selectedItemIndex: Int = 0,
    unreadMessagesCount: Int,
    onItemSelected: (Int) -> Unit
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
            .clip(shape = MaterialTheme.shapes.medium)
            .background(Color.White)
            .requiredHeight(70.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = selectedItemIndex == index

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

            Column(
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {
                        onItemSelected(index)
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(animatedBoxColor)
                        .size(width = 40.dp, height = 40.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(20.dp, 20.dp)
                    ) {
                        if (index == 3) {
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
                                imageVector = ImageVector.vectorResource(id = item.iconRes),
                                tint = animatedIconColor,
                                contentDescription = item.title
                            )
                        }

                        if (item is NavigationItem.Messages && unreadMessagesCount > 0) {
                            Text(
                                text = unreadMessagesCount.toString(),
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.White,
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .drawBehind {
                                        drawCircle(
                                            color = CoralRed,
                                            radius = this.size.maxDimension / 2f
                                        )
                                    }
                            )
                        }
                    }
                }
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = item.title.uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = animateTextColor
                )
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