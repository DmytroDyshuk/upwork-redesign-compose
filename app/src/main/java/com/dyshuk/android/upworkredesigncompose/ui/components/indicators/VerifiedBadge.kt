package com.dyshuk.android.upworkredesigncompose.ui.components.indicators

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.dyshuk.android.upworkredesigncompose.R

@Composable
fun VerifiedBadge(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_verified_background),
            contentDescription = null
        )
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_verified),
            contentDescription = null
        )
    }
}