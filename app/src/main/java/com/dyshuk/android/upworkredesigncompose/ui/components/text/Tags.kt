package com.dyshuk.android.upworkredesigncompose.ui.components.text

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SilverGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.SkyBlue
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite

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
fun RoundedTag(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Color.Unspecified,
    backgroundColor: Color = SnowWhite
) {
    Text(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 9.dp, vertical = 4.dp),
        text = text,
        color = textColor,
        style = MaterialTheme.typography.headlineSmall,
    )
}

@Composable
fun SpendTag(spend: String) {
    val spendText = buildAnnotatedString {
        append(AnnotatedString(text = spend, spanStyle = SpanStyle(color = CharcoalGray)))
        append(AnnotatedString(text = " Spend", spanStyle = SpanStyle(color = SilverGray)))
    }

    Text(
        modifier = Modifier
            .background(
                color = SnowWhite,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 9.dp, vertical = 4.dp),
        text = spendText,
        style = MaterialTheme.typography.headlineSmall,
    )
}

@Composable
fun PaymentVerifiedBadge() {
    Row(
        modifier = Modifier
            .background(
                color = SkyBlue,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 4.dp)
            .padding(start = 4.dp, end = 9.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_verified),
            contentDescription = "Verified icon"
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = "Payment verified",
            style = MaterialTheme.typography.labelMedium,
            color = Color.White
        )
    }
}