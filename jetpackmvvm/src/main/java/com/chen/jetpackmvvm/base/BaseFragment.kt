package com.chen.jetpackmvvm.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

/**
 * @author Created by CHEN on 2020/5/21
 * @email 188669@163.com
 */
abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : BaseVmFragment<VM, DB>() {
}