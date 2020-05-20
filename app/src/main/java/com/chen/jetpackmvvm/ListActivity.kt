package com.chen.jetpackmvvm

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chen.jetpackmvvm.base.BaseActivity
import com.chen.jetpackmvvm.base.BaseVmDbActivity
import com.chen.jetpackmvvm.databinding.ActivityListBinding

class ListActivity : BaseActivity<ListViewModel, ActivityListBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_list
    }

    override fun initView() {
        mDatabind.vm = mViewModel
        mDatabind.manager = LinearLayoutManager(this@ListActivity)
        mDatabind.adapter = ListAdapter(this@ListActivity).apply {
            var i = 0
            repeat(30){
                addData(ListBean("测试  $i"))
                i++
            }
        }
    }

    override fun initListener() {

    }

    override fun initData() {

    }
}