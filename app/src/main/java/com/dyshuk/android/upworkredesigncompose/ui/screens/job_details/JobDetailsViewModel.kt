package com.dyshuk.android.upworkredesigncompose.ui.screens.job_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.data.repository.FakeJobRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JobDetailsViewModel : ViewModel() {

    private val _jobDetails = MutableStateFlow<JobDetailsState>(JobDetailsState.Idle)
    val jobDetails = _jobDetails.asStateFlow()

    fun getJobById(id: Int) {
        viewModelScope.launch {
            _jobDetails.value = JobDetailsState.Loading
            try {
                val job = FakeJobRepository.getJobById(id)
                _jobDetails.value =
                    job?.let { JobDetailsState.Success(it) } ?: JobDetailsState.Error("Something went wrong")
            } catch (e: Exception) {
                _jobDetails.value = JobDetailsState.Error(e.message ?: "Unknown error")
            }
        }
    }

}

sealed interface JobDetailsState {
    data object Idle : JobDetailsState
    data object Loading : JobDetailsState
    data class Error(val message: String) : JobDetailsState
    data class Success(val job: Job) : JobDetailsState
}