package cat.itb.m78.exercices.navigation.tictactoe

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel(){
    val board = mutableStateOf(List(3) { List<Boolean?>(3) { null } })
    val player = mutableStateOf(true)

    fun onPlayAt(i: Int, j: Int){
        if(board.value[i][j]==null) {
            val newBoard = board.value.map { it.toMutableList() }
            newBoard[i][j] = player.value
            board.value = newBoard

            player.value = !player.value
        }
    }
}
