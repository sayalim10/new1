package com.devn.vendor.devn_exceptions;

import android.util.Log;

/**
 * Created by Nitin Kalokhe, 9762279667, nitin3kalokhe@gmail.com on 6/12/2016.
 */
public class DevNAuthenticationExcp extends DevNExcpTh {

    public DevNAuthenticationExcp(String message) {
        super(message);
        DevNLogWriter.print("DevNAuthenticationExcp", message);
    }

    public DevNAuthenticationExcp(String TAG, String message) {
        super(message);
        DevNLogWriter.print(TAG, message);
    }

}
