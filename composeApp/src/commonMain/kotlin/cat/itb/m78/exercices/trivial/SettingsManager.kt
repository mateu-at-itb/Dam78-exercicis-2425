package cat.itb.m78.exercices.trivial

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

enum class TrivialSubject{Kotlin, Html}
data class TrivialSettings(
    val subject : TrivialSubject = TrivialSubject.Kotlin,
    val questionsPerGame: Int = 10
)



/**
 * Stores current setting in Memory.
 * TODO: update to store in disk/DB
 *
 * Usage TrivialSettingsManager.get()
 */
data object TrivialSettingsManager{
    private var settings = TrivialSettings()
    fun update(newSettings: TrivialSettings){
        settings = newSettings
    }
    fun get() = settings
}

val questionKotlin = listOf(TODO())
val questionHtml = listOf(TODO())

class TrivialViewModel() : ViewModel() {
    val settings = TrivialSettingsManager.get()
    val questions = when(settings.subject){
        TrivialSubject.Kotlin -> questionKotlin
        TrivialSubject.Html -> questionHtml
    }
}

class SettingsViewModel() : ViewModel(){

    val currentQuestionsPerGame =
        mutableStateOf(TrivialSettingsManager.get().questionsPerGame)
    fun saveSettings(){
        val settingsFromInputs = TrivialSettings(TODO(), TODO())
        TrivialSettingsManager.update(settingsFromInputs)
    }
}