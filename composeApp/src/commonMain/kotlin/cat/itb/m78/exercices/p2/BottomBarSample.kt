package cat.itb.m78.exercices.p2

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBarSample() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomAppBar(
            actions = {
                NavigationBarItem(
                    onClick = { /* do something */ },
                    selected = false,
                    icon = {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = "Localized description"
                        )
                    }, label = { Text("Nav1")})
                IconButton(onClick = { /* do something */ }) {
                    Icon(
                        Icons.Filled.Edit,
                        contentDescription = "Localized description",
                    )
                }
            },
        )
    }) {

//        NavHost(navController = navController, startDestination = Destination.Screen1) {
//            composable<Destination.Screen1> {
//                Screen1(
//                    navigateToScreen2 = { navController.navigate(Destination.Screen2) },
//                )
//            }
//            composable<Destination.Screen2> {
//                Screen2 { navController.navigate(Destination.Screen3(it)) }
//            }
//            composable<Destination.Screen3> { backStack ->
//                val message = backStack.toRoute<Destination.Screen3>().message
//                Screen3(message)
//            }
//        }
    }

}