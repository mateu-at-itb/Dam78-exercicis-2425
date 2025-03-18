package cat.itb.m78.exercices.p2.countries

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountriesViewModel : ViewModel() {
    val countries = mutableStateOf<List<Country>?>(null)

    init {
        viewModelScope.launch(Dispatchers.Default){
            countries.value = CountriesApi.listCountries()
        }
    }
}