package com.dyshuk.android.upworkredesigncompose.ui.screens.messages_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyshuk.android.upworkredesigncompose.data.model.Chat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MessagesViewModel : ViewModel() {

    private val _unreadMessagesCount = MutableStateFlow(0)
    val unreadMessagesCount: StateFlow<Int> = _unreadMessagesCount

    init {
        fetchUnreadMessagesCount()
    }

    private fun fetchUnreadMessagesCount() {
        viewModelScope.launch {
            val newMessagesCount = getMessagesCountFromServer()
            _unreadMessagesCount.value = newMessagesCount
        }
    }

    private suspend fun getMessagesCountFromServer() = 7
}

sealed interface MessagesScreenState {
    data object Loading : MessagesScreenState
    data class Error(val message: String): MessagesScreenState
    data class Success(val chatsList: List<Chat>): MessagesScreenState
}