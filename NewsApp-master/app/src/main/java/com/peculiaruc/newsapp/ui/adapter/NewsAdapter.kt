package com.peculiaruc.thenews.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peculiaruc.newsapp.R
import com.peculiaruc.newsapp.model.Article
import kotlinx.android.synthetic.main.list_news_item.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticlesViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_news_item, parent, false
            )
        )
    }

    private var onItemClickListener: ((String?) -> Unit)? = null

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val article = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(article_img)
            news_source.text = article.source.name
            news_title.text = article.title
            news_description.text = article.description
            news_published.text = article.publishedAt

            constraint.setOnClickListener {
                onItemClickListener?.let {
                    it(article.url)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun setOnItemClickListener(listener: (String?) -> Unit) {
        onItemClickListener = listener
    }
}