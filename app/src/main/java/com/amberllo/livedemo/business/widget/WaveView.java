package com.amberllo.livedemo.business.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaveView extends View {

    private final int STATE_STOP = 0;
    private final int STATE_PLAYING = 1;

    private int width = 40;
    private int divide = 20;

    private int state = STATE_STOP;

    /**
     * 1分贝 刚能听到的声音
     * 15 分贝以下	感觉安静
     * 30 分贝	耳语的音量大小
     * 40 分贝	冰箱的嗡嗡声
     * 60分贝	正常交谈的声音
     * 70分贝	相当于走在闹市区
     * 85分贝	汽车穿梭的马路上
     * 95分贝	摩托车启动声音
     * 100分贝	装修电钻的声音
     * 110分贝 卡拉OK、大声播放MP3 的声音
     * 120分贝 飞机起飞时的声音
     * 150分贝 燃放烟花爆竹的声音
     */

    List<Integer> fbValues = new ArrayList<>();

    public WaveView(Context context) {
        super(context);
        init(context);
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        for (int i = 0; i < 100; i++) {
            int fb = new Random().nextInt(150);
            fbValues.add(fb);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        offset = getWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#34c094"));
        int start = (int) getX();
        List<Rect> rects = new ArrayList<>();
        for (int i = 0; i < fbValues.size(); i++) {
            int left = start + offset;
            if (i >= 1) {
                left = rects.get(i - 1).right + divide;
            }
            Rect rect = new Rect(left, (int) (getY() + getHeight() - fbValues.get(i)), left + width, (int) getY() + getHeight());
            canvas.drawRect(rect, paint);
            rects.add(rect);
        }
    }

    int offset = 0;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            offset = offset - 10;
            invalidate();
            handler.postDelayed(runnable, 16);
        }
    };

    public void start() {
        if (state == STATE_PLAYING) {
            return;
        }
        state = STATE_PLAYING;
        offset = getWidth();
        handler.post(runnable);
    }

    public void stop() {
        state = STATE_STOP;
        offset = getWidth();
        handler.removeCallbacks(runnable);

    }
}
