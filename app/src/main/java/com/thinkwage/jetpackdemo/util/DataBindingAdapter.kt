package com.thinkwage.jetpackdemo.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("adapter")
fun setAdapter(recyclerView: RecyclerView,adapter:RecyclerView.Adapter<*>) {
    recyclerView.adapter = adapter
}

@BindingAdapter("uploadOnScroll")
fun uploadOnScroll(recyclerView: RecyclerView,scroll:RecyclerView.OnScrollListener) {
    recyclerView.addOnScrollListener(scroll)
}

@BindingAdapter("imageUrl","defaultImg",requireAll = true)
fun setImage(imageView: ImageView,imageUrl: String, defaultImg: Int) {
    //defaultImg类型:Int -> 通过@{R.mipmap.ic_launcher_round}获取资源
    //              Drawable -> 通过@{@drawable/ic_launcher_background}获取资源,只能获取drawable下资源

    Glide.with(imageView)
        .load(imageUrl)
        .apply(RequestOptions.placeholderOf(defaultImg).error(defaultImg))
        .into(imageView)
}