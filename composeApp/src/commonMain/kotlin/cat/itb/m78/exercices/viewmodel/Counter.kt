package cat.itb.m78.exercices.viewmodel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class CounterViewModel : ViewModel(){
    val counter1 = mutableStateOf(0)
    val counter2 = mutableStateOf(0)

    fun increaseCounter1(){
        counter1.value++
    }
    fun increaseCounter2(){
        counter2.value++
    }
}

@Composable
fun CounterScreen(){
    val viewModel = viewModel { CounterViewModel() }
    CounterView(viewModel.counter1.value, viewModel.counter2.value, viewModel::increaseCounter1, viewModel::increaseCounter2)
}

@Composable
fun CounterView(
    counter1: Int,
    counter2: Int,
    onIncreaseCounter1: () -> Unit,
    onIncreaseCounter2: () -> Unit,
){
    Row {
        SingleCounter(counter1, onIncreaseCounter1)
        SingleCounter(counter2, onIncreaseCounter2)
    }
}

@Composable
fun SingleCounter(counter: Int, onIncreaseCounter: () -> Unit){
    Column {
        Text(counter.toString())
        Button(onClick = onIncreaseCounter){
            Text("Count")
        }
    }
}