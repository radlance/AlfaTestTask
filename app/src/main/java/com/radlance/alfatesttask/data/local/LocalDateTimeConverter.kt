package com.radlance.alfatesttask.data.local

import androidx.room.TypeConverter
import java.time.LocalDateTime

class LocalDateTimeConverter {
    @TypeConverter
    fun toDate(dateTime: String): LocalDateTime {
        return LocalDateTime.parse(dateTime)
    }

    @TypeConverter
    fun toDateString(dateTime: LocalDateTime): String {
        return dateTime.toString()
    }
}