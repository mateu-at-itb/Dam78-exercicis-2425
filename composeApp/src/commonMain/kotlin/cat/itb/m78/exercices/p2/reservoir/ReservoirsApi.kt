package cat.itb.m78.exercices.p2.reservoir

import cat.itb.m78.exercices.p2.jokes.Joke
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json




object ReservoirsApi {
    private val url = "https://analisi.transparenciacatalunya.cat/resource/gn9e-3qhr.json"
    private val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun list() = client.get(url).body<List<Reservoirs>>()

    suspend fun detail(name: String) =
        client.get("$url?estaci=$name").body<List<Reservoirs>>()
}