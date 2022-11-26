package com.peculiaruc.newsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

//set this article gotten from gason response to Entity. No need to create another entitiy
@Entity(tableName = "article")

data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) : Serializable