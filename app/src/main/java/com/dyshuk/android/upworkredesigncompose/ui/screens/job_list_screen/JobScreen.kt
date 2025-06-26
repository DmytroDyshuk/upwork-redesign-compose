package com.dyshuk.android.upworkredesigncompose.ui.screens.job_list_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.ui.components.SearchJobsBar
import com.dyshuk.android.upworkredesigncompose.ui.components.UpworkDefaultIcon
import com.dyshuk.android.upworkredesigncompose.ui.components.status.ErrorScreen
import com.dyshuk.android.upworkredesigncompose.ui.components.status.LoadingScreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

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
            JobTopBar()
        }

        items(jobList) { job: Job ->
            JobListItem(job = job, onJobCLicked = onJobClicked)
        }

        item {
            Spacer(Modifier.height(70.dp))
        }
    }
}

@Composable
fun JobTopBar(modifier: Modifier = Modifier) {
    var jobSearchValue by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchJobsBar(modifier = Modifier.weight(1f), searchValue = jobSearchValue) {
            jobSearchValue = it
        }

        Spacer(modifier = Modifier.width(10.dp))

        Button(
            modifier = Modifier.size(35.dp),
            contentPadding = PaddingValues(0.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 1.dp,
                pressedElevation = 0.dp
            ),
            onClick = {}
        ) {
            UpworkDefaultIcon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_green_star),
                contentDescription = "Search icon"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SearchForJobBarPreview() {
    UpworkRedesignComposeTheme {
        JobTopBar()
    }
}