package com.dyshuk.android.upworkredesigncompose.ui.screens.jobs_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen

@Composable
fun JobItem(job: Job) {
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
        FeaturedJobBadge()
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