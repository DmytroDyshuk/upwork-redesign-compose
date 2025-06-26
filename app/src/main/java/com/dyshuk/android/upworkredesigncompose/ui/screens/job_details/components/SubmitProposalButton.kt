package com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.ui.components.buttons.FilledDefaultButton
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun SubmitProposalButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .height(92.dp),
        contentAlignment = Alignment.Center
    ) {
        FilledDefaultButton(
            modifier = Modifier.padding(horizontal = 35.dp),
            text = "Submit Proposal",
            onClick = {
                onClick()
            }
        )
    }
}

@Preview
@Composable
fun SubmitProposalButtonPreview() {
    UpworkRedesignComposeTheme {
        SubmitProposalButton(onClick = {})
    }
}