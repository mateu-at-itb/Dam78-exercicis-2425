package cat.itb.m78.exercices


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import cat.itb.m78.exercices.stateless.ContactApp
import cat.itb.m78.exercices.stateless.HelloWorld
import cat.itb.m78.exercices.stateless.Welcome
import cat.itb.m78.exercices.theme.AppTheme
import cat.itb.m78.exercices.viewmodel.CounterScreen
import org.jetbrains.compose.reload.DevelopmentEntryPoint

@Composable
internal fun App() = AppTheme {
    CounterScreen()
}


