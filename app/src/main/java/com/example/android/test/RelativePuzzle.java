package com.example.android.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class RelativePuzzle extends AppCompatActivity {
    private RelativeLayout relativePuzzle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_puzzle);
        relativePuzzle = findViewById(R.id.relativePuzzle);
        relativePuzzle.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                final int n = 3;
                int width = relativePuzzle.getWidth();
                int height = relativePuzzle.getHeight();
                int usualWidth = width / n;
                int usualHeight = height / n;
                int lastWidth = width - (n - 1) * usualWidth;
                int lastHeight = height - (n - 1) * usualHeight;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        ImageView child = (ImageView) relativePuzzle.getChildAt(i * n + j);
                        int currentWidth = j == n - 1 ? lastWidth : usualWidth;
                        int currentHeight = i == n - 1 ? lastHeight : usualHeight;
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(currentWidth, currentHeight);
                        if (i != 0 || j != 0) {
                            if (j > 0) {
                                params.addRule(RelativeLayout.END_OF, relativePuzzle.getChildAt(i * n + j - 1).getId());
                                // System.out.println(relativePuzzle.getChildAt(i * n + j - 1).getId());
                            }
                            if (i > 0) {
                                params.addRule(RelativeLayout.BELOW, relativePuzzle.getChildAt((i - 1) * n + j).getId());
                                // System.out.println(relativePuzzle.getChildAt((i - 1) * n + j).getId());
                            }

                        }
                        child.setLayoutParams(params);
                    }
                }
                relativePuzzle.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        InvisibilityMaker invisibilityMaker = new InvisibilityMaker();
        for (int i = 0; i < relativePuzzle.getChildCount(); i++) {
            relativePuzzle.getChildAt(i).setOnClickListener(invisibilityMaker);
        }
    }
}