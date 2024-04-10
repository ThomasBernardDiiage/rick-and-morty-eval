package org.mathieu.cleanrmapi.data.local

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateConverter {

    @TypeConverter
    fun toDate(dateString: String?): Date? {
        val format = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        return dateString?.let {
            return format.parse(dateString)
        }
    }

    @TypeConverter
    fun fromDate(date: Date?): String? {
        val format = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        return if (date == null) {
            null
        } else {
            format.format(date)
        }
    }
}