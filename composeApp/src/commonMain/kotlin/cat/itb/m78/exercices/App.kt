package cat.itb.m78.exercices


import cat.itb.m78.exercices.stateless.MainNavigation
import androidx.compose.runtime.*
import cat.itb.m78.exercices.navigation.tictactoe.TicTacToeScreen
import cat.itb.m78.exercices.p2.countries.CountriesScreen
import cat.itb.m78.exercices.p2.db.MessagesScreen
import cat.itb.m78.exercices.p2.jokes.JokesScreen
import cat.itb.m78.exercices.theme.AppTheme
import cat.itb.m78.exercices.trivial.CountDownScreen
import cat.itb.m78.exercices.viewmodel.ShoppingListScreen

@Composable
internal fun App() = AppTheme {
    MessagesScreen()
}


