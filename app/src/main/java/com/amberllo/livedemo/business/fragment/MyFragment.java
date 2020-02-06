package com.amberllo.livedemo.business.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amberllo.livedemo.R;
import com.amberllo.livedemo.business.activity.AudioRecordActivity;
import com.amberllo.livedemo.business.fragment.viewmodel.MyViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyFragment extends BaseLazyLoadFragment {

    private MyViewModel mViewModel;

    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @OnClick(R.id.fragment_my_button)
    void onClickAudio(){
        startActivity(new Intent(getContext(), AudioRecordActivity.class));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.my_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    protected void onLazyLoad(Context context) {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

    }

}
