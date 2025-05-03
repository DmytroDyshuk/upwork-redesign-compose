package com.dyshuk.android.upworkredesigncompose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.theme.BrightGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.SkyBlue
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily
import kotlinx.coroutines.launch

@Composable
fun ArcProgressBarWithImage(
    modifier: Modifier = Modifier,
    jobSuccessScore: Float = 0f,
    @DrawableRes image: Int = R.drawable.tony_stark_ava
) {
    val progressLimit = 300f

    val targetAnimatedValue = (progressLimit / 100f) * jobSuccessScore
    val progressAnimate = remember { Animatable(0f) }
    val jobSuccessAnimate = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(jobSuccessScore) {
        coroutineScope.launch {
            progressAnimate.animateTo(
                targetValue = targetAnimatedValue,
                animationSpec = tween(durationMillis = 1500)
            )
        }

        coroutineScope.launch {
            jobSuccessAnimate.animateTo(
                targetValue = jobSuccessScore,
                animationSpec = tween(durationMillis = 1500)
            )
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(175.dp)
        ) {
            PointProgress(
                progressLimit = progressLimit,
                progress = { progressAnimate.value }
            )
            Image(
                modifier = Modifier
                    .size(145.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center),
                painter = painterResource(image),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop
            )
        }
        JobSuccessScore(
            modifier = Modifier.offset(y = (-30).dp),
            score = { jobSuccessAnimate.value }
        )
    }

}

@Composable
fun JobSuccessScore(
    modifier: Modifier = Modifier,
    score: () -> Float
) {
    Column(
        modifier = modifier
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(16.dp))
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${score().toInt()}%",
            color = CharcoalGray,
            fontFamily = rubikFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(horizontal = 6.dp),
            text = "JOB SUCCESS",
            color = LightSilver,
            fontFamily = rubikFamily,
            fontSize = 8.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun BoxScope.PointProgress(
    modifier: Modifier = Modifier,
    progressLimit: Float,
    progress: () -> Float
) {
    val start = 120f
    val thickness = 6.dp

    Canvas(
        modifier = modifier
            .padding(thickness / 2)
            .aspectRatio(1f)
            .align(Alignment.Center)
            .offset(),
        onDraw = {
            //Background Arc
            drawArc(
                color = BrightGray,
                startAngle = start,
                sweepAngle = progressLimit,
                useCenter = false,
                style = Stroke(thickness.toPx(), cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )

            //Foreground Arc
            drawArc(
                color = SkyBlue,
                startAngle = start,
                sweepAngle = progress(),
                useCenter = false,
                style = Stroke(thickness.toPx(), cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )
        }
    )
}

@Preview
@Composable
fun ArcProgressBarWithImagePreview() {
    UpworkRedesignComposeTheme {
        ArcProgressBarWithImage(jobSuccessScore = 54f)
    }
}