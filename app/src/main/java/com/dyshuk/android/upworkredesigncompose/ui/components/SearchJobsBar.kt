package com.dyshuk.android.upworkredesigncompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.SoftGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun SearchJobsBar(modifier: Modifier = Modifier, searchValue: String, onValueChange: (String) -> Unit) {
    Row(
        modifier = modifier
            .requiredHeight(45.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(Color.White)
            .border(width = 1.dp, color = SoftGray, shape = MaterialTheme.shapes.medium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UpworkDefaultIcon(
            modifier = Modifier.padding(start = 15.dp),
            imageVector = ImageVector.vectorResource(R.drawable.ic_search),
            contentDescription = "Search icon"
        )
        BasicTextField(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(weight = 1f),
            value = searchValue,
            onValueChange = {
                onValueChange(it)
            },
            singleLine = true,
            textStyle = TextStyle(
                color = CharcoalGray,
                fontSize = 14.sp,
                fontFamily = rubikFamily
            ),
            decorationBox = { innerTextField ->
                if (searchValue.isEmpty()) {
                    Text(
                        text = "Search for Jobs",
                        fontFamily = rubikFamily,
                        fontSize = 14.sp,
                        color = LightSilver
                    )
                }
                innerTextField()
            }
        )
        UpworkDefaultIcon(
            modifier = Modifier.padding(end = 15.dp),
            imageVector = ImageVector.vectorResource(R.drawable.ic_settings),
            contentDescription = "Setting icon"
        )
    }
}

@Preview
@Composable
fun SearchJobsBarPreview() {
    UpworkRedesignComposeTheme {
        SearchJobsBar(searchValue = "Search Value") { }
    }
}