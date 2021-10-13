package com.thinkwage.jetpackdemo.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thinkwage.jetpackdemo.R

class ArticleViewHolder( itemView:View): RecyclerView.ViewHolder(itemView) {
    val ivImg:ImageView
    val tvTitle:TextView

    init {
        ivImg = itemView.findViewById(R.id.iv_img)
        tvTitle = itemView.findViewById(R.id.tv_title)
    }

}