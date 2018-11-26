package com.amberllo.livedemo.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

open abstract class BasePresenter : LifecycleObserver{
    var mView : IView? = null

    constructor(_view: IView){
        mView = _view
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    fun onPause(){}

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun onResume(){}

    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    fun onCreate(){}

    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){}

}