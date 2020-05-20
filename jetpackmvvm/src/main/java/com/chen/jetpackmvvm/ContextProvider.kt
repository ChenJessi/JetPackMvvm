package com.chen.jetpackmvvm

import android.content.Context

object ContextProvider {

    fun getContext() : Context{
        return AppContextProvider.mContext
    }
}