package com.dyshuk.android.upworkredesigncompose.ui.core

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.dyshuk.android.upworkredesigncompose.ui.navigation.AppNavHost
import com.dyshuk.android.upworkredesigncompose.ui.navigation.BottomNavigationBar
import com.dyshuk.android.upworkredesigncompose.ui.navigation.Destinations
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun UpworkRedesignApp() {
    val navController = rememberNavController()
    val messagesViewModel: AppViewModel = viewModel()
    val unreadMessagesCount by messagesViewModel.unreadMessagesCount.collectAsState()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                unreadMessagesCount = unreadMessagesCount,
            )
        }
    ) {
        AppNavHost(
            startDestination = Destinations.JobListScreen,
            navController = navController
        )
    }

}

@Preview
@Composable
fun AppPreview() {
    UpworkRedesignComposeTheme {
        UpworkRedesignApp()
    }
}