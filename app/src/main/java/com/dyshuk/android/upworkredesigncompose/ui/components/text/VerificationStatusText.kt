package com.dyshuk.android.upworkredesigncompose.ui.components.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.ui.components.indicators.VerifiedBadge
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun VerificationStatusText(
    modifier: Modifier = Modifier,
    title: String,
    status: String,
    showBadge: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = CharcoalGray)) {
                    append(title)
                    append(": ")
                }
                withStyle(style = SpanStyle(color = LightSilver)) {
                    append(status)
                }
            },
            fontFamily = rubikFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.W500
        )

        if (showBadge) VerifiedBadge(modifier = Modifier.padding(start = 7.dp))
    }
}