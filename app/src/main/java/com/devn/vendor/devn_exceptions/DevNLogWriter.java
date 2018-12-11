package com.devn.vendor.devn_exceptions;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.devn.vendor.constants.Constants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Nitin Kalokhe, 9762279667, nitin3kalokhe@gmail.com on 6/12/2016.
 */
public class DevNLogWriter {

    public void registerCrash(Context context) {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(context));
    }

    public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
        private final Context mContext;
        private final String LINE_SEPARATOR = "\n";
        Thread.UncaughtExceptionHandler defaultUEH;

        public ExceptionHandler(Context context) {
            mContext = context;
            defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
        }

        @Override
        public void uncaughtException(Thread thread, Throwable exception) {
            StringWriter stackTrace = new StringWriter();
            exception.printStackTrace(new PrintWriter(stackTrace));

            StringBuilder errorReport = new StringBuilder();
            errorReport.append("DevN ****** CAUSE OF ERROR ******* \n \n \n");
            errorReport.append(stackTrace.toString());
            errorReport.append("DevN ****** DEVICE INFORMATION ******");
            errorReport.append("Brand: ");
            errorReport.append(Build.BRAND);
            errorReport.append(LINE_SEPARATOR);
            errorReport.append("Device: ");
            errorReport.append(Build.DEVICE);
            errorReport.append(LINE_SEPARATOR);
            errorReport.append("Model: ");
            errorReport.append(Build.MODEL);
            errorReport.append(LINE_SEPARATOR);
            File root = android.os.Environment.getExternalStorageDirectory();
            String currentDateTimeStr = DateFormat.getDateTimeInstance().format(new Date());

            File dir = new File(root.getAbsolutePath() + Constants.APPLICATION_NAME + "/" + Constants.LOG_FILE);
            if (!dir.exists())
                dir.mkdirs();

            File file = new File(dir, Constants.LOG_FILE + ".txt");

            try {
                BufferedWriter buf = new BufferedWriter(new FileWriter(file, true));
                buf.append(currentDateTimeStr + " : " + errorReport.toString());
                buf.newLine();
                buf.close();
            } catch (IOException e) {
                new DevNExcpTh(e.toString());
            }

            defaultUEH.uncaughtException(thread, exception);

            if (mContext instanceof Activity)
                ((Activity) mContext).finish();
        }
    }


    public static void print(String TAG, String log) {
        Log.e("**DevNLog** " + TAG, log);
    }
}
