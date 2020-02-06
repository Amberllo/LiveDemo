package com.amberllo.livedemo.business.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.amberllo.livedemo.R;
import com.amberllo.livedemo.business.widget.WaveView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AudioRecordActivity extends AppCompatActivity {

    @OnClick(R.id.activity_wave_stop)
    void clickStop(){
        waveView.stop();
    }

    @OnClick(R.id.activity_wave_start)
    void clickStart(){
        waveView.start();
    }

    @BindView(R.id.activity_wave_view)
    WaveView waveView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_record);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }

}
