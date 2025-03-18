package cat.itb.m78.exercices.p2.countries

import cat.itb.m78.exercices.p2.jokes.Joke
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Country(
    val abbreviation: String,
    val capital: String,
    val currency: String,
    val name: String,
    val phone: String,
    val population: Long? = null,
    val media: CountryMedia,
    val id: Long,
)

@Serializable
data class CountryMedia(
    val flag: String,
    val emblem: String,
    val orthographic: String,
)


object CountriesApi {
    private val url = "https://api.sampleapis.com/countries/countries"
    private val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun listCountries() = client.get(url).body<List<Country>>()
}