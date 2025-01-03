package com.dyshuk.android.upworkredesigncompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun StarRating(modifier: Modifier = Modifier, rating: Int, maxRating: Int = 5) {
    Row(
        modifier = modifier
    ) {
        for (i in 1..maxRating) {
            val starColor = if (i <= rating) Color(0xFFFFD700) else Color(0xFFD3D3D3)
            Image(
                painter = painterResource(id = R.drawable.ic_vote_star),
                contentDescription = null,
                modifier = Modifier.size(11.dp),
                colorFilter = ColorFilter.tint(starColor)
            )
        }
    }
}

@Preview
@Composable
fun StarRatingPreview() {
    UpworkRedesignComposeTheme {
        StarRating(rating = 3)
    }
}