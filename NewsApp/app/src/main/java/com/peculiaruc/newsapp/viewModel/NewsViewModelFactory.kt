package com.peculiaruc.newsapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.peculiaruc.newsapp.dataSource.NewsRepository

class NewsViewModelFactory(val newsRepository: NewsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return NewsVeiwModel (newsRepository) as T
    }
}