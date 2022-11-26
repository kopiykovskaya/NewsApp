package com.peculiaruc.newsapp.dataSource.db

import androidx.room.TypeConverter
import com.peculiaruc.newsapp.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}