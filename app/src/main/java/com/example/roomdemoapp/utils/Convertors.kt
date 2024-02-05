package com.example.roomdemoapp.utils

import androidx.room.TypeConverter
import java.util.Date


/**
 * Created by Tirth Patel.
 */
class Convertors {

    @TypeConverter
    fun fromDataToLong(value: Date): Long {
        return value.time
    }

    @TypeConverter
    fun fromLongToData(value: Long): Date {
        return Date(value)
    }
}