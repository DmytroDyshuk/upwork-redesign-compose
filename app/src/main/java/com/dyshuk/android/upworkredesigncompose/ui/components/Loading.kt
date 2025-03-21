package com.dyshuk.android.upworkredesigncompose.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Loading() {
    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
}