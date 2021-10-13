package com.thinkwage.jetpackdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thinkwage.jetpackdemo.R
import com.thinkwage.jetpackdemo.bean.Article
import com.thinkwage.jetpackdemo.databinding.ItemArticleBinding

class ArticleAdapter() : RecyclerView.Adapter<ArticleViewHolder>() {
    val data = mutableListOf<Article>()
    fun setData(data:MutableList<Article>) {
        this.data.clear();
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        return ArticleViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val item = data.get(position)
        holder.binding.data = item

    }

    override fun getItemCount() = data.size

}