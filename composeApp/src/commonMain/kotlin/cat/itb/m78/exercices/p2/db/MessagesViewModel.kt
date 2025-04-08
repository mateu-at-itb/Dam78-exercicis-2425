package cat.itb.m78.exercices.p2.db

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import cat.itb.m78.exercices.db.Message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration.Companion.seconds

class MessagesViewModel : ViewModel(){
    val newMessageText = mutableStateOf("")
    val messages = database.myTableQueries.selectAll().asFlow().mapToList(Dispatchers.IO)
    
    init {
        viewModelScope.launch {
            repeat(10){
                delay(5.seconds)
                database.myTableQueries.insert("HELLO $it")
            }
        }
    }


    fun insertMessage(){
        viewModelScope.launch(Dispatchers.Default) {
            database.myTableQueries.insert(newMessageText.value)
            newMessageText.value = ""
        }
    }

    fun updateNewMessageText(newValue: String){
        newMessageText.value = newValue
    }
}