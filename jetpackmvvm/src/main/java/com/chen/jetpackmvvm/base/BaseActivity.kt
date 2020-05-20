package com.chen.jetpackmvvm.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

/**
 * @author Created by CHEN on 2020/4/29
 * @email 188669@163.com
 */
abstract class BaseActivity <VM : ViewModel, DB : ViewDataBinding> : BaseVmDbActivity<VM, DB>() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}