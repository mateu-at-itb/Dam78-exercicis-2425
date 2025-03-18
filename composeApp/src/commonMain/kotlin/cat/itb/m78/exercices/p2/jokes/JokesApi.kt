package cat.itb.m78.exercices.p2.jokes

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import io.ktor.serialization.kotlinx.json.json


@Serializable
data class Joke(
    val id: Int,
    val type: String,
    val setup: String,
    val punchline: String,
)

object JokesApi{
    private val url = "https://api.sampleapis.com/jokes/goodJokes"
    private val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun listJokes() = client.get(url).body<List<Joke>>()
}