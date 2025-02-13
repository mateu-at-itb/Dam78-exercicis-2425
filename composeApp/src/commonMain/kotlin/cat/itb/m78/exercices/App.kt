package cat.itb.m78.exercices


import cat.itb.m78.exercices.stateless.MainNavigation
import androidx.compose.runtime.*
import cat.itb.m78.exercices.navigation.tictactoe.TicTacToeScreen
import cat.itb.m78.exercices.theme.AppTheme
import cat.itb.m78.exercices.trivial.CountDownScreen
import cat.itb.m78.exercices.viewmodel.ShoppingListScreen

@Composable
internal fun App() = AppTheme {
    CountDownScreen()
}


