package com.dyshuk.android.upworkredesigncompose.ui.navigation

import com.dyshuk.android.upworkredesigncompose.R
import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    data object JobListScreen : Destinations()

    @Serializable
    data object ProposalsScreen : Destinations()

    @Serializable
    data object MessagesScreen : Destinations()

    @Serializable
    data object ProfileScreen : Destinations()

    @Serializable
    data class JobDetailsScreen(val jobId: Int) : Destinations()
}

enum class TopLevelDestinations(
    val route: Destinations,
    val title: String,
    val icon: Int
) {
    JobListScreen(
        route = Destinations.JobListScreen,
        title = "Job List",
        icon = R.drawable.ic_jobs_unselected
    ),
    ProposalsScreen(
        route = Destinations.ProposalsScreen,
        title = "Proposals",
        icon = R.drawable.ic_proposals_unselected
    ),
    MessagesScreen(
        route = Destinations.MessagesScreen,
        title = "Messages",
        icon = R.drawable.ic_messages_unselected
    ),
    ProfileScreen(
        route = Destinations.ProfileScreen,
        title = "Profile",
        icon = R.drawable.tony_stark_ava
    )
}