package com.dyshuk.android.upworkredesigncompose.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SilverGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun ExpandingDescriptionText(
    modifier: Modifier = Modifier,
    minLines: Int = 7,
    maxLines: Int = 17,
    textColor: Color = SilverGray,
    fontWeight: FontWeight = FontWeight.W400,
    fontSize: TextUnit = 12.sp,
    description: String, onTextClicked: () -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Column(modifier = modifier) {
        Text(
            modifier = Modifier
                .animateContentSize()
                .clickable {
                    onTextClicked()
                },
            text = description,
            fontFamily = rubikFamily,
            fontWeight = fontWeight,
            fontSize = fontSize,
            maxLines = if (!expanded) minLines else maxLines,
            lineHeight = 18.sp,
            color = textColor,
            overflow = TextOverflow.Ellipsis,
        )
        if (description.length > 250) {
            Spacer(Modifier.height(5.dp))
            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .background(color = SnowWhite, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp, vertical = 3.dp)
                    .clickable {
                        expanded = !expanded
                    },
                text = if (!expanded) "More" else "Less",
                color = PrimaryGreen,
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
}