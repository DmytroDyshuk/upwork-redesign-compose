package com.dyshuk.android.upworkredesigncompose.ui.components.indicators

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun StarRating(
    modifier: Modifier = Modifier,
    rating: Int,
    maxRating: Int = 5,
    showTextRating: Boolean = false
) {
    Row(
        modifier = modifier
    ) {
        for (i in 1..maxRating) {
            val starColor = if (i <= rating) {
                Color(0xFFFFD700)
            } else {
                Color(0xFFD3D3D3)
            }
            Image(
                painter = painterResource(id = R.drawable.ic_vote_star),
                contentDescription = null,
                modifier = Modifier.size(11.dp),
                colorFilter = ColorFilter.tint(starColor)
            )
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
        StarRating(rating = 3, showTextRating = true)
    }
}