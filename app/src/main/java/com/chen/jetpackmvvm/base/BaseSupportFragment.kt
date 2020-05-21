package com.chen.jetpackmvvm.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.chen.jetpackmvvm.event.AppViewModel
import com.chen.jetpackmvvm.ext.getViewModel

abstract class BaseSupportFragment<VM : ViewModel, DB : ViewDataBinding> : BaseFragment<VM, DB>() {
    val appViewModel : AppViewModel by lazy { getViewModel<AppViewModel>() }
}