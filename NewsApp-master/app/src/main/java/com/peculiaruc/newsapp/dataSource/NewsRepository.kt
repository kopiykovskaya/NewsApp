package com.peculiaruc.newsapp.dataSource

import com.peculiaruc.newsapp.dataSource.api.RetrofitInstance
import com.peculiaruc.newsapp.dataSource.db.NewsDatabase

class NewsRepository (private val db: NewsDatabase) {

    suspend fun getRecentNews(countryCode: String, pageNum: Int) =
        RetrofitInstance.api.getRecentNews(countryCode, pageNum)

    suspend fun searchNews(searchQuery: String, pageNum: Int) =
        RetrofitInstance.api.searchAllNews(searchQuery, pageNum)
}