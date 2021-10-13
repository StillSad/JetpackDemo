package com.thinkwage.jetpackdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thinkwage.jetpackdemo.R
import com.thinkwage.jetpackdemo.bean.Article

class ArticleAdapter(val data:MutableList<Article>) : RecyclerView.Adapter<ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article,parent,false))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = data.get(position)

        Glide.with(holder.ivImg)
            .load(item.cover)
            .into(holder.ivImg)

        holder.tvTitle.setText(item.title)

    }

    override fun getItemCount() = data.size

}