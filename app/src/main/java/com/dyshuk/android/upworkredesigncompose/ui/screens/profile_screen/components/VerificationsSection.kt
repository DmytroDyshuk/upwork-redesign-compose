package com.dyshuk.android.upworkredesigncompose.ui.screens.profile_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dyshuk.android.upworkredesigncompose.ui.components.text.VerificationStatusText
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
fun VerificationsSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
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
}