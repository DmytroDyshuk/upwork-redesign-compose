package com.dyshuk.android.upworkredesigncompose.ui.navigation

import com.dyshuk.android.upworkredesigncompose.R

enum class Screen {
    JOBS,
    PROPOSALS,
    MESSAGES,
    PROFILE
}

sealed class NavigationItem(val route: String, val title: String, val iconRes: Int) {
    object Jobs : NavigationItem(Screen.JOBS.name, "Jobs", R.drawable.ic_jobs_unselected)
    object Proposals : NavigationItem(Screen.PROPOSALS.name, "Proposals", R.drawable.ic_proposals_unselected)
    object Messages : NavigationItem(Screen.MESSAGES.name, "Messages", R.drawable.ic_messages_unselected)
    object Profile : NavigationItem(Screen.PROFILE.name, "Profile", R.drawable.tony_stark_ava)
}