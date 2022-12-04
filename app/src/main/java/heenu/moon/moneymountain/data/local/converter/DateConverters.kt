package heenu.moon.moneymountain.data.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.util.*
import javax.inject.Singleton

@Singleton
@ProvidedTypeConverter
class DateConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}