package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.data.repository.fakeFeedbackList
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.ui_state.FeedbackListState
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.CoralRed
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily
import kotlin.math.abs

@Composable
fun WorkHistoryBlock(modifier: Modifier = Modifier, feedbackListState: FeedbackListState) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Work History and Feedback",
                fontSize = 18.sp,
                fontFamily = rubikFamily,
                fontWeight = FontWeight.Bold,
                color = CharcoalGray
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_filter),
                contentDescription = null
            )
        }

        when (feedbackListState) {
            FeedbackListState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.padding(vertical = 15.dp))
            }

            is FeedbackListState.Error -> {
                Text(
                    modifier = Modifier.padding(vertical = 15.dp),
                    text = "Something went wrong, try again later :(",
                    fontFamily = rubikFamily,
                    fontWeight = FontWeight.Bold,
                    color = CoralRed,
                    fontSize = 16.sp
                )
            }

            is FeedbackListState.Success -> {
                val feedbackList = feedbackListState.feedbackList

                val listState = rememberLazyListState()

                val currentIndex by remember {
                    derivedStateOf {
                        val visibleItems = listState.layoutInfo.visibleItemsInfo
                        val center = listState.layoutInfo.viewportEndOffset / 2
                        visibleItems.minByOrNull {
                            abs(it.offset + it.size / 2 - center)
                        }?.index?.plus(1) ?: 1
                    }
                }

                LazyRow(
                    modifier = Modifier.padding(vertical = 10.dp),
                    contentPadding = PaddingValues(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    state = listState
                ) {
                    items(feedbackList) { item ->
                        WorkFeedbackItem(feedback = item)
                    }
                }

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = PrimaryGreen,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                fontFamily = rubikFamily
                            )
                        ) {
                            append("$currentIndex")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = CharcoalGray,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                fontFamily = rubikFamily
                            )
                        ) {
                            append("/${feedbackList.size}")
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkHistoryBlockPreview() {
    UpworkRedesignComposeTheme {
        WorkHistoryBlock(
            feedbackListState = FeedbackListState.Success(feedbackList = fakeFeedbackList)
        )
    }
}