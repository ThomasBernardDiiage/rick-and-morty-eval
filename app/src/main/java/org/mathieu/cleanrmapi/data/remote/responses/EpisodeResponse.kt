package org.mathieu.cleanrmapi.data.remote.responses

import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String

)

//{
//    "id": 1,
//    "name": "Pilot",
//    "air_date": "December 2, 2013",
//    "episode": "S01E01",
//    "characters": [
//    "https://rickandmortyapi.com/api/character/1",
//    "https://rickandmortyapi.com/api/character/2",
//    //...
//    ],
//    "url": "https://rickandmortyapi.com/api/episode/1",
//    "created": "2017-11-10T12:56:33.798Z"
//}