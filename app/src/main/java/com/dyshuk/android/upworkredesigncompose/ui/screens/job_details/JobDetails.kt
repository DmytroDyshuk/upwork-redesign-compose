package com.dyshuk.android.upworkredesigncompose.ui.screens.job_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.ui.components.status.ErrorScreen
import com.dyshuk.android.upworkredesigncompose.ui.components.status.LoadingScreen
import com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components.AboutTheClient
import com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components.InappropriateFlagButton
import com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components.JobActivityCard
import com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components.JobDescriptionSection
import com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components.RecentHistoryButton
import com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components.SkillsDescriptionSection
import com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components.SubmitProposalButton

@Composable
fun JobDetailsScreen(
    modifier: Modifier = Modifier,
    jobId: Int?,
    viewModel: JobDetailsViewModel = viewModel(),
    onBackPressed: () -> Unit,
    onSubmitPressed: () -> Unit
) {
    val jobDetailsState by viewModel.jobDetailsState.collectAsState()

    LaunchedEffect(jobId) {
        jobId?.let { viewModel.getJobById(it) }
    }

    JobDetailsScreenContent(
        modifier = modifier,
        jobDetailsState = jobDetailsState,
        onBackPressed = onBackPressed,
        onSubmitPressed = onSubmitPressed
    )
}

@Composable
fun JobDetailsScreenContent(
    modifier: Modifier = Modifier,
    jobDetailsState: JobDetailsState,
    onBackPressed: () -> Unit,
    onSubmitPressed: () -> Unit
) {
    when (jobDetailsState) {
        is JobDetailsState.Loading -> LoadingScreen()
        is JobDetailsState.Error -> ErrorScreen(message = jobDetailsState.message)
        is JobDetailsState.Success -> JobDetailsSuccessContent(
            modifier = modifier,
            job = jobDetailsState.job,
            onSubmitPressed = onSubmitPressed,
            onBackPressed = onBackPressed
        )
    }
}

@Composable
fun JobDetailsSuccessContent(
    modifier: Modifier = Modifier,
    job: Job,
    onSubmitPressed: () -> Unit,
    onBackPressed: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            SubmitProposalButton {
                onSubmitPressed()
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(state = scrollState),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            JobDescriptionSection(job = job, onBackPressed = onBackPressed)
            Column(
                modifier = Modifier.padding(horizontal = 15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                SkillsDescriptionSection(job = job)
                JobActivityCard()
                AboutTheClient()
                RecentHistoryButton()
                InappropriateFlagButton()
                Spacer(Modifier.height(15.dp))
            }
        }
    }
}