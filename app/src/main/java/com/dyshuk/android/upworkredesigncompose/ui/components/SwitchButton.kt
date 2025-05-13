package com.dyshuk.android.upworkredesigncompose.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.utils.clickableWithoutRipple

@Composable
fun SwitchButton(
    modifier: Modifier = Modifier,
    buttons: List<String>,
    height: Dp,
    textSize: TextUnit,
    colorBackground: Color = Color.White,
    colorIndicator: Color = PrimaryGreen
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(color = colorBackground, shape = RoundedCornerShape(15.dp))
    ) {
        val indicatorWidth = this.maxWidth / buttons.size
        val offset by animateDpAsState(
            targetValue = indicatorWidth * selectedIndex,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessMediumLow
            )
        )

        Box(
            modifier = Modifier
                .size(width = indicatorWidth, height = height)
                .offset(x = offset)
                .background(color = colorIndicator, shape = RoundedCornerShape(15.dp))
        )

        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            buttons.forEachIndexed { index, text ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickableWithoutRipple { selectedIndex = index },
                    contentAlignment = Alignment.Center
                ) {
                    val isSelected = index == selectedIndex
                    Text(
                        text = text,
                        color = animateColorAsState(
                            targetValue = if (isSelected) Color.White else CharcoalGray,
                            animationSpec = tween(300)
                        ).value,
                        style = MaterialTheme.typography.headlineMedium.copy(fontSize = textSize)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SwitchButtonPreview() {
    UpworkRedesignComposeTheme {
        SwitchButton(
            buttons = listOf("Active", "Archived"),
            height = 25.dp,
            textSize = 12.sp
        )
    }
}