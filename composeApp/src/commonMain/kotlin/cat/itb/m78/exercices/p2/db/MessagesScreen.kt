package cat.itb.m78.exercices.p2.db

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.db.Message

@Composable
fun MessagesScreen() {
    val viewModel = viewModel { MessagesViewModel() }
    val messages = viewModel.messages.collectAsStateWithLifecycle(null)
    MessagesScreen(
        messages.value,
        viewModel.newMessageText.value,
        viewModel::insertMessage,
        viewModel::updateNewMessageText
    )
}

@Composable
fun MessagesScreen(
    messages: List<Message>?,
    newMessageText: String,
    onInsert: () -> Unit,
    onTextUpdate: (String) -> Unit,
) {


    Column {
        Card {
            Row(modifier = Modifier.padding(20.dp)) {
                OutlinedTextField(newMessageText, onTextUpdate)
                Button(onInsert) {
                    Text("Create")
                }
            }
        }
        if (messages == null) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(messages) {
                    Text(it.text)
                }
            }
        }
    }
}
