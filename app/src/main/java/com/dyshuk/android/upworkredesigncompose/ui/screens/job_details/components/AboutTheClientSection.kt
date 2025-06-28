package com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.ui.components.indicators.StarRating
import com.dyshuk.android.upworkredesigncompose.ui.components.text.LabeledValuePairRow
import com.dyshuk.android.upworkredesigncompose.ui.components.text.PaymentVerifiedBadge
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun AboutTheClient(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(15.dp),
                color = Color.White
            )
            .padding(horizontal = 20.dp, vertical = 17.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = "About the Client",
            style = MaterialTheme.typography.headlineMedium,
            color = CharcoalGray
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            PaymentVerifiedBadge()
            Row {
                StarRating(rating = 4.5f)
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "4.5 of 12 Review",
                    style = MaterialTheme.typography.bodySmall,
                    color = CharcoalGray
                )
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(11.dp)) {
            LabeledValuePairRow(mainText = "United States", secondaryText = "Tampa 02:32 PM")
            LabeledValuePairRow(
                mainText = "25 Jobs Posted",
                secondaryText = "80% Hire Rate, 1 Job Open"
            )
            LabeledValuePairRow(
                mainText = "\$ 200M+ Total Spent",
                secondaryText = "372 Hires, 55 Active"
            )
            LabeledValuePairRow(
                mainText = "\$ 37.25 Avg Hourly Rate Paid",
                secondaryText = "110,152 Hours"
            )
        }
    }
}

@Preview
@Composable
fun AboutTheClientPreview() {
    UpworkRedesignComposeTheme {
        AboutTheClient()
    }
}