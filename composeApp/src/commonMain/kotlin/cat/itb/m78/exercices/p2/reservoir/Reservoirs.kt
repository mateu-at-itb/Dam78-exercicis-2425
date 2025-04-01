package cat.itb.m78.exercices.p2.reservoir

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reservoirs(
    @SerialName("dia")
    val day : String,
    @SerialName("estaci")
    val name: String,
    @SerialName("nivell_absolut")
    val totalLevel : Double,
    @SerialName("percentatge_volum_embassat")
    val levelPercentage: Double,
    @SerialName("volum_embassat")
    val volume: Double,
)