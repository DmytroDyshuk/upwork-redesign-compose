package com.dyshuk.android.upworkredesigncompose.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.dyshuk.android.upworkredesigncompose.ui.navigation.AppNavHost
import com.dyshuk.android.upworkredesigncompose.ui.navigation.Destinations
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.screens.messages_screen.MessagesViewModel

@Composable
fun UpworkRedesignApp() {
    val navController = rememberNavController()
    val messagesViewModel: MessagesViewModel = viewModel()
    val unreadMessagesCount by messagesViewModel.unreadMessagesCount.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    navController = navController,
                    unreadMessagesCount = unreadMessagesCount,
                )
            }
        ) { paddingValues ->
            AppNavHost(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                startDestination = Destinations.JobListScreen,
                navController = navController
            )
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    UpworkRedesignComposeTheme {
        UpworkRedesignApp()
    }
}