package com.amberllo.livedemo.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

abstract class BasePresenter(_view: IView) : LifecycleObserver{
    var mView : IView? = _view

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    fun onPause(){}

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun onResume(){}

    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    fun onCreate(){}

    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){}

}