package com.dyshuk.android.upworkredesigncompose.ui.screens.job_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.data.model.Job
import com.dyshuk.android.upworkredesigncompose.ui.components.buttons.FavouriteButton
import com.dyshuk.android.upworkredesigncompose.ui.components.text.RoundedTag
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SilverGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.SkyBlue
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite

@Composable
fun JobDescriptionBlock(modifier: Modifier = Modifier, job: Job, onBackPressed: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.padding(end = 35.dp, top = 17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 15.dp, end = 9.dp)
                    .clickable {
                        onBackPressed()
                    },
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_back),
                contentDescription = "Back arrow",
                tint = PrimaryGreen
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    modifier = Modifier,
                    text = job.postedTime,
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
            FavouriteButton {
                //TODO: Favourite  button clicked
            }
        }

        Spacer(Modifier.height(5.dp))

        Text(
            modifier = Modifier.padding(start = 34.dp),
            text = job.title,
            color = CharcoalGray,
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp)
        ) {
            RoundedTag(text = "Ongoing project", textColor = SilverGray)
            Spacer(Modifier.width(29.dp))
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = SkyBlue)) {
                        append("6")
                    }
                    withStyle(style = SpanStyle(color = SilverGray)) {
                        append(" / 126 Connects Required")
                    }
                },
                modifier = Modifier
                    .background(
                        color = SnowWhite,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(horizontal = 9.dp, vertical = 4.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }

        Spacer(Modifier.height(12.dp))

        Text(
            modifier = Modifier.padding(horizontal = 35.dp),
            text = job.description,
            color = CharcoalGray,
            style = MaterialTheme.typography.bodyMedium,
        )

        Spacer(Modifier.height(10.dp))

        Row(modifier = Modifier.padding(horizontal = 35.dp)) {
            RoundedTag(text = job.timeRequirement, textColor = SilverGray)
            Spacer(Modifier.width(5.dp))
            RoundedTag(text = job.duration, textColor = SilverGray)
        }

        Spacer(Modifier.height(25.dp))
    }
}