package com.amberllo.livedemo.business.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Amberllo on 18/3/9.
 * 懒加载Fragment，先渲染页面，在手动加载数据
 */

public abstract class BaseLazyLoadFragment extends Fragment {


    // 控件是否初始化完成
    // 我们在控件初始化完成之后再进行数据的加载，否则对控件进行操作的时候会遇到空指针异常
    protected boolean isViewCreated;

    // 是否加载过数据
    // 我们判断未曾加载过数据的话再进行获取，否则每次对用户可见时都会执行懒加载的方法
    protected boolean isUIVisible;

    protected abstract void onLazyLoad(Context context);

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            // 只有在对用户可见、控件初始化完成并且未曾加载过数据的情况下才进行懒加载
            isUIVisible = true;
            lazyLoad();
        }else {
            isUIVisible = false;
        }
    }
    private void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            onLazyLoad(getContext());
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
        }
    }


    // ViewPager的第一个Fragment默认执行setUserVisibleHint(fasle)方法
    // 所以在activity创建完成后要让第一页也加载数据
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {
            // 此处不需要判断isViewCreated，因为这个方法在onCreateView方法之后执行
//            onLazyLoad(getContext());
//            isLoadCompleted = true;
        }
    }


}