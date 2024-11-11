package com.dyshuk.android.upworkredesigncompose.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite

@Composable
fun FavouriteButton(
    modifier: Modifier = Modifier,
    onClicked: () -> Unit
) {
    Button(
        modifier = modifier.size(30.dp),
        contentPadding = PaddingValues(0.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = SnowWhite),
        onClick = {
            onClicked()
        }
    ) {
        Icon(
            modifier = Modifier.size(10.dp),
            imageVector = ImageVector.vectorResource(R.drawable.ic_star),
            contentDescription = "Favourite icon",
            tint = LightSilver
        )
    }
}