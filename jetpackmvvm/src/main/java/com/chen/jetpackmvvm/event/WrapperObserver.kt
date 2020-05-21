package com.chen.jetpackmvvm.event

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


internal open class WrapperObserver<T>(
    var liveData: LiveData<T>,
    val observer: Observer<in T>?,
    var sticky : Boolean = false
) : Observer<T> {


    override fun onChanged(t: T) {
        observer?.onChanged(t)

    }

}
