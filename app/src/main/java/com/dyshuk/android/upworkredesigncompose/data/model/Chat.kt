package com.dyshuk.android.upworkredesigncompose.data.model

data class Chat(
    val id: Int,
    val senderId: Int,
    val messages: List<Message>?,
    val lastMessage: Message,
    val newMessagesCount: Int,
    val chatTitle: String,
    val sender: User,
    val timestamp: String
)