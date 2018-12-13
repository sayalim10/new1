package com.devn.delivery.devn_exceptions;

import android.util.Log;

import com.devn.delivery.devn_exceptions.DevNLogWriter;

/**
 * Created by Nitin Kalokhe, 9762279667, nitin3kalokhe@gmail.com on 6/12/2016.
 */
public class DevNExcpTh extends Throwable {

    public DevNExcpTh(String message) {
        super(message);
        DevNLogWriter.print("DevNExcpTh", message);
    }

    public DevNExcpTh(String TAG, String message) {
        super(message);
        DevNLogWriter.print(TAG, message);
    }

    public DevNExcpTh(String TAG, Throwable th) {
        super(th.getMessage());
        DevNLogWriter.print(TAG, th.getMessage());
        th.printStackTrace();
    }

}
