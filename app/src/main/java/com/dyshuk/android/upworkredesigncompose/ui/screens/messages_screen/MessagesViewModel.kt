package com.dyshuk.android.upworkredesigncompose.ui.screens.messages_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyshuk.android.upworkredesigncompose.data.model.Chat
import com.dyshuk.android.upworkredesigncompose.data.repository.FakeChatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MessagesViewModel : ViewModel() {
    private val _uiState =  MutableStateFlow<MessagesScreenState>(MessagesScreenState.Loading)
    val uiState: StateFlow<MessagesScreenState> = _uiState

    init {
        getAllUserChats()
    }

    private fun getAllUserChats() {
        viewModelScope.launch {
            _uiState.value = MessagesScreenState.Loading
            try {
                val chatsList = FakeChatRepository.getChatsList()
                _uiState.value = MessagesScreenState.Success(chatsList)
            } catch (e: Exception) {
                _uiState.value = MessagesScreenState.Error(e.message ?: "Unknown Error")
            }
        }
    }

}

sealed interface MessagesScreenState {
    data object Loading : MessagesScreenState
    data class Error(val message: String): MessagesScreenState
    data class Success(val chatsList: List<Chat>): MessagesScreenState
}