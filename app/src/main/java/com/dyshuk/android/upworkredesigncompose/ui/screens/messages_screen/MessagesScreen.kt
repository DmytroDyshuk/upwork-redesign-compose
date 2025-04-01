package com.dyshuk.android.upworkredesigncompose.ui.screens.messages_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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