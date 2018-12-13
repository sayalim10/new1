package com.devn.delivery.devn_exceptions;

import com.devn.delivery.devn_exceptions.DevNLogWriter;

/**
 * Created by Nitin Kalokhe on 10/2/2016
 * for Mescorp.
 * you can contact me at : nitin3kalokhe@gmail.com
 * * Copyright (c) 2016 Mescorp. All rights reserved.
 */
public class DevNExcp extends Exception {

    public DevNExcp(String message) {
        super(message);
        DevNLogWriter.print("DevNExcp", message);
    }

    public DevNExcp(String TAG, String message) {
        super(message);
        DevNLogWriter.print(TAG, message);
    }

    public DevNExcp(String TAG, Exception e) {
        super(e.getMessage());
        DevNLogWriter.print(TAG, e.getMessage());
        e.printStackTrace();
    }
}