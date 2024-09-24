package com.dyshuk.android.upworkredesigncompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    // example of receiving data from the server (stub function)
    private suspend fun getMessagesCountFromServer() = 7
}