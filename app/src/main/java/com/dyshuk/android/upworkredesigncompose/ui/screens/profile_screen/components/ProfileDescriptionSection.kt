package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.components.buttons.PlayVideoButton
import com.dyshuk.android.upworkredesigncompose.ui.components.text.ExpandingDescriptionText
import com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.ProfileStatsBox
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.rubikFamily

/**
 * NOTE: This composable uses hardcoded mock data as part of a personal project
 * to showcase Jetpack Compose UI capabilities.
 *
 * In production, all data should be passed into this composable via parameters
 * or state objects, depending on the app architecture.
 */
@Composable
fun ProfileDescriptionSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
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
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProfileStatsBox(
                count = "$ 45.00", title = "hourly rate"
            )
            ProfileStatsBox(
                count = "$ 200k+", title = "earned"
            )
        }
    }
}