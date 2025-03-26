package com.dyshuk.android.upworkredesigncompose.ui.screens.proposals_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.components.SwitchButton
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.SnowWhite
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun ProposalsScreen(modifier: Modifier = Modifier) {
    ProposalsContent(modifier = modifier)
}

@Composable
fun ProposalsContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.padding(start = 35.dp, top = 20.dp),
            text = "Proposals",
            style = MaterialTheme.typography.titleLarge,
            color = CharcoalGray
        )
        SwitchButton(modifier = Modifier.padding(start = 15.dp, top = 15.dp, end = 15.dp))
    }
}

@Composable
fun ProposalsButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    count: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(color = Color.White, shape = RoundedCornerShape(15.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(start = 15.dp)
                .background(color = SnowWhite, shape = RoundedCornerShape(5.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.padding(5.dp),
                imageVector = icon,
                contentDescription = null
            )
        }

        Text(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .weight(1f),
            text = title,
            color = CharcoalGray,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            modifier = Modifier
                .padding(end = 20.dp),
            text = "$count",
            color = PrimaryGreen,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview
@Composable
fun ProposalsButtonPreview() {
    UpworkRedesignComposeTheme {
        ProposalsButton(
            icon = ImageVector.vectorResource(R.drawable.ic_active),
            title = "Invitations to Interview",
            count = 5
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProposalsContent() {
    UpworkRedesignComposeTheme {
        ProposalsContent()
    }
}