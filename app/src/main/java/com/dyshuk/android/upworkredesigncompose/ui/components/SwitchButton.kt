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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.utils.clickableWithoutRipple

@Composable
fun SwitchButton(
    modifier: Modifier = Modifier,
    firstText: String = "Active",
    secondText: String = "Archived",
    colorIndicator: Color = PrimaryGreen
) {
    var isActive by remember { mutableStateOf(true) }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .height(35.dp)
            .background(color = Color.White, shape = RoundedCornerShape(15.dp))
    ) {
        val indicatorWith = this.maxWidth / 2
        val offset by animateDpAsState(
            targetValue = if (isActive) 0.dp else indicatorWith,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessMediumLow
            )
        )

        Box(
            modifier = Modifier
                .size(width = indicatorWith, height = 35.dp)
                .offset(x = offset)
                .background(color = colorIndicator, shape = RoundedCornerShape(15.dp))
        )

        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickableWithoutRipple { isActive = true },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = firstText,
                    color = animateColorAsState(
                        targetValue = if (isActive) Color.White else CharcoalGray,
                        animationSpec = tween(300)
                    ).value,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickableWithoutRipple { isActive = false },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = secondText,
                    color = animateColorAsState(
                        targetValue = if (isActive) CharcoalGray else Color.White,
                        animationSpec = tween(300)
                    ).value,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun SwitchButtonPreview() {
    UpworkRedesignComposeTheme {
        SwitchButton()
    }
}