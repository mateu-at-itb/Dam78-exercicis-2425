package cat.itb.m78.exercices.p2.reservoir

import kotlinx.serialization.Serializable

object ReservoirsNavigation{
    @Serializable
    data object ReservoirListScreen
    @Serializable
    data class ReservoirDetailScreen(val name: String)
}