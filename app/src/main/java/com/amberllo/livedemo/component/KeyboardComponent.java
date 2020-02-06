package com.amberllo.livedemo.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;

public class KeyboardComponent {

    private static KeyboardComponent instance;
    public static KeyboardComponent getInstance(){
        if(instance == null){
            instance = new KeyboardComponent();
        }
        return instance;
    }

    public View getInputMethodView(Context context){
        int layout = (Resources.getSystem().getIdentifier("input_method", "layout", "android"));
        View mRootView = LayoutInflater.from(context).inflate(
                layout, null);
        return mRootView;


    }
}
