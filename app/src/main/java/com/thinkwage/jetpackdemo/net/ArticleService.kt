package com.thinkwage.jetpackdemo.net

import com.thinkwage.jetpackdemo.bean.Article
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.HashMap


interface ArticleService {
    @POST("/api/v3/tax/gzh/findGzhArticles")
    suspend fun findGzhArticles(@Body params: MutableMap<String, String>): RestfulBaseResult<MutableList<Article>>

}