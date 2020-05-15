package com.chen.jetpackmvvm.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chen.jetpackmvvm.base.BaseBindingAdapter
import com.chen.jetpackmvvm.utils.GlideApp


object CustomBindAdapter {
    /**
     * glide加载图片
     */
    @BindingAdapter(value = ["imageUrl", "error" , "placeHolder"], requireAll = false)
    @JvmStatic
    fun loadImage(imageView: ImageView, url : String , error : Drawable? , placeHolder : Drawable?){
        GlideApp.with(imageView.context)
            .load(url)
            .placeholder(placeHolder)
            .error(error)
            .centerCrop()
            .into(imageView)
    }

    /**
     * recyclerview
     */
    @BindingAdapter(value = ["adapter","layoutManager"], requireAll = false)
    fun setAdapter(recyclerView: RecyclerView, adapter: BaseBindingAdapter<*,*>, layoutManager : RecyclerView.LayoutManager) {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }
}