package com.dyshuk.android.upworkredesigncompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dyshuk.android.upworkredesigncompose.ui.screens.JobsScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.MessagesScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.ProfileScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.ProposalsScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Jobs.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Jobs.route) {
            JobsScreen()
        }
        composable(NavigationItem.Proposals.route) {
            ProposalsScreen()
        }
        composable(NavigationItem.Messages.route) {
            MessagesScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
    }
}