package com.example.android.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class FramePuzzle extends AppCompatActivity {

    private FrameLayout frameLayout;
    private ImageView topStart;
    private ImageView topCenter;
    private ImageView topEnd;
    private ImageView centerStart;
    private ImageView centerCenter;
    private ImageView centerEnd;
    private ImageView bottomStart;
    private ImageView bottomCenter;
    private ImageView bottomEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_puzzle);
        frameLayout = findViewById(R.id.framePuzzle);
        topStart = findViewById(R.id.top_start);
        topCenter = findViewById(R.id.top_center);
        topEnd = findViewById(R.id.top_end);
        centerStart = findViewById(R.id.center_start);
        centerCenter = findViewById(R.id.center_center);
        centerEnd = findViewById(R.id.center_end);
        bottomStart = findViewById(R.id.bottom_start);
        bottomCenter = findViewById(R.id.bottom_center);
        bottomEnd = findViewById(R.id.bottom_end);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                final int n = 3;
                int width = frameLayout.getWidth();
                int height = frameLayout.getHeight();
                int usualWidth = width / n;
                int usualHeight = height / n;
                int lastWidth = width - (n - 1) * usualWidth;
                int lastHeight = height - (n - 1) * usualHeight;
                topStart.setLayoutParams(new FrameLayout.LayoutParams(usualWidth, usualHeight, Gravity.TOP | Gravity.START));
                topCenter.setLayoutParams(new FrameLayout.LayoutParams(usualWidth, usualHeight, Gravity.TOP | Gravity.CENTER_HORIZONTAL));
                topEnd.setLayoutParams(new FrameLayout.LayoutParams(lastWidth, usualHeight, Gravity.TOP | Gravity.END));
                centerStart.setLayoutParams(new FrameLayout.LayoutParams(usualWidth, usualHeight, Gravity.CENTER_VERTICAL | Gravity.START));
                centerCenter.setLayoutParams(new FrameLayout.LayoutParams(usualWidth, usualHeight, Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL));
                centerEnd.setLayoutParams(new FrameLayout.LayoutParams(lastWidth, usualHeight, Gravity.CENTER_VERTICAL | Gravity.END));
                bottomStart.setLayoutParams(new FrameLayout.LayoutParams(usualWidth, lastHeight, Gravity.BOTTOM | Gravity.START));
                bottomCenter.setLayoutParams(new FrameLayout.LayoutParams(usualWidth, lastHeight, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL));
                bottomEnd.setLayoutParams(new FrameLayout.LayoutParams(lastWidth, lastHeight, Gravity.BOTTOM | Gravity.END));
                frameLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        InvisibilityMaker invisibilityMaker = new InvisibilityMaker();
        topStart.setOnClickListener(invisibilityMaker);
        topCenter.setOnClickListener(invisibilityMaker);
        topEnd.setOnClickListener(invisibilityMaker);
        centerStart.setOnClickListener(invisibilityMaker);
        centerCenter.setOnClickListener(invisibilityMaker);
        centerEnd.setOnClickListener(invisibilityMaker);
        bottomStart.setOnClickListener(invisibilityMaker);
        bottomCenter.setOnClickListener(invisibilityMaker);
        bottomEnd.setOnClickListener(invisibilityMaker);
    }
}
