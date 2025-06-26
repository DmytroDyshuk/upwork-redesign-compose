package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

/**
 * NOTE: This composable uses hardcoded mock data as part of a personal project
 * to showcase Jetpack Compose UI capabilities.
 *
 * In production, all data should be passed into this composable via parameters
 * or state objects, depending on the app architecture.
 */
@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    collapseProgress: Float,
    earningAmount: String = "3,289"
) {
    val localConfiguration = LocalConfiguration.current
    val localScreenWidth = localConfiguration.screenWidthDp.dp
    val localScreenHeight = localConfiguration.screenHeightDp.dp

    val density = LocalDensity.current
    val offsetX = with(density) { (localScreenWidth * 0.35f).toPx() }
    val offsetY = with(density) { (localScreenHeight * 0.01f).toPx() }

    val offsetXAnimated by animateFloatAsState(targetValue = offsetX * collapseProgress)
    val offsetYAnimated by animateFloatAsState(targetValue = offsetY * collapseProgress)

    Box(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = PrimaryGreen,
                    shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .graphicsLayer {
                            translationX = -offsetXAnimated
                            translationY = offsetYAnimated
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
                            translationX = offsetXAnimated
                            translationY = -offsetYAnimated
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

}