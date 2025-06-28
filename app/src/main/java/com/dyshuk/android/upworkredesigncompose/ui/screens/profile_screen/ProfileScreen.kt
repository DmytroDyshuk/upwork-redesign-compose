package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.data.repository.fakeFeedbackList
import com.dyshuk.android.upworkredesigncompose.ui.components.buttons.LabeledIconButton
import com.dyshuk.android.upworkredesigncompose.ui.components.buttons.SwitchButton
import com.dyshuk.android.upworkredesigncompose.ui.components.indicators.ArcProgressBarWithImage
import com.dyshuk.android.upworkredesigncompose.ui.components.indicators.VerifiedBadge
import com.dyshuk.android.upworkredesigncompose.ui.components.text.VerificationStatusText
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.components.ProfileDescriptionSection
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.components.ProfileHeader
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.components.VerificationsSection
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.components.WorkHistorySection
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.ui_state.FeedbackListState
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.ui_state.ProfileScreenState
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun ProfileScreen(viewModel: ProfileViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    ProfileScreenContent(uiState = uiState)
}

@Composable
fun ProfileScreenContent(modifier: Modifier = Modifier, uiState: ProfileScreenState) {
    ProfileScreenSuccessContent(modifier = modifier, feedbackListState = uiState.feedbackListState)
}

@Composable
fun ProfileScreenSuccessContent(
    modifier: Modifier = Modifier,
    feedbackListState: FeedbackListState
) {
    val headerMaxHeight = 100.dp
    val headerMinHeight = 65.dp
    val scrollState = rememberScrollState()

    val currentDensity = LocalDensity.current

    val maxOffsetPx = with(currentDensity) { (headerMaxHeight - headerMinHeight).toPx() }

    val collapseProgress by remember {
        derivedStateOf {
            (scrollState.value.toFloat() / maxOffsetPx).coerceIn(0f, 1f)
        }
    }

    val animatedHeightDp by animateDpAsState(
        targetValue = headerMaxHeight - (headerMaxHeight - headerMinHeight) * collapseProgress
    )

    Column(modifier = modifier.fillMaxSize()) {
        Spacer(
            modifier = Modifier
                .windowInsetsTopHeight(WindowInsets.statusBars)
                .fillMaxWidth()
                .background(color = PrimaryGreen)
        )
        ProfileHeader(
            modifier = Modifier.height(animatedHeightDp),
            collapseProgress = collapseProgress
        )

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White)
            ) {
                Spacer(modifier = Modifier.height(22.dp))

                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ArcProgressBarWithImage(
                        modifier = Modifier
                            .align(Alignment.Center),
                        jobSuccessScore = 98F,
                        image = R.drawable.tony_stark_ava
                    )

                    FloatingActionButton(
                        modifier = Modifier
                            .padding(end = 34.dp)
                            .shadow(elevation = 4.dp, shape = CircleShape)
                            .align(Alignment.CenterEnd)
                            .size(30.dp),
                        shape = CircleShape,
                        containerColor = PrimaryGreen,
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_edit),
                            contentDescription = null
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_vip),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 4.dp),
                            text = "Tony Stark",
                            color = CharcoalGray,
                            fontWeight = FontWeight.W900,
                            fontFamily = rubikFamily,
                            fontSize = 20.sp
                        )
                        VerifiedBadge()
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_location),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(start = 2.dp),
                            text = "Kyiv, Ukraine",
                            color = LightSilver,
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 35.dp, vertical = 23.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val buttons = listOf(
                        "my stats" to R.drawable.ic_stats,
                        "reports" to R.drawable.ic_reports,
                        "contracts" to R.drawable.ic_contracts,
                        "support" to R.drawable.ic_support,
                        "settings" to R.drawable.ic_settings
                    )
                    buttons.forEach { (label, icon) ->
                        LabeledIconButton(
                            label = label,
                            textColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            backgroundColor = SnowWhite,
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(icon),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                SwitchButton(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    buttons = listOf("General", "Product Design", "Mobile UX Design"),
                    textSize = 12.sp,
                    height = 25.dp,
                    colorBackground = SnowWhite
                )

                Spacer(modifier = Modifier.height(15.dp))
            }

            Spacer(modifier = Modifier.height(15.dp))

            ProfileDescriptionSection(modifier = Modifier.padding(horizontal = 15.dp))

            Spacer(Modifier.height(15.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            ) {
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 17.dp),
                    text = "Availability",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = rubikFamily,
                    color = CharcoalGray
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {
                    ProfileStatsBox(
                        count = "> 30", title = "hrs per week"
                    )
                    ProfileStatsBox(
                        count = "< 24", title = "hrs response time"
                    )
                }
            }

            Spacer(Modifier.height(15.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 17.dp),
                    text = "Verifications",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = rubikFamily,
                    color = CharcoalGray
                )

                VerificationStatusText(
                    modifier = Modifier
                        .padding(horizontal = 20.dp),
                    title = "Phone Number",
                    status = "Verified"
                )

                Spacer(Modifier.height(7.dp))
            }

            Spacer(Modifier.height(15.dp))

            VerificationsSection(modifier = Modifier.padding(horizontal = 15.dp))

            Spacer(Modifier.height(18.dp))

            WorkHistorySection(feedbackListState = feedbackListState)

            Spacer(Modifier.height(100.dp))
        }
    }
}

@Composable
fun ProfileStatsBox(modifier: Modifier = Modifier, count: String, title: String) {
    Column(
        modifier = modifier
            .size(width = 145.dp, height = 60.dp)
            .background(color = SnowWhite, shape = RoundedCornerShape(10.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count,
            fontWeight = FontWeight.Bold,
            color = CharcoalGray,
            fontSize = 18.sp,
            fontFamily = rubikFamily
        )
        Text(
            text = title.uppercase(),
            fontWeight = FontWeight.W500,
            fontSize = 10.sp,
            color = LightSilver,
            fontFamily = rubikFamily
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenSuccessContentPreview() {
    UpworkRedesignComposeTheme {
        ProfileScreenSuccessContent(
            feedbackListState = FeedbackListState.Success(feedbackList = fakeFeedbackList)
        )
    }
}

@Preview
@Composable
fun ProfileStatsBoxPreview() {
    UpworkRedesignComposeTheme {
        ProfileStatsBox(count = ">54", title = "Stats title")
    }
}