package com.example.android.test;

import android.view.View;

public class InvisibilityMaker implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        v.setVisibility(View.INVISIBLE);
    }
}
