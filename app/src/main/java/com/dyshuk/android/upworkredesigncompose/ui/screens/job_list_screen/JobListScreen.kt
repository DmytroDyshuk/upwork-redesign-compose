package com.dyshuk.android.upworkredesigncompose.ui.screens.job_list_screen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.ui.components.status.ErrorScreen
import com.dyshuk.android.upworkredesigncompose.ui.components.status.LoadingScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.components.JobSearchTopBar
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import kotlinx.coroutines.launch

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
    val coroutineScope = rememberCoroutineScope()

    val showScrollTopButton by remember {
        derivedStateOf {
            jobListState.firstVisibleItemIndex > 0
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            AnimatedVisibility(
                visible = showScrollTopButton,
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut()
            ) {
                FloatingActionButton(
                    modifier = Modifier.padding(bottom = 70.dp),
                    containerColor = PrimaryGreen,
                    onClick = {
                        coroutineScope.launch {
                            jobListState.animateScrollToItem(index = 0)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = null
                    )
                }
            }
        }
    ) {
        LazyColumn(
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

}