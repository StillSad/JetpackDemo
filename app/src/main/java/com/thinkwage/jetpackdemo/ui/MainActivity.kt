package com.thinkwage.jetpackdemo.ui

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thinkwage.jetpackdemo.R
import com.thinkwage.jetpackdemo.adapter.ArticleAdapter
import com.thinkwage.jetpackdemo.bean.Article
import com.thinkwage.jetpackdemo.databinding.ActivityMainBinding
import com.thinkwage.jetpackdemo.net.articleApi
import com.thinkwage.jetpackdemo.util.UploadOnScrollListener
import com.thinkwage.jetpackdemo.viewmodel.MainViewModel
import kotlinx.coroutines.*
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    private val mBinding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mViewMode:MainViewModel by viewModels()

    private val rvContent:RecyclerView by lazy {findViewById(R.id.rv_content) }

    private val data = mutableListOf<Article>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(mBinding.root)

        mBinding.adapter = ArticleAdapter()
        mBinding.uploadListener = UploadOnScrollListener { mViewMode.getData() }


        mViewMode.data.observe(this){ newData->
            (mBinding.adapter as ArticleAdapter).setData(newData)
        }

        mViewMode.getData()

    }


}
