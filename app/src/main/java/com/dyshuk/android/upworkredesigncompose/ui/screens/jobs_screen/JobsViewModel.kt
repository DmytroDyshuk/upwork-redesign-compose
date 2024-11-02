package com.dyshuk.android.upworkredesigncompose.ui.screens.jobs_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.data.repository.FakeJobRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class JobsViewModel : ViewModel() {

    private val _jobsList: MutableStateFlow<List<Job>> = MutableStateFlow(listOf())
    val jobsList: StateFlow<List<Job>> = _jobsList

    init {
        fetchJobsList()
    }

    private fun fetchJobsList() {
        viewModelScope.launch {
            _jobsList.value = FakeJobRepository.getJobs()
        }
    }

}