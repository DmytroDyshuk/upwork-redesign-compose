package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen

import com.dyshuk.android.upworkredesigncompose.data.model.Feedback

data class ProfileScreenState(
    val feedbackListState: FeedbackListState = FeedbackListState.Loading
)

sealed interface FeedbackListState {
    data object Loading: FeedbackListState
    data class Success(val feedbackList: List<Feedback>): FeedbackListState
    data class Error(val message: String): FeedbackListState
}