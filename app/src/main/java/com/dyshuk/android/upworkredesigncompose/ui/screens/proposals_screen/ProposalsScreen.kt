package com.dyshuk.android.upworkredesigncompose.ui.screens.proposals_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.components.buttons.SwitchButton
import com.dyshuk.android.upworkredesigncompose.ui.screens.proposals_screen.components.ProposalsButton
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun ProposalsScreen(modifier: Modifier = Modifier) {
    ProposalsContent(
        modifier = modifier.padding(
            top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
        )
    )
}

@Composable
fun ProposalsContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.padding(start = 35.dp, top = 20.dp),
            text = "Proposals",
            style = MaterialTheme.typography.titleLarge,
            color = CharcoalGray
        )
        SwitchButton(
            modifier = Modifier.padding(start = 15.dp, top = 15.dp, end = 15.dp),
            buttons = listOf("Active", "Archived"),
            height = 35.dp,
            textSize = 14.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        ProposalsButton(
            icon = ImageVector.vectorResource(R.drawable.ic_offer),
            title = "Offers",
            count = 1
        )
        ProposalsButton(
            modifier = Modifier.padding(top = 5.dp),
            icon = ImageVector.vectorResource(R.drawable.ic_invite),
            title = "Invitations to Interview",
            count = 5
        )
        ProposalsButton(
            modifier = Modifier.padding(top = 5.dp),
            icon = ImageVector.vectorResource(R.drawable.ic_active),
            title = "Active Proposals",
            count = 12
        )
        ProposalsButton(
            modifier = Modifier.padding(top = 5.dp),
            icon = ImageVector.vectorResource(R.drawable.ic_submited),
            title = "Submited Proposals",
            count = 37
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProposalsContent() {
    UpworkRedesignComposeTheme {
        ProposalsContent()
    }
}