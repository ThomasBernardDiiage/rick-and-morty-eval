package org.mathieu.cleanrmapi.ui.screens.episodeDetail

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import org.mathieu.cleanrmapi.domain.repositories.EpisodeRepository
import org.mathieu.cleanrmapi.ui.core.ViewModel

class EpisodeDetailViewModel(
    application: Application,
) : ViewModel<EpisodeDetailsState>(EpisodeDetailsState(), application){

    private val episodeRepository: EpisodeRepository by inject()

    fun init(episodeId : Int){
        viewModelScope.launch {
            episodeRepository.getEpisode(episodeId)?.let {
                updateState { copy(name = it.name, episode = it.episode, date = it.airDate) }
            }
        }
    }
}

data class EpisodeDetailsState(
    val name: String = "",
    val episode: String = "",
    val date : String = ""
)