package com.chen.jetpackmvvm.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.getBinding
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


abstract class BaseBindingAdapter<M, DB : ViewDataBinding>(var mContext : Context) : RecyclerView.Adapter<BaseBindViewHolder>() {

    private val mList = ArrayList<M>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(mContext), getLayoutResId(viewType), parent, false)
        return BaseBindViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: BaseBindViewHolder, position: Int) {
        val binding : DB? = getBinding<DB>(holder.itemView)
        onBindVH(binding ,holder, position)
        binding?.executePendingBindings()
    }

    abstract fun onBindVH(binding: DB?, holder: ViewHolder, position: Int)

    /**
     * 根据type 获取布局
     */
    @LayoutRes
    protected abstract fun getLayoutResId(viewType : Int) : Int


}