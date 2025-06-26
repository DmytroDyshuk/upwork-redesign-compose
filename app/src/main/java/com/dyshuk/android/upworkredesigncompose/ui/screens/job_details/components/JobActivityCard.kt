package com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite

@Composable
fun JobActivityCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(15.dp),
                color = Color.White
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            JobActivityTag(count = "5 to 10", title = "PROPOSAL")
            Spacer(modifier = Modifier.width(15.dp))
            JobActivityTag(count = "6", title = "INTERVIEWING")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            JobActivityTag(count = "15", title = "INVITES SENT")
            Spacer(modifier = Modifier.width(15.dp))
            JobActivityTag(count = "4", title = "UNANSWERED INVITES")
        }
    }
}

@Composable
fun JobActivityTag(modifier: Modifier = Modifier, count: String, title: String) {
    Column(
        modifier = modifier
            .height(60.dp)
            .width(145.dp)
            .fillMaxWidth()
            .background(
                color = SnowWhite,
                shape = RoundedCornerShape(10.dp)
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count,
            color = CharcoalGray,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            color = LightSilver,
            style = MaterialTheme.typography.bodySmall
        )
    }
}