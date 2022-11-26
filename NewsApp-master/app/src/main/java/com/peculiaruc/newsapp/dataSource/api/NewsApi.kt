package com.peculiaruc.newsapp.dataSource.api

import com.peculiaruc.newsapp.model.NewsResponse
import com.peculiaruc.newsapp.util.Constant.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {


    @GET("v2/top-headlines")
    suspend fun getRecentNews(
        @Query("country")
        countryCode: String,

        @Query("page")
        pageNum: Int = 1,

        @Query("apiKey")
        apiKey: String = API_KEY

    ): Response<NewsResponse>

    @GET("v2/top-headlines")
    suspend fun searchAllNews(
        @Query("q")
        searchWord: String,

        @Query("page")
        pageNum: Int = 1,

        @Query("apiKey")
        apiKey: String = API_KEY

    ): Response<NewsResponse>
}