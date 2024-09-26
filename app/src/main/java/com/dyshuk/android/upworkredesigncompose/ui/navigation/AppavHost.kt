package com.dyshuk.android.upworkredesigncompose.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dyshuk.android.upworkredesigncompose.ui.screens.jobs_screen.JobsScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.messages_screen.MessagesScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.ProfileScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.proposals_screen.ProposalsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Jobs.route
) {
    val enterTransition: AnimatedContentTransitionScope<*>.() -> EnterTransition = {
        slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700))
    }

    val exitTransition: AnimatedContentTransitionScope<*>.() -> ExitTransition = {
        slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700))
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = NavigationItem.Jobs.route,
            enterTransition = { enterTransition() },
            exitTransition = { exitTransition() }
        ) {
            JobsScreen()
        }
        composable(
            NavigationItem.Proposals.route,
            enterTransition = { enterTransition() },
            exitTransition = { exitTransition() }
        ) {
            ProposalsScreen()
        }
        composable(
            NavigationItem.Messages.route,
            enterTransition = { enterTransition() },
            exitTransition = { exitTransition() }
        ) {
            MessagesScreen()
        }
        composable(
            NavigationItem.Profile.route,
            enterTransition = { enterTransition() },
            exitTransition = { exitTransition() }
        ) {
            ProfileScreen()
        }
    }
}