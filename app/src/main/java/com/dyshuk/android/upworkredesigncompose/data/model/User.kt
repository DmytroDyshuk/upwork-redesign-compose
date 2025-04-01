package com.dyshuk.android.upworkredesigncompose.data.model

import androidx.compose.ui.graphics.Color

data class User(
    val id: Int,
    val name: String,
    val pictureUrl: Int?,
    val status: OnlineStatus
)

enum class OnlineStatus(val color: Color) {
    ONLINE(color = Color.Green),
    IDLE(color = Color.Yellow),
    OFFLINE(color = Color.Gray)
}
