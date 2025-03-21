package com.dyshuk.android.upworkredesigncompose.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorScreen(message: String) {
    Text(
        text = message,
        modifier = Modifier.fillMaxSize(),
        color = Color.Red
    )
}