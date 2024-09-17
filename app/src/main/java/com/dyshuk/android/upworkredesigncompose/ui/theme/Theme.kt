package com.dyshuk.android.upworkredesigncompose.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun UpworkRedesignComposeTheme(content: @Composable () -> Unit) {
    val colorScheme = lightColorScheme(
        primary = PrimaryGreen,
        onPrimary = Color.White,
        surface = Color.White,
        onSurface = CharcoalGray,
        onSurfaceVariant = LightSilver,
        surfaceTint = Color.White,
        surfaceContainer = Color.White,
        secondaryContainer = MintCream,
        background = LightGray
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}