package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.data.model.Feedback
import com.dyshuk.android.upworkredesigncompose.ui.components.indicators.StarRating
import com.dyshuk.android.upworkredesigncompose.ui.components.text.RoundedTag
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun WorkFeedbackItem(modifier: Modifier = Modifier, feedback: Feedback) {
    Column(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(10.dp),
                color = Color.White
            )
            .padding(20.dp)
    ) {
        Row {
            StarRating(
                rating = feedback.rating,
                showTextRating = true
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = feedback.time,
                fontSize = 10.sp,
                fontFamily = rubikFamily,
                fontWeight = FontWeight.W500,
                color = LightSilver
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = feedback.title,
            fontSize = 14.sp,
            fontFamily = rubikFamily,
            fontWeight = FontWeight.W500,
            color = PrimaryGreen,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = feedback.description,
            fontSize = 12.sp,
            fontFamily = rubikFamily,
            fontWeight = FontWeight.W400,
            color = CharcoalGray,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundedTag(
                text = feedback.budget,
                textColor = CharcoalGray
            )
            RoundedTag(
                text = feedback.rate,
                textColor = CharcoalGray
            )
            RoundedTag(
                text = feedback.estimate,
                textColor = CharcoalGray
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun WorkFeedbackItemPreview() {
    UpworkRedesignComposeTheme {
        WorkFeedbackItem(
            feedback = Feedback(
                time = "Nov 2018 - Sep 2019",
                rating = 4.5f,
                title = "Upwork Redesign Project",
                description = "Very talented. Completed task according to specification.",
                budget = "\$1,480.00",
                rate = "\$45.00/Hr",
                estimate = "39 Hours"
            )
        )
    }
}