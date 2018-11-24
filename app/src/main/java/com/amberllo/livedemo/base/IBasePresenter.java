package com.amberllo.livedemo.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public interface IBasePresenter extends LifecycleObserver {
    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    void onCreate();

    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
    void onDestroy();
}
