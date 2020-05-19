package com.chen.jetpackmvvm

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.chen.jetpackmvvm.base.BaseBindingAdapter
import com.chen.jetpackmvvm.base.BaseBindingDBAdapter
import com.chen.jetpackmvvm.databinding.ItemListBinding
import com.chen.jetpackmvvm.databinding.ItemListTypeBinding

class ListAdapter(var mContext : Context) : BaseBindingDBAdapter<ListBean,ItemListBinding>(mContext) {

    override fun onBindVH(binding: ItemListBinding?, holder: RecyclerView.ViewHolder, position: Int) {
        binding?.item =  mList[position]
//        when {
//            binding is ItemListBinding ->  binding.item =  mList[position]
//            binding is ItemListTypeBinding ->  binding.item =  mList[position]
//
//        }
    }

    override fun getLayoutResId(viewType: Int): Int {
        return R.layout.item_list
//        return when(viewType){
//            1 -> R.layout.item_list
//            else -> R.layout.item_list_type
//        }
    }

//    override fun getItemViewType(position: Int): Int {
//        return when{
//            position < 10 -> 1
//            else -> 2
//        }
//    }


}