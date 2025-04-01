package com.dyshuk.android.upworkredesigncompose.ui.screens.messages_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.data.model.OnlineStatus
import com.dyshuk.android.upworkredesigncompose.data.model.User
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.CoralRed
import com.dyshuk.android.upworkredesigncompose.ui.theme.LightSilver
import com.dyshuk.android.upworkredesigncompose.ui.theme.MintCream
import com.dyshuk.android.upworkredesigncompose.ui.theme.SecondaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

@Composable
fun ChatListItem(
    modifier: Modifier = Modifier,
    user: User,
    projectName: String,
    lastMessage: String,
    timestamp: String,
    unreadMessagesCount: Int
) {
    val defaultBackGroundShape = RoundedCornerShape(15.dp)
    val hasUnreadMessages = unreadMessagesCount > 0

    val backgroundColor = if (hasUnreadMessages) MintCream else Color.White
    val shadow = if (hasUnreadMessages) {
        Modifier.shadow(elevation = 8.dp, shape = defaultBackGroundShape)
    } else {
        Modifier
    }
    val messageColor = if (hasUnreadMessages) CharcoalGray else LightSilver

    Row(
        modifier = modifier
            .height(70.dp)
            .fillMaxWidth()
            .then(shadow)
            .background(
                color = backgroundColor,
                shape = defaultBackGroundShape
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
        ) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = user.pictureUrl ?: R.drawable.natasha_romanoff_ava),
                contentDescription = null
            )
            CircleStatus(
                modifier = Modifier
                    .align(alignment = Alignment.BottomEnd)
                    .padding(end = 2.dp, bottom = 2.dp),
                color = user.status.color
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 9.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = user.name,
                    color = CharcoalGray,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = timestamp,
                    color = LightSilver,
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium)
                )
            }

            Row {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = projectName,
                        color = SecondaryGreen,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = lastMessage,
                        color = messageColor,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Normal),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (hasUnreadMessages) {
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp, start = 17.dp, end = 9.dp)
                            .drawBehind {
                                drawCircle(
                                    color = CoralRed,
                                    radius = this.size.maxDimension
                                )
                            },
                        text = unreadMessagesCount.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                    )
                }
            }
        }
    }

}

@Composable
fun CircleStatus(modifier: Modifier = Modifier, color: Color) {
    Canvas(
        modifier = modifier.size(8.dp),
        onDraw = {
            drawCircle(color = color)
        }
    )
}

@Preview
@Composable
fun ChatListItemPreview() {
    UpworkRedesignComposeTheme {
        ChatListItem(
            user = User(
                id = 3,
                name = "Peter Parker",
                pictureUrl = R.drawable.peter_parker_ava,
                status = OnlineStatus.ONLINE
            ),
            projectName = "Upwork Redesign Project",
            lastMessage = "You: I had uploaded new files to trello, plea You: I had uploaded new files to trello, please revie...",
            timestamp = "02:15 PM",
            unreadMessagesCount = 0
        )
    }
}