package com.peculiaruc.newsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.peculiaruc.newsapp.R
import com.peculiaruc.newsapp.ui.activity.MainActivity
import com.peculiaruc.newsapp.viewModel.NewsVeiwModel
import com.peculiaruc.thenews.ui.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_saved_news.*

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {

    private lateinit var viewModel: NewsVeiwModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
        setUpRecyclerView()

        //put the article into a bundle and attach the bundle it to the navigation component
        //the navigation component will then handle the transition and pass the argument to the articlefragment
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_savedNewsFragment_to_articleFragment2,
                bundle
            )
        }
    }

    //setup recyclerView
    private fun setUpRecyclerView() {
        newsAdapter = NewsAdapter()
        saveReclycle_view.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}