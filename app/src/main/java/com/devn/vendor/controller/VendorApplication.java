package com.devn.vendor.controller;

import android.support.multidex.MultiDexApplication;
import android.widget.Toast;

/**
 * Created by Nitin Kalokhe on 10/2/2016
 * for Mescorp.
 * you can contact me at : nitin3kalokhe@gmail.com
 * * Copyright (c) 2016 Mescorp. All rights reserved.
 */
public class VendorApplication extends MultiDexApplication {

    private static VendorApplication instance;

    public VendorApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Toast.makeText(VendorApplication.this, "You are experiencing Low Memory. Please free some memory.", Toast.LENGTH_LONG).show();
    }
}