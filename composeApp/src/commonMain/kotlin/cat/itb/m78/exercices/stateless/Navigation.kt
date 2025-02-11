package cat.itb.m78.exercices.stateless

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

sealed interface Screen{
    data object Screen1 : Screen
    data object Screen2 : Screen
    data class Screen3(val name:String) : Screen
}

class MainNavigationViewModel : ViewModel() {
    val screenState = mutableStateOf<Screen>(Screen.Screen1)

    fun navigate(screen: Screen){
        screenState.value = screen
    }
}

@Composable
fun MainNavigation(){
    val viewModel = viewModel { MainNavigationViewModel() }
    val myScreen = viewModel.screenState.value
    when(myScreen){
        Screen.Screen1 -> Screen1({ viewModel.navigate(Screen.Screen2)})
        Screen.Screen2 ->Screen2(navigateToScreen3 = { viewModel.navigate(Screen.Screen3(it))})
        is Screen.Screen3 -> Screen3(myScreen.name)
    }
}

@Composable
fun Screen1(onGoToScreen2 : ()->Unit){
    Column {
        Text("Screen1")
        Button(onClick = onGoToScreen2){
            Text("Go to screen 2")
        }
    }
}

@Composable
fun Screen2(navigateToScreen3: (String)->Unit){
    val text = remember { mutableStateOf("") }
    Column {
        TextField(text.value, onValueChange = {text.value = it})
        Text("Screen2")
        Button(onClick = {
            navigateToScreen3(text.value)
        }){
            Text("Go to 3")
        }
    }

}

@Composable
fun Screen3(name: String){
    Text("Good Morning: $name")
}