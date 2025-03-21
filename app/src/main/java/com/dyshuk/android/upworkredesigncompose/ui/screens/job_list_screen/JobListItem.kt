package com.dyshuk.android.upworkredesigncompose.ui.screens.job_list_screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.ui.components.FavouriteButton
import com.dyshuk.android.upworkredesigncompose.ui.components.FeaturedJobBadge
import com.dyshuk.android.upworkredesigncompose.ui.components.JobTag
import com.dyshuk.android.upworkredesigncompose.ui.components.PaymentVerifiedBadge
import com.dyshuk.android.upworkredesigncompose.ui.components.SpendTag
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SilverGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite

@Composable
fun JobListItem(job: Job, onJobCLicked: (id: Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(10.dp)
            }
            .clip(MaterialTheme.shapes.small)
            .background(Color.White)
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
            FavouriteButton {
                //Button clicked
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

        Spacer(Modifier.height(8.dp))

        Row(modifier = Modifier.padding(horizontal = 20.dp)) {
            JobTag(text = job.timeRequirement, textColor = CharcoalGray)
            Spacer(Modifier.width(5.dp))
            JobTag(text = job.duration, textColor = CharcoalGray)
        }

        Spacer(Modifier.height(8.dp))

        ExpandingDescriptionText(job.description) {
            onJobCLicked(job.id)
        }

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 20.dp)
        ) {
            if (job.isPaymentVerified) {
                PaymentVerifiedBadge()
                Spacer(Modifier.width(5.dp))
            }
            SpendTag(job.spend)
        }
    }
}



@Composable
fun ExpandingDescriptionText(description: String, onTextClicked: () -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .animateContentSize()
                .clickable {
                    onTextClicked()
                },
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = if (!expanded) 7 else 17,
            lineHeight = 18.sp,
            color = SilverGray,
            overflow = TextOverflow.Ellipsis,
        )
        if (description.length > 250) {
            Spacer(Modifier.height(5.dp))
            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .background(color = SnowWhite, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp, vertical = 3.dp)
                    .clickable {
                        expanded = !expanded
                    },
                text = if (!expanded) "More" else "Less",
                color = PrimaryGreen,
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
}