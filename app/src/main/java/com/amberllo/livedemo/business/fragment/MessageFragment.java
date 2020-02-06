package com.amberllo.livedemo.business.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.amberllo.livedemo.R;
import com.amberllo.livedemo.business.fragment.viewmodel.MessageViewModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageFragment extends BaseLazyLoadFragment {

    private MessageViewModel mViewModel;

    @BindView(R.id.message_text)
    Button tvText;

    @BindView(R.id.message_image)
    SimpleDraweeView simpleDraweeView;

    @BindView(R.id.message_loading)
    ProgressBar progressBar;

    @OnClick(R.id.message_text)
    void onClick() {


        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable anim) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onSubmit(String id, Object callerContext) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                progressBar.setVisibility(View.GONE);
            }
        };

        String url = "https://images.mhealth100.com/images/patConsultImage/00252/1574135565355_78924.jpg";
        Uri uri = Uri.parse(url);
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setControllerListener(controllerListener)
                .setOldController(simpleDraweeView.getController())
                .build();
        simpleDraweeView.setController(controller);

    }

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void onLazyLoad(Context context) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
    }

}
