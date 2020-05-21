package com.chen.jetpackmvvm.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.chen.jetpackmvvm.event.AppViewModel
import com.chen.jetpackmvvm.ext.getViewModel

abstract class BaseSupportActivity <VM : ViewModel, DB : ViewDataBinding> : BaseActivity<VM, DB>() {

    val appViewModel : AppViewModel by lazy { getViewModel<AppViewModel>() }
}