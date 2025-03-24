package com.dyshuk.android.upworkredesigncompose.ui.screens.proposals_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.ui.components.SwitchButton
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun ProposalsScreen(modifier: Modifier = Modifier) {
    ProposalsContent(modifier = modifier)
}

@Composable
fun ProposalsContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Proposals",
            style = MaterialTheme.typography.titleLarge,
            color = CharcoalGray
        )
        SwitchButton(modifier = Modifier.padding(horizontal = 15.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProposalsContent() {
    UpworkRedesignComposeTheme {
        ProposalsContent()
    }
}