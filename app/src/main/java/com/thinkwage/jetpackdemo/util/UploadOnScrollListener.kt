package com.thinkwage.jetpackdemo.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class UploadOnScrollListener(val bloc:()->Unit) : RecyclerView.OnScrollListener() {
    private var isSlidingUpward = false


    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {



            val lm = recyclerView.getLayoutManager()
            when {
                lm is LinearLayoutManager -> {


                    val last = lm.findLastVisibleItemPosition()
                    val total = recyclerView.getAdapter()?.getItemCount()?:0
                    if (last > 0 && last >= total - 1 && isSlidingUpward) {
                       bloc()
                    }
                }
                lm is StaggeredGridLayoutManager -> {
//                    lm.findLastVisibleItemPositions()
                }
            }


        }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        isSlidingUpward = dy > 0;
    }
}