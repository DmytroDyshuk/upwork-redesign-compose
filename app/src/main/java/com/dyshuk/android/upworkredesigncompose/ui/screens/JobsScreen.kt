package com.dyshuk.android.upworkredesigncompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.dyshuk.android.upworkredesigncompose.ui.components.UpworkDefaultIcon
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.SoftGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun JobsScreen() {
    JobsTopBar()
}

@Composable
fun JobsTopBar(modifier: Modifier = Modifier) {
    var jobsSearchValue by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchJobsBar(modifier = Modifier.weight(1f), searchValue = jobsSearchValue) {
            jobsSearchValue = it
        }

        Spacer(modifier = Modifier.width(10.dp))

        Button(
            modifier = Modifier.size(35.dp),
            contentPadding = PaddingValues(0.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 1.dp,
                pressedElevation = 0.dp
            ),
            onClick = {

            }
        ) {
            UpworkDefaultIcon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_star),
                contentDescription = "Search icon"
            )
        }
    }
}

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

@Preview(showBackground = true)
@Composable
fun SearchForJobsBarPreview() {
    UpworkRedesignComposeTheme {
        JobsTopBar()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewJobsScreen() {
    UpworkRedesignComposeTheme {
        JobsScreen()
    }
}