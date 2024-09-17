package com.dyshuk.android.upworkredesigncompose.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.navigation.BottomNavigationItem
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun BottomNavigationBar() {
    val bottomItems = listOf(
        BottomNavigationItem(
            title = "Jobs",
            icon = ImageVector.vectorResource(R.drawable.ic_jobs_unselected)
        ),
        BottomNavigationItem(
            title = "Proposals",
            icon = ImageVector.vectorResource(R.drawable.ic_proposals_unselected)
        ),
        BottomNavigationItem(
            title = "Messages",
            icon = ImageVector.vectorResource(R.drawable.ic_messages_unselected),
            messagesCount = 10
        ),
        BottomNavigationItem(
            title = "Messages",
            icon = ImageVector.vectorResource(R.drawable.ic_messages_unselected)
        )
    )

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
            .clip(shape = RoundedCornerShape(20.dp))
            .background(Color.White)
            .requiredHeight(70.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }

        bottomItems.forEachIndexed { index, item ->
            val isSelected = selectedItemIndex == index

            val animatedColor by animateColorAsState(
                targetValue = if (isSelected) {
                    MaterialTheme.colorScheme.primary
                } else MaterialTheme.colorScheme.onSurfaceVariant,
                animationSpec = tween(durationMillis = 300)
            )

            Column(
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {
                        selectedItemIndex = index
                    }
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(
                            if (isSelected) {
                                MaterialTheme.colorScheme.secondaryContainer
                            } else SnowWhite
                        )
                        .size(width = 40.dp, height = 40.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(20.dp, 20.dp)
                    ) {
                        Icon(
                            modifier = Modifier.align(Alignment.Center),
                            imageVector = item.icon,
                            tint = animatedColor,
                            contentDescription = item.title
                        )
                        if (item.messagesCount != null) {
                            Text(
                                text = 2.toString(),
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.White,
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .drawBehind {
                                        drawCircle(
                                            color = Color(0xFFE15554),
                                            radius = this.size.maxDimension / 2.0f
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
                    color = if (isSelected) {
                        MaterialTheme.colorScheme.onSurface
                    } else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewNavBar() {
    UpworkRedesignComposeTheme {
        BottomNavigationBar()
    }
}