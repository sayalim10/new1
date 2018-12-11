package com.devn.vendor.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.devn.vendor.R;
import com.devn.vendor.devn_exceptions.DevNLogWriter;
import com.google.firebase.analytics.FirebaseAnalytics;

import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2/17/2018.
 */

public abstract class NewAbstractionLayer extends AppCompatActivity {

    protected abstract View onSuperCreate(@Nullable Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            final View mainView = getLayoutInflater().inflate(R.layout.new_abstraction_layer_layout, null);
            setContentView(mainView);
            new DevNLogWriter().registerCrash(this);
            FrameLayout container = (FrameLayout) findViewById(R.id.id_main_container);
            container.addView(onSuperCreate(savedInstanceState));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
