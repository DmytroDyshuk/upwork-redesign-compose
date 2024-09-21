package com.dyshuk.android.upworkredesigncompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MessagesScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Blue)
    ) {
        Text(text = "Messages Screen", modifier = Modifier.align(Alignment.Center))
    }
}