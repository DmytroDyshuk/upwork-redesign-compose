package com.dyshuk.android.upworkredesigncompose.ui.components.indicators

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun StarRating(
    modifier: Modifier = Modifier,
    rating: Float,
    maxRating: Int = 5,
    starSize: Dp = 11.dp,
    showTextRating: Boolean = false
) {
    Row(
        modifier = modifier
    ) {
        for (i in 1..maxRating) {
            val fillFraction = rating - (i - 1)

            Box(modifier = Modifier.size(starSize)) {
                Image(
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RectangleShape),
                    painter = painterResource(id = R.drawable.ic_vote_star),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RectangleShape)
                        .drawWithContent {
                            val clipWidth = size.width * fillFraction
                            clipRect(
                                left = 0f,
                                top = 0f,
                                bottom = size.height,
                                right = clipWidth
                            ) {
                                this@drawWithContent.drawContent()
                            }
                        },
                    painter = painterResource(id = R.drawable.ic_vote_star),
                    colorFilter = ColorFilter.tint(color = Color(0xFFFFBA49)),
                    contentDescription = null
                )
            }
        }

        if (showTextRating) {
            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = rating.toString(),
                fontFamily = rubikFamily,
                fontSize = 10.sp,
                fontWeight = FontWeight.W500,
                color = CharcoalGray
            )
        }
    }
}

@Preview
@Composable
fun StarRatingPreview() {
    UpworkRedesignComposeTheme {
        StarRating(rating = 4.5f, showTextRating = true)
    }
}