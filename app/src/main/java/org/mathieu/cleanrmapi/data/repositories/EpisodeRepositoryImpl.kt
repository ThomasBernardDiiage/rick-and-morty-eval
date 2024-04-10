package org.mathieu.cleanrmapi.data.repositories

import org.mathieu.cleanrmapi.data.local.EpisodeDAO
import org.mathieu.cleanrmapi.data.local.objects.CharacterEpisodeObject
import org.mathieu.cleanrmapi.data.local.objects.toModel
import org.mathieu.cleanrmapi.data.local.objects.toRoomObject
import org.mathieu.cleanrmapi.data.remote.CharacterApi
import org.mathieu.cleanrmapi.data.remote.EpisodeApi
import org.mathieu.cleanrmapi.domain.models.episode.Episode
import org.mathieu.cleanrmapi.domain.repositories.EpisodeRepository

class EpisodeRepositoryImpl(
    private val episodeApi: EpisodeApi,
    private val episodeLocal : EpisodeDAO,
    private val characterApi: CharacterApi
) : EpisodeRepository {

    /**
     * Get all episodes for a character
     * First check if the episodes are already in the database
     * If not, fetch them from the API
     * @param characterId the character id
     */
    override suspend fun getEpisodes(characterId: Int): List<Episode> {
        // Get all episodes for the character
        val episodesLocal = episodeLocal.getEpisodesForCharacter(characterId)
        if (episodesLocal.isNotEmpty()) {
            return episodesLocal.map { it.toModel() }
        }

        val episodesToLoad = characterApi.getCharacter(characterId)?.episode?.mapNotNull {
            it.substringAfterLast("/").toIntOrNull()
        } ?: throw Exception("Character not found.")
        val episodes = episodeApi.getEpisodes(episodesToLoad)
            .map { it.toRoomObject() }

        episodeLocal.insert(episodes)

        // Create link between character and episodes
        val links = episodes.map {
            CharacterEpisodeObject(
                characterId = characterId,
                episodeId = it.id
            )
        }
        episodeLocal.createLink(links)


        return episodes.map { it.toModel() }
    }

    override suspend fun getEpisode(episodeId: Int): Episode {
        episodeLocal.getEpisode(episodeId)?.let {
            return it.toModel()
        }
//
//        val episode = episodeApi.getEpisode(episodeId).toRoomObject()
//        episodeLocal.insert(episode)
//        return episode.toModel()
        TODO()
    }
}