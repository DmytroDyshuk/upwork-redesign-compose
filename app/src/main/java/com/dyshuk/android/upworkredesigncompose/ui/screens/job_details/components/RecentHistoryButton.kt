package com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun RecentHistoryButton(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(55.dp)
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(15.dp),
                color = Color.White
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(start = 15.dp, end = 4.dp)
                .background(
                    color = SnowWhite,
                    shape = RoundedCornerShape(5.dp)
                )
                .height(25.dp)
                .width(25.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = PrimaryGreen,
                        shape = RoundedCornerShape(3.dp)
                    )
                    .height(15.dp)
                    .width(15.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_history),
                    contentDescription = "History icon"
                )
            }
        }
        Text(
            text = "Client's Recent History",
            style = MaterialTheme.typography.bodyLarge,
            color = CharcoalGray
        )
        Spacer(Modifier.weight(1f))
        Icon(
            modifier = Modifier.padding(end = 20.dp),
            painter = painterResource(R.drawable.ic_drop_arrow),
            tint = Color.Unspecified,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun RecentHistoryButtonPreview() {
    UpworkRedesignComposeTheme {
        RecentHistoryButton()
    }
}