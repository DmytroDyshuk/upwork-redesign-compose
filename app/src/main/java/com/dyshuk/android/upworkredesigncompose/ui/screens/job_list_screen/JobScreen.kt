package com.dyshuk.android.upworkredesigncompose.ui.screens.job_list_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.ui.components.status.ErrorScreen
import com.dyshuk.android.upworkredesigncompose.ui.components.status.LoadingScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.components.JobSearchTopBar

@Composable
fun JobListScreen(viewModel: JobListViewModel = viewModel(), onJobClicked: (jobId: Int) -> Unit) {
    val uiState by viewModel.uiState.collectAsState()

    JobListScreenContent(uiState = uiState, onJobClicked = onJobClicked)
}

@Composable
fun JobListScreenContent(
    modifier: Modifier = Modifier,
    uiState: JobListState,
    onJobClicked: (jobId: Int) -> Unit
) {
    when (uiState) {
        is JobListState.Error -> ErrorScreen()
        JobListState.Loading -> LoadingScreen()
        is JobListState.Success -> SuccessContent(
            modifier = modifier,
            jobList = uiState.jobList,
            onJobClicked = onJobClicked
        )
    }
}

@Composable
fun SuccessContent(modifier: Modifier = Modifier, jobList: List<Job>, onJobClicked: (Int) -> Unit) {
    val jobListState = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = jobListState,
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item {
            Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars))
        }

        item {
            JobSearchTopBar()
        }

        items(jobList) { job: Job ->
            JobListItem(job = job, onJobCLicked = onJobClicked)
        }

        item {
            Spacer(Modifier.height(70.dp))
        }
    }
}