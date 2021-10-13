package com.thinkwage.jetpackdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thinkwage.jetpackdemo.bean.Article
import com.thinkwage.jetpackdemo.net.articleApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    protected var hasmore = true
    protected var page = 0

    val data: MutableLiveData<MutableList<Article>> = MutableLiveData()


    fun getData() {
        viewModelScope.launch {
            val params = mutableMapOf("pageNum" to "$page", "searchField" to "")
            val result = articleApi.findGzhArticles(params)
            if (result.code == "0000") {
                val newData = data.value?: mutableListOf()
                newData.addAll(result.data)
                data.postValue(newData)
            }
            page++
        }


    }
}