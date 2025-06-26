package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.ui_state

import com.dyshuk.android.upworkredesigncompose.data.model.Feedback

sealed interface FeedbackListState {
    data object Loading : FeedbackListState
    data class Success(val feedbackList: List<Feedback>) : FeedbackListState
    data class Error(val message: String) : FeedbackListState
}