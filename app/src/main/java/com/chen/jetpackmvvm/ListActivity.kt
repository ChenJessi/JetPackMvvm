package com.chen.jetpackmvvm

import com.chen.jetpackmvvm.base.BaseVmDbActivity
import com.chen.jetpackmvvm.databinding.ActivityListBinding

class ListActivity : BaseVmDbActivity<ListViewModel, ActivityListBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_list
    }

    override fun initView() {
        mDatabind.vm = mViewModel
        mDatabind.adapter = ListAdapter(this@ListActivity)
    }

    override fun initListener() {

    }

    override fun initData() {

    }
}