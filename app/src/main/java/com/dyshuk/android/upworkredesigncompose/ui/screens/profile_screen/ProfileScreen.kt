package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun ProfileScreen() {
    ProfileScreenContent()
}

@Composable
fun ProfileScreenContent(modifier: Modifier = Modifier) {
    val headerMaxHeight = 100.dp
    val headerMinHeight = 65.dp
    val scrollState = rememberScrollState()

    val currentDensity = LocalDensity.current

    val headerMaxHeightPx = with(currentDensity) { headerMaxHeight.toPx() }
    val headerMinHeightPx = with(currentDensity) { headerMinHeight.toPx() }

    val scrollOffset by remember {
        derivedStateOf {
            scrollState.value.toFloat().coerceAtMost(headerMaxHeightPx - headerMinHeightPx)
        }
    }
    val headerHeightPx by remember {
        derivedStateOf { headerMaxHeightPx - scrollOffset }
    }
    val headerHeightDp = with(currentDensity) { headerHeightPx.toDp() }

    val animatedHeightDp by animateDpAsState(targetValue = headerHeightDp)

    val collapseProgress by remember {
        derivedStateOf {
            (scrollOffset / (headerMaxHeightPx - headerMinHeightPx)).coerceIn(0f, 1f)
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        ProfileHeader(
            modifier = Modifier.height(animatedHeightDp),
            currentDensity = currentDensity,
            collapseProgress = collapseProgress
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            repeat(50) {
                Text(
                    text = "Контент $it",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    currentDensity: Density,
    collapseProgress: Float,
    earningAmount: String = "3,289"
) {
    val localConfiguration = LocalConfiguration.current
    val localScreenWidth = localConfiguration.screenWidthDp.dp
    val localScreenHeight = localConfiguration.screenHeightDp.dp
    val maxOffsetX = localScreenWidth * 0.35f
    val maxOffsetY = localScreenHeight * 0.01f

    val animatedOffsetRight by animateFloatAsState(
        targetValue = with(currentDensity) { (maxOffsetX * collapseProgress).toPx() }
    )
    val animatedOffsetLeft = -animatedOffsetRight

    val animatedOffsetDown by animateFloatAsState(
        targetValue = with(currentDensity) { (maxOffsetY * collapseProgress).toPx() }
    )
    val animatedOffsetUp = -animatedOffsetDown

    Box(
        modifier = modifier
            .background(color = PrimaryGreen, shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .graphicsLayer {
                        translationX = animatedOffsetLeft
                        translationY = animatedOffsetDown
                    },
                text = "Earnings Available:",
                color = CharcoalGray,
                fontSize = 10.sp,
                fontFamily = rubikFamily,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier
                    .graphicsLayer {
                        translationX = animatedOffsetRight
                        translationY = animatedOffsetUp
                    },
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xB3FFFFFF),
                            fontSize = 14.sp,
                            fontFamily = rubikFamily,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("$ ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFFFFFFF),
                            fontSize = 18.sp,
                            fontFamily = rubikFamily,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(earningAmount)
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {

}