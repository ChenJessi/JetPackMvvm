package com.chen.jetpackmvvm.ext

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

/**
 * 获取ViewModel
 */
fun <VM> Fragment.getViewModel() : VM{
    return ViewModelProvider(this).get(getClazz(this))
}