package com.thinkwage.jetpackdemo.net


data class RestfulBaseResult<T>(val code:String = "0000",val success:Boolean,val data:T,val message:String,val description:String)