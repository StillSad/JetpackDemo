package com.thinkwage.jetpackdemo.ui

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thinkwage.jetpackdemo.R
import com.thinkwage.jetpackdemo.adapter.ArticleAdapter
import com.thinkwage.jetpackdemo.bean.Article
import com.thinkwage.jetpackdemo.databinding.ActivityMainBinding
import com.thinkwage.jetpackdemo.net.articleApi
import kotlinx.coroutines.*
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    private val   mBinding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val rvContent:RecyclerView by lazy {findViewById(R.id.rv_content) }
    protected var hasmore = true
    protected var page = 0
    private val data = mutableListOf<Article>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(mBinding.root)

        mBinding.adapter = ArticleAdapter(data)

        rvContent.layoutManager = LinearLayoutManager(this)

        getData()
    }

    protected fun getData() {
        GlobalScope.launch(Dispatchers.Main) {
            val params = mutableMapOf("pageNum" to "$page", "searchField" to "")
            val result = withContext(Dispatchers.IO) {
                articleApi.findGzhArticles(params)
            }
            if (result.code == "0000") {
                data.addAll(result.data)
            }
            rvContent.adapter?.notifyDataSetChanged()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
