package com.devn.vendor.utils;

import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.devn.vendor.R;
import com.devn.vendor.devn_exceptions.DevNExcp;

/**
 * Created by Nitin Kalokhe on 10/11/2016
 * for Mescorp.
 * you can contact me at : nitin3kalokhe@gmail.com
 * * Copyright (c) 2016 Mescorp. All rights reserved.
 */
public class Alert {

    public enum TYPE {
        OK, OK_CANCEL, CUSTOM, PROGRESS
    }

    private static final String TAG = "Alert.java";
    private static AlertDialog dialog;
    private static Context mContext;
    private static Alert instance;
    private String mTitle = null;

    private Alert(Context context) {
        this.mContext = context;
    }

    public static Alert INSTANCE(Context context) {
        if (instance == null)
            instance = new Alert(context);
        else if (mContext != context)
            instance = new Alert(context);

        return instance;
    }

    public AlertDialog show(TYPE type, String message, String[] pos_neg_neu, DialogInterface.OnClickListener... alertListener) {
        if (type == TYPE.OK)
            show(TYPE.OK, message, alertListener);
        else if (type == TYPE.OK_CANCEL) {
            show(TYPE.OK_CANCEL, message, alertListener);
        } else if (type == TYPE.CUSTOM) {
            final AlertDialog.Builder builder = show(TYPE.CUSTOM, message, alertListener);
            builder.setPositiveButton(pos_neg_neu[0], alertListener != null ? alertListener[0] : new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null)
                        dialog.dismiss();
                }
            });
            builder.setNegativeButton(pos_neg_neu[1], alertListener != null ? alertListener[1] : new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null)
                        dialog.dismiss();
                }
            });
            builder.setNeutralButton(pos_neg_neu[2], alertListener != null ? alertListener[0] : new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (dialog != null)
                        dialog.dismiss();
                }
            });
            dialog = builder.create();
            dialog.show();

        }

        return dialog;
    }


    public AlertDialog.Builder show(TYPE type, String message, DialogInterface.OnClickListener... alertListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.AlertDialogTheme);
        try {
            if (type == TYPE.PROGRESS) {
                View view = ((LayoutInflater) mContext.getSystemService(Service.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.progress_bar_dialog, null);
                builder.setView(view);
                dialog = builder.create();
                if (message != null && message.length() > 0)
                    ((TextView) view.findViewById(R.id.id_mess_progress_dialog_lable_tv)).setText(message);
                dialog.show();
            } else {
                builder.setTitle(getTitle() != null ? getTitle() : mContext.getString(R.string.app_name));
                builder.setMessage(message);
            }

            if (type == TYPE.OK) {
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (dialog != null)
                            dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();

            } else if (type == TYPE.OK_CANCEL) {
                builder.setPositiveButton("Ok", alertListener[0] != null ? alertListener[0] : new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (dialog != null)
                            dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (dialog != null)
                            dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();
            } else if (type == TYPE.CUSTOM) {
                // this will only create dialog, customization will be done
                new DevNExcp(TAG, "Ensure you have provided custom button names and listeners!");
            }

        } catch (Exception e) {
            new DevNExcp(TAG, e);
        }
        return builder;
    }


    public AlertDialog dismiss(Context context) {
        if (mContext == context) {
            dialog.dismiss();
            return dialog;
        } else
            new DevNExcp(TAG, "Mismatch Context found While dismiss dialog");
        return null;

    }

    public AlertDialog getDialog(Context context) {
        if (dialog != null && mContext == context)
            return dialog;
        else
            new DevNExcp(TAG, "No Dialog were created with given Context");

        return null;
    }


    public String getTitle() {
        return mTitle;
    }

    public Alert withTitle(String mTitle) {
        this.mTitle = mTitle;
        return instance;
    }
}
