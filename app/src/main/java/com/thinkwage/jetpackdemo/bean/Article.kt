package com.thinkwage.jetpackdemo.bean

data class Article(
    //名称
    val nickname: String?,
    //头像
    val headImg: String?,
    //公众号简介
    val gzhContent: String?,
    val gzhId: String?,
    val link: String?,
    //文章旁的图片
    val cover: String?,
    //创建时间
    val createTime: String?,
    val title: String?,
    val name: String?,
    val articleId: String?,
    //文章音频
    val voiceUrl: String?,
    //文章内容
    val content: String?,
    //0-无图:String?,1-小图:String?,2-大图
    val picType: Int?,
    //是否收藏:1-是:String?,0-否
    val isCollected: String?,
    //是否点赞:1-是:String?,0-否
    val isPraise: String?,
    //点赞数
    val praiseNum: Int?,
    //评论数
    val evaluationNum: Int?,
    //html
    val htmlBody: String?,
)


