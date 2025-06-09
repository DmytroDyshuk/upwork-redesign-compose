package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyshuk.android.upworkredesigncompose.data.repository.FakeFeedbackRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenState())
    val uiState: StateFlow<ProfileScreenState> = _uiState.asStateFlow()

    init {
        fetchFeedbackList()
    }

    private fun fetchFeedbackList() {
        viewModelScope.launch {
            _uiState.update { it.copy(feedbackListState = FeedbackListState.Loading) }
            try {
                val feedbackList = FakeFeedbackRepository.getFeedbackList()
                _uiState.update { it.copy(feedbackListState = FeedbackListState.Success(feedbackList)) }
            } catch (e: Exception) {
                _uiState.update { it.copy(feedbackListState = FeedbackListState.Error("Loading Error: ${e.message}")) }
            }
        }
    }

}