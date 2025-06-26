package com.dyshuk.android.upworkredesigncompose.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun PlayVideoButton(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .height(35.dp)
            .fillMaxWidth()
            .background(color = Color.Transparent, shape = RoundedCornerShape(10.dp))
            .border(width = 2.dp, color = SnowWhite, shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_play_circle),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = "Play Video",
            color = PrimaryGreen,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            fontFamily = rubikFamily
        )
    }
}

@Preview
@Composable
fun PlayVideoButtonPreview() {
    UpworkRedesignComposeTheme {
        PlayVideoButton()
    }
}