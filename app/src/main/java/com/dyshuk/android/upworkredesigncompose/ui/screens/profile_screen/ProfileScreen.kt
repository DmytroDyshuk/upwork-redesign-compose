package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.components.ArcProgressBarWithImage
import com.dyshuk.android.upworkredesigncompose.ui.components.LabeledIconButton
import com.dyshuk.android.upworkredesigncompose.ui.components.SwitchButton
import com.dyshuk.android.upworkredesigncompose.ui.components.VerifiedBadge
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

@Composable
fun ProfileScreen() {
    ProfileScreenContent()
}

@Composable
fun ProfileScreenContent(modifier: Modifier = Modifier) {
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
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
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

            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            ) {
                Spacer(Modifier.height(13.dp))

                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = stringResource(id = R.string.mock_profile_title),
                    color = CharcoalGray,
                    fontWeight = FontWeight.Bold,
                    fontFamily = rubikFamily,
                    fontSize = 18.sp
                )

                Spacer(Modifier.height(8.dp))

                ExpandingDescriptionText(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    description = stringResource(id = R.string.mock_profile_description)
                ) { }

                Spacer(Modifier.height(15.dp))

                PlayVideoButton(modifier = Modifier.padding(horizontal = 20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {
                    ProfileStatsBox(
                        count = "$ 45.00", title = "hourly rate"
                    )
                    ProfileStatsBox(
                        count = "$ 200k+", title = "earned"
                    )
                }
            }

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
                    title = "English",
                    status = "Fluent"
                )
                VerificationStatusText(
                    modifier = Modifier
                        .padding(horizontal = 20.dp),
                    title = "English",
                    status = "Fluent"
                )
                VerificationStatusText(
                    modifier = Modifier
                        .padding(horizontal = 20.dp),
                    title = "Ukrainian",
                    status = "Native or Bilingual"
                )
                VerificationStatusText(
                    modifier = Modifier
                        .padding(horizontal = 20.dp),
                    title = "German",
                    status = "Basic",
                    showBadge = false
                )

                Spacer(Modifier.height(7.dp))
            }

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

@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    collapseProgress: Float,
    earningAmount: String = "3,289"
) {
    val localConfiguration = LocalConfiguration.current
    val localScreenWidth = localConfiguration.screenWidthDp.dp
    val localScreenHeight = localConfiguration.screenHeightDp.dp

    val density = LocalDensity.current
    val offsetX = with(density) { (localScreenWidth * 0.35f).toPx() }
    val offsetY = with(density) { (localScreenHeight * 0.01f).toPx() }

    val offsetXAnimated by animateFloatAsState(targetValue = offsetX * collapseProgress)
    val offsetYAnimated by animateFloatAsState(targetValue = offsetY * collapseProgress)

    Box(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = PrimaryGreen,
                    shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .graphicsLayer {
                            translationX = -offsetXAnimated
                            translationY = offsetYAnimated
                        },
                    text = "Earnings Available:",
                    color = CharcoalGray,
                    fontSize = 10.sp,
                    fontFamily = rubikFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .graphicsLayer {
                            translationX = offsetXAnimated
                            translationY = -offsetYAnimated
                        },
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xB3FFFFFF),
                                fontSize = 14.sp,
                                fontFamily = rubikFamily,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("$ ")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFFFFFFFF),
                                fontSize = 18.sp,
                                fontFamily = rubikFamily,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append(earningAmount)
                        }
                    }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProfileScreenContentPreview() {
    ProfileScreenContent()
}