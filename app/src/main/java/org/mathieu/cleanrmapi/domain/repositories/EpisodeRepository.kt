package org.mathieu.cleanrmapi.domain.repositories

import org.mathieu.cleanrmapi.domain.models.episode.Episode

interface EpisodeRepository {

    /**
     * Get all episodes for a character
     * @param characterId the character id
     * @return the list of episodes
     */
    suspend fun getEpisodes(characterId : Int): List<Episode>

    /**
     * Get an episode by its id
     * @param episodeId the episode id
     * @return the episode
     */
    suspend fun getEpisode(episodeId : Int): Episode?
}