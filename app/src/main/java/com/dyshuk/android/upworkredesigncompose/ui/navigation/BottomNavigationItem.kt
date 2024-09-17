package com.dyshuk.android.upworkredesigncompose.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val messagesCount: Int? = null
)
