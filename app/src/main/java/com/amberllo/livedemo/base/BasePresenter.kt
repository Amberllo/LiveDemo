package com.amberllo.livedemo.base

import android.app.Activity

open class BasePresenter : IBasePresenter {
    var mView : IView? = null

    constructor(_view: IView){
        mView = _view
    }

    override fun onDestroy() {
        println(11)
    }

    override fun onCreate() {
        println(11)
    }

}