package com.dyshuk.android.upworkredesigncompose.ui.screens.jobs_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite

@Composable
fun JobListItem(job: Job) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(10.dp)
            }
            .clip(MaterialTheme.shapes.small)
            .background(Color.White)
            .requiredHeight(270.dp)
    ) {
        val isFeaturedJob = job.isFeatured

        if (isFeaturedJob) {
            FeaturedJobBadge()
        }

        Spacer(Modifier.height(if (isFeaturedJob) 9.dp else 19.dp))

        Row(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    modifier = Modifier,
                    text = "Hourly - Posted ${job.postedTime}",
                    color = LightSilver,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    modifier = Modifier,
                    text = job.title,
                    color = PrimaryGreen,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(Modifier.width(22.dp))
            Button(
                modifier = Modifier.size(30.dp),
                contentPadding = PaddingValues(0.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = SnowWhite),
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.size(10.dp),
                    imageVector = ImageVector.vectorResource(R.drawable.ic_star),
                    contentDescription = "Search icon",
                    tint = LightSilver
                )
            }
            Spacer(Modifier.width(5.dp))
            Button(
                modifier = Modifier.size(30.dp),
                contentPadding = PaddingValues(0.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = SnowWhite),
                onClick = {}
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_close),
                    contentDescription = "Search icon",
                    tint = LightSilver
                )
            }

        }

        Row(modifier = Modifier.padding(horizontal = 20.dp, vertical = 11.dp)) {
            JobTag(job.timeRequirement)
            Spacer(Modifier.width(5.dp))
            JobTag(job.duration)
        }

    }
}

@Composable
fun FeaturedJobBadge() {
    Box(
        modifier = Modifier
            .background(
                color = PrimaryGreen,
                shape = RoundedCornerShape(
                    topStart = 10.dp,
                    bottomStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 10.dp
                )
            )
            .padding(vertical = 6.dp, horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_puzzle),
                contentDescription = "puzzle icon",
                tint = Color.White,
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = "Feature Job",
                fontSize = 11.sp,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        }
    }
}

@Composable
fun JobTag(text: String) {
    Text(
        modifier = Modifier
            .background(
                color = SnowWhite,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 9.dp, vertical = 4.dp),
        text = text,
        color = CharcoalGray,
        style = MaterialTheme.typography.headlineSmall,
    )
}