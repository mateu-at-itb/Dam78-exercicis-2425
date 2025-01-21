package cat.itb.m78.exercices.stateless

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.app_name
import m78exercices.composeapp.generated.resources.generatedFace
import m78exercices.composeapp.generated.resources.hello_message
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

val texts = (1..100_000).map { "value : $it" }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloWorld() {

    LazyRow(horizontalArrangement = Arrangement.spacedBy(50.dp)) {
        items(texts){ text ->
            Text(text+"sadads")
        }
    }
}