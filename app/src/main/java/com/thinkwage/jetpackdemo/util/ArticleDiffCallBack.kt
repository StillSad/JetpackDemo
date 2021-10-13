package com.thinkwage.jetpackdemo.util

import androidx.recyclerview.widget.DiffUtil
import com.thinkwage.jetpackdemo.bean.Article

class ArticleDiffCallBack(
    val oldData: MutableList<Article>,
    val newData: MutableList<Article>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldData.size

    override fun getNewListSize() = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldData.get(oldItemPosition)
        val new = newData.get(newItemPosition)
        return old.articleId == new.articleId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }

}