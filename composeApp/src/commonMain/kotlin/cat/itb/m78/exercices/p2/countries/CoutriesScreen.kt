package cat.itb.m78.exercices.p2.countries

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun CountriesScreen(){
    val viewModel = viewModel { CountriesViewModel() }
    val countries = viewModel.countries.value
    CountriesScreen(countries)
}

@Composable
fun CountriesScreen(countries: List<Country>?) {
    if(countries==null){
        CircularProgressIndicator()
    } else {
        LazyColumn() {
            items(countries) { country ->
                Row{
                    Column(modifier = Modifier.weight(1f)) {
                        Text(country.name, fontWeight = FontWeight.Bold)
                        Text(country.capital)
                    }
                    AsyncImage(
                        modifier = Modifier.size(50.dp),
                        model = country.media.flag,
                        contentDescription = "flag",
                    )

                }


            }
        }
    }
}
