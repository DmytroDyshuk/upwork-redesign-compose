package com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.theme.BrightGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.CoralRed
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun InappropriateFlagButton(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(45.dp)
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(10.dp),
                color = Color.Transparent
            )
            .border(
                width = 2.dp,
                color = BrightGray,
                shape = RoundedCornerShape(10.dp)
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(end = 5.dp),
            painter = painterResource(R.drawable.ic_red_flag),
            tint = Color.Unspecified,
            contentDescription = null
        )
        Text(
            text = "Flag is Inappropriate",
            style = MaterialTheme.typography.titleMedium,
            color = CoralRed
        )
    }
}

@Preview
@Composable
fun InappropriateFlagButtonPreview() {
    UpworkRedesignComposeTheme {
        InappropriateFlagButton()
    }
}