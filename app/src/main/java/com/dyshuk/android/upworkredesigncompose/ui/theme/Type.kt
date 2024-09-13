package com.dyshuk.android.upworkredesigncompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = rubikFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = rubikFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = rubikFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    titleMedium = TextStyle(
        fontFamily = rubikFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    titleSmall = TextStyle(
        fontFamily = rubikFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = rubikFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)