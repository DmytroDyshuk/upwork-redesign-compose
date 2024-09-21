package com.dyshuk.android.upworkredesigncompose.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.dyshuk.android.upworkredesigncompose.MessagesViewModel
import com.dyshuk.android.upworkredesigncompose.ui.navigation.AppNavHost
import com.dyshuk.android.upworkredesigncompose.ui.navigation.NavigationItem
import com.dyshuk.android.upworkredesigncompose.ui.navigation.Screen
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun UpworkRedesignApp() {
    val navController = rememberNavController()
    val messagesViewModel: MessagesViewModel = viewModel()
    val unreadMessagesCount by messagesViewModel.unreadMessagesCount.collectAsState()

    val items = listOf(
        NavigationItem.Jobs,
        NavigationItem.Proposals,
        NavigationItem.Messages,
        NavigationItem.Profile
    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    navController = navController,
                    items = items,
                    selectedItemIndex = selectedItemIndex,
                    unreadMessagesCount = unreadMessagesCount,
                    onItemSelected = { index ->
                        selectedItemIndex = index
                    }
                )
            }
        ) { paddingValues ->
            AppNavHost(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                startDestination = Screen.JOBS.name,
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