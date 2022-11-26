package com.peculiaruc.newsapp.dataSource.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.peculiaruc.newsapp.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article): Long

    @Query("SELECT * FROM article")
    fun getAllArticles(): LiveData<List<Article>>

    @androidx.room.Delete
    suspend fun deleteArticle(article: Article)


}