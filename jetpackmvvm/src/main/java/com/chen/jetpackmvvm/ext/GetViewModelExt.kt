package com.chen.jetpackmvvm.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chen.jetpackmvvm.base.BaseActivity
import com.chen.jetpackmvvm.base.BaseViewModel

/**
 * 获取ViewModel
 */
inline fun <reified VM : BaseViewModel> Fragment.getViewModel() : VM{
    return ViewModelProvider(this).get(getClazz(this))
}

inline fun <reified VM : BaseViewModel> AppCompatActivity.getViewModel() : VM{
    return ViewModelProvider(this).get(getClazz(this))
}