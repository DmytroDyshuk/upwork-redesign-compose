package com.dyshuk.android.upworkredesigncompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.ui.theme.CoralRed

@Composable
fun LabeledIconButton(
    modifier: Modifier = Modifier,
    label: String,
    backgroundColor: Color,
    textColor: Color,
    showBadge: Boolean = false,
    badgeCount: Int = 0,
    onClick: () -> Unit,
    customIcon: @Composable BoxScope.() -> Unit
) {
    Column(
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(shape = MaterialTheme.shapes.small)
                .background(backgroundColor)
                .size(40.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(20.dp, 20.dp)
            ) {
                this.customIcon()

                if (showBadge && badgeCount > 0) {
                    Text(
                        text = badgeCount.toString(),
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
            text = label.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            color = textColor
        )
    }
}