package com.dyshuk.android.upworkredesigncompose.data.model

data class CurrentUser(
    val id: Int,
    val name: String,
    val picture: Int?,
    val newMessagesCount: Int,
)
