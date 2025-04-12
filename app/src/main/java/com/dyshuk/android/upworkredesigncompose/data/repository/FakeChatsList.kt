package com.dyshuk.android.upworkredesigncompose.data.repository

import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.data.model.Chat
import com.dyshuk.android.upworkredesigncompose.data.model.Message
import com.dyshuk.android.upworkredesigncompose.data.model.OnlineStatus
import com.dyshuk.android.upworkredesigncompose.data.model.User

val fakeChatsList = listOf<Chat>(
    Chat(
        id = 0,
        senderId = 0,
        messages = null,
        lastMessage = Message(
            text = "You: I had uploaded new files to trello, plea...",
            isRead = false
        ),
        newMessagesCount = 3,
        chatTitle = "Upwork Redesign Project",
        sender = User(
            id = 0,
            name = "Stephen Strange",
            pictureUrl = R.drawable.doctor_strange_ava,
            status = OnlineStatus.ONLINE
        ),
        timestamp = "Yesterday"
    ),
    Chat(
        id = 1,
        senderId = 1,
        messages = null,
        lastMessage = Message(
            text = "You: I had uploaded new files",
            isRead = true
        ),
        newMessagesCount = 0,
        chatTitle = "New Payoneer Mobile App",
        sender = User(
            id = 1,
            name = "Steve Rogers",
            pictureUrl = R.drawable.steven_rodgers_ava,
            status = OnlineStatus.OFFLINE
        ),
        timestamp = "Yesterday"
    ),
    Chat(
        id = 2,
        senderId = 2,
        messages = null,
        lastMessage = Message(
            text = "You: I had uploaded new files to trello, please revie...",
            isRead = true
        ),
        newMessagesCount = 0,
        chatTitle = "Product Designer for Skype",
        sender = User(
            id = 2,
            name = "Natasha Romanoff",
            pictureUrl = R.drawable.natasha_romanoff_ava,
            status = OnlineStatus.IDLE
        ),
        timestamp = "Yesterday"
    ),
    Chat(
        id = 3,
        senderId = 3,
        messages = null,
        lastMessage = Message(
            text = "You: I had uploaded new files to trello, please revie...",
            isRead = true
        ),
        newMessagesCount = 0,
        chatTitle = "Trello Team",
        sender = User(
            id = 3,
            name = "Peter Parker",
            pictureUrl = R.drawable.peter_parker_ava,
            status = OnlineStatus.OFFLINE
        ),
        timestamp = "02:15 PM"
    ),
    Chat(
        id = 4,
        senderId = 4,
        messages = null,
        lastMessage = Message(
            text = "You: I had uploaded new files to trello, please revie...",
            isRead = true
        ),
        newMessagesCount = 0,
        chatTitle = "Apple Inc.",
        sender = User(
            id = 4,
            name = "Hope van Dyne",
            pictureUrl = R.drawable.hope_van_dyne_ava,
            status = OnlineStatus.ONLINE
        ),
        timestamp = "September 25, 2024"
    )
)