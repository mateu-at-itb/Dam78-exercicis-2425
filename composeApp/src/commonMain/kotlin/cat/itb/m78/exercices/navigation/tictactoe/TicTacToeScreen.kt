package cat.itb.m78.exercices.navigation.tictactoe

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TicTacToeScreen() {
    val viewModel = viewModel { TicTacToeViewModel() }
    TicTacToeScreen(viewModel.board.value, viewModel::onPlayAt)
}

@Composable
fun TicTacToeScreen(board: List<List<Boolean?>>, onPlayAt: (Int, Int) -> Unit) {
    Column {
        board.forEachIndexed { i, row ->
            Row {
                row.forEachIndexed { j, cell ->
                    Box(
                        Modifier.size(100.dp).border(1.dp, Color.Black)
                            .clickable { onPlayAt(i, j) }) {
                        Text(toUiString(cell), modifier = Modifier.align(Alignment.Center))
                    }

                }
            }
        }

    }
}

fun toUiString(player: Boolean?) = when (player) {
    true -> "X"
    false -> "O"
    null -> ""
}
