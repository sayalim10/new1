package com.devn.vendor.welcome;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.devn.vendor.R;
import com.devn.vendor.utils.Functions;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Nitin Kalokhe on 10/11/2016
 * for Mescorp.
 * you can contact me at : nitin3kalokhe@gmail.com
 * * Copyright (c) 2016 Mescorp. All rights reserved.
 */
public class DisclaimerScreen extends Activity {


    @OnClick(R.id.id_disclaimer_reject_btn)
    public void onRejectBtnClicked() {
        finish();
    }

    @OnClick(R.id.id_disclaimer_accept_btn)
    public void onAcceptBtnClicked() {
        Functions.launch(this, LoginScreen.class);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer_screen);
        ButterKnife.bind(DisclaimerScreen.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onAcceptBtnClicked();
            }
        }, 1000);

    }
}
