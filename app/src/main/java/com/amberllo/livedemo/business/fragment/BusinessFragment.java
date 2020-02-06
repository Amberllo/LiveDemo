package com.amberllo.livedemo.business.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.amberllo.livedemo.R;
import com.amberllo.livedemo.business.fragment.viewmodel.BusinessViewModel;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BusinessFragment extends BaseLazyLoadFragment {

    private BusinessViewModel mViewModel;

    @BindView(R.id.buttomView)
    View bottomView;

    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    @BindView(R.id.edittext)
    EditText editText;

    public static BusinessFragment newInstance() {
        return new BusinessFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.business_fragment, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    protected void onLazyLoad(Context context) {

        KeyboardVisibilityEvent.setEventListener(
                getActivity(),
                isOpen -> {
                    // some code depending on keyboard visiblity status
                    bottomView.setVisibility(isOpen?View.GONE:View.VISIBLE);
                    if (isOpen && editText.isFocused()) {
                        scrollView.scrollTo(0, (int) editText.getY());
                    }

                });
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BusinessViewModel.class);

    }

}
