package org.mathieu.cleanrmapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.mathieu.cleanrmapi.data.local.objects.CharacterEpisodeObject
import org.mathieu.cleanrmapi.data.local.objects.CharacterObject
import org.mathieu.cleanrmapi.data.local.objects.EpisodeObject

@Database(
    entities = [
        CharacterObject::class,
        EpisodeObject::class,
        CharacterEpisodeObject::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class RMDatabase: RoomDatabase() {

    abstract fun characterDAO(): CharacterDAO
    abstract fun episodeDAO(): EpisodeDAO

    companion object {
        const val CHARACTER_TABLE = "character_table"
        const val EPISODE_TABLE = "episode_table"
        const val CHARACTER_EPISODE_TABLE = "character_episode_table"
    }

}