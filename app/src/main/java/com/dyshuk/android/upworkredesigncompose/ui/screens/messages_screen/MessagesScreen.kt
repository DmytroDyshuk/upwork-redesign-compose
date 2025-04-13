package com.dyshuk.android.upworkredesigncompose.ui.screens.messages_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dyshuk.android.upworkredesigncompose.R
import com.dyshuk.android.upworkredesigncompose.ui.theme.CharcoalGray
import com.dyshuk.android.upworkredesigncompose.ui.theme.PrimaryGreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme
import androidx.compose.runtime.getValue

@Composable
fun MessagesScreen(viewModel: MessagesViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()

    MessagesScreenContent(modifier = Modifier, uiState = uiState)
}

@Composable
fun MessagesScreenContent(modifier: Modifier = Modifier, uiState: MessagesScreenState) {
    val messagesListState = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = messagesListState,
        contentPadding = PaddingValues(horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        when (uiState) {
            MessagesScreenState.Loading -> TODO()
            is MessagesScreenState.Error -> TODO()
            is MessagesScreenState.Success -> {
                val chatList = uiState.chatsList

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(bottom = 10.dp, top = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "Messages",
                            color = CharcoalGray,
                            style = MaterialTheme.typography.titleLarge
                        )
                        FloatingActionButton(
                            modifier = Modifier.size(20.dp),
                            shape = CircleShape,
                            containerColor = PrimaryGreen,
                            elevation = FloatingActionButtonDefaults.elevation(8.dp),
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.ic_add),
                                contentDescription = null
                            )
                        }
                    }
                }

                items(
                    items = chatList,
                    key = { chat -> chat.id }
                ) {
                    ChatListItem(
                        modifier = Modifier,
                        user = it.sender,
                        projectName = it.chatTitle,
                        lastMessage = it.lastMessage.text,
                        timestamp = it.timestamp,
                        unreadMessagesCount = it.newMessagesCount
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun MessagesScreenPreview() {
    UpworkRedesignComposeTheme {
        MessagesScreen()
    }
}