package com.dyshuk.android.upworkredesigncompose.ui.screens.job_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.data.repository.FakeJobRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class JobListViewModel : ViewModel() {

    private val _jobList: MutableStateFlow<List<Job>> = MutableStateFlow(listOf())
    val jobList: StateFlow<List<Job>> = _jobList

    init {
        fetchJobList()
    }

    private fun fetchJobList() {
        viewModelScope.launch {
            _jobList.value = FakeJobRepository.getJobList()
        }
    }

}