package cat.itb.m78.exercices.p2.jokes

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun JokesScreen(){
    val viewModel = viewModel { JokesViewModel() }
    val joke = viewModel.joke.value
    JokesScreen(joke)
}

@Composable
fun JokesScreen(joke: Joke?) {
    if(joke==null){
        CircularProgressIndicator()
    } else {
        Column {
            Text(joke.setup)
            Text(joke.punchline)
        }
    }
}
