package com.dyshuk.android.upworkredesigncompose.ui.screens.job_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.data.repository.FakeJobRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JobListViewModel : ViewModel() {

    private val _jobState: MutableStateFlow<JobListState> = MutableStateFlow(JobListState.Loading)
    val jobState: StateFlow<JobListState> = _jobState.asStateFlow()

    init {
        fetchJobList()
    }

    private fun fetchJobList() {
        viewModelScope.launch {
            _jobState.value = JobListState.Loading
            try {
                val jobList = FakeJobRepository.getJobList()
                _jobState.value = JobListState.Success(jobList)
            } catch (e: Exception) {
                _jobState.value = JobListState.Error(e.message ?: "Unknown Error")
            }
        }
    }

}

sealed interface JobListState {
    data object Loading : JobListState
    data class Error(val message: String) : JobListState
    data class Success(val jobList: List<Job>) : JobListState
}