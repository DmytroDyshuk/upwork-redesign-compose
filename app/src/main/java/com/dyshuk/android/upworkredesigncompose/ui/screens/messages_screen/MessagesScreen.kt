package com.dyshuk.android.upworkredesigncompose.ui.screens.messages_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun MessagesScreen(viewModel: MessagesViewModel = viewModel()) {
    MessagesScreenContent()
}

@Composable
fun MessagesScreenContent(modifier: Modifier = Modifier) {

}

@Preview
@Composable
fun MessagesScreenPreview() {
    UpworkRedesignComposeTheme {
        MessagesScreen()
    }
}