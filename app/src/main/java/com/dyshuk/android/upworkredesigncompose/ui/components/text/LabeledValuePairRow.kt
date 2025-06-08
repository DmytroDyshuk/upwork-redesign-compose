package com.dyshuk.android.upworkredesigncompose.ui.components.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun LabeledValuePairRow(
    modifier: Modifier = Modifier,
    mainText: String,
    secondaryText: String,
    mainColor: Color = CharcoalGray,
    secondaryColor: Color = LightSilver
) {
    Row(modifier = modifier) {
        Text(
            modifier = Modifier.padding(end = 10.dp),
            text = mainText,
            style = MaterialTheme.typography.titleSmall,
            color = mainColor
        )
        Text(
            text = secondaryText,
            style = MaterialTheme.typography.titleSmall,
            color = secondaryColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LabeledValuePairRowPreview() {
    UpworkRedesignComposeTheme {
        LabeledValuePairRow(
            mainText = "United States",
            secondaryText = "Tampa 02:32 PM"
        )
    }
}