package cat.itb.m78.exercices.trivial

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun CountDownScreen(){
    var timeLeft by remember{ mutableStateOf(10) }
    LaunchedEffect(timeLeft){
        delay(1.seconds)
        timeLeft--
        if(timeLeft==0){
            //Do something?
        }
    }

    Column{
        Button({timeLeft = 10}){
            Text("Restart")
        }
        Text(timeLeft.toString())
    }
}