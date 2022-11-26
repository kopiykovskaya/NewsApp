package com.peculiaruc.newsapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.peculiaruc.newsapp.R
import com.peculiaruc.newsapp.dataSource.NewsRepository
import com.peculiaruc.newsapp.dataSource.db.NewsDatabase
import com.peculiaruc.newsapp.databinding.ActivityMainBinding
import com.peculiaruc.newsapp.viewModel.NewsVeiwModel
import com.peculiaruc.newsapp.viewModel.NewsViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    lateinit var viewModel: NewsVeiwModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(NewsDatabase(this))
        val viewModelProviderFactory = NewsViewModelFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsVeiwModel::class.java)

        //Initialize bottom navigation
        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navhostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf( R.id.recentsNewsFragment, R.id.searchNewsFragment, R.id.savedNewsFragment)
        )
    //    setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)
    }
  //      bottomNavigationView.setupWithNavController(navhostFragment.findNavController())

}