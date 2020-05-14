package com.chen.jetpackmvvm.adapter

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestOptions
import com.chen.jetpackmvvm.utils.GlideApp


object CustomBindAdapter {

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
}