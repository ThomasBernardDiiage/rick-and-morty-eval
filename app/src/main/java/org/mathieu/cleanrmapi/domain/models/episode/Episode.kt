package org.mathieu.cleanrmapi.domain.models.episode

import java.util.Date

data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val url: String,
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