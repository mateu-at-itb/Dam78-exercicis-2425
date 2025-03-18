package cat.itb.m78.exercices.p2.jokes

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JokesViewModel : ViewModel() {
    val joke = mutableStateOf<Joke?>(null)
    init{
        viewModelScope.launch(Dispatchers.Default) {
            joke.value = JokesApi.listJokes().random()
        }
    }
}