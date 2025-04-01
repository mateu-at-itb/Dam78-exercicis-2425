
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import java.awt.Dimension
import cat.itb.m78.exercices.App
import kotlinx.coroutines.flow.flow

fun main() = application {
    Window(
        title = "M78Exercices",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        App()
    }
}

@Composable
fun AppPreview() { App() }


@Composable
fun xx(){
    val x = flow{emit(1)}
    val e = x.collectAsStateWithLifecycle("a").value
}