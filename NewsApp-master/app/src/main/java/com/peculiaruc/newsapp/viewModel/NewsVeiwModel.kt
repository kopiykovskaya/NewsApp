package com.peculiaruc.newsapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peculiaruc.newsapp.dataSource.NewsRepository
import com.peculiaruc.newsapp.model.NewsResponse
import com.peculiaruc.newsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsVeiwModel( private val  newsRepository: NewsRepository): ViewModel() {

    val recentNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val pageNum = 1

    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val searchNewsPageNum = 1


    init {
        getrecentNews("us")
    }

    //function to get the recent nws from the API

   fun getrecentNews(countryCode: String) =
       viewModelScope.launch {
        recentNews.postValue(Resource.Loading())
        //make network response
        val response = newsRepository.getRecentNews(countryCode, pageNum)
    recentNews.postValue(handleRecentNewsResponse(response))

    }

    fun searchNews(searchQuery: String) =
        viewModelScope.launch {
            searchNews.postValue(Resource.Loading())
            val response = newsRepository.searchNews(searchQuery, searchNewsPageNum)
            searchNews.postValue(handleSearchNewsResponse(response))
        }

    //function to handle the response & pagination
    private fun handleRecentNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
       return  Resource.Error(response.message())
    }

    private fun handleSearchNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
        return  Resource.Error(response.message())
    }
}