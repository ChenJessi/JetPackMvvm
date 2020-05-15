package com.chen.jetpackmvvm

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.chen.jetpackmvvm.base.BaseBindingAdapter
import com.chen.jetpackmvvm.databinding.ItemListBinding

class ListAdapter(var context : Context) : BaseBindingAdapter<ListBean, ItemListBinding>(context) {

    override fun onBindVH(
        binding: ItemListBinding?,
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {

    }

    override fun getLayoutResId(viewType: Int): Int {
        return R.layout.item_list
    }
}