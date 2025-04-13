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
import androidx.navigation.toRoute
import com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.JobDetailsScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.job_list_screen.JobListScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.messages_screen.MessagesScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.ProfileScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.proposals_screen.ProposalsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: Any = Destinations.JobListScreen
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
        composable<Destinations.JobListScreen>(
            enterTransition = { enterTransition() },
            exitTransition = { exitTransition() }
        ) {
            JobListScreen(onJobClicked = { jobId ->
                navController.navigate(Destinations.JobDetailsScreen(jobId)) {
                    launchSingleTop = true
                }
            })
        }
        composable<Destinations.ProposalsScreen>(
            enterTransition = { enterTransition() },
            exitTransition = { exitTransition() }
        ) {
            ProposalsScreen()
        }
        composable<Destinations.MessagesScreen>(
            enterTransition = { enterTransition() },
            exitTransition = { exitTransition() }
        ) {
            MessagesScreen()
        }
        composable<Destinations.ProfileScreen>(
            enterTransition = { enterTransition() },
            exitTransition = { exitTransition() }
        ) {
            ProfileScreen()
        }
        composable<Destinations.JobDetailsScreen> { backStackEntry ->
            val jobDetails: Destinations.JobDetailsScreen = backStackEntry.toRoute()

            JobDetailsScreen(
                jobId = jobDetails.jobId,
                onBackPressed = {
                    navController.navigateUp()
                },
                onSubmitPressed = {
                    navController.navigateUp()
                }
            )
        }
    }
}