package com.devn.vendor.controller;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.devn.vendor.devn_exceptions.DevNExcp;
import com.devn.vendor.devn_exceptions.DevNExcpTh;

/**
 * Created by Nitin Kalokhe, 9762279667, nitin3kalokhe@gmail.com on 6/12/2016.
 */
public abstract class SuperMessActivity extends AbstractMessControl {


    @Override
    protected abstract View onDevNCreate(Bundle savedInstanceState);

    @Override
    protected abstract void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh;

    @Override
    protected abstract String TAG();

    protected boolean scrollable() throws DevNExcp, DevNExcpTh {
        return true;
    }

    protected boolean addInFrame() throws DevNExcp, DevNExcpTh {
        return false;
    }

    protected LayoutInflater getInflater() {
        return (LayoutInflater) getSystemService(Service.LAYOUT_INFLATER_SERVICE);
    }

    protected View getView(int layoutId) {
        return getInflater().inflate(layoutId, null);
    }

    protected View getChild(View parent, int resId_child) {
        final View child = parent.findViewById(resId_child);
        if (child == null) {
            Log.e(TAG, "child view is null", new DevNExcp("Invalid child resource Id"));
            return parent;
        } else
            return child;
    }

    protected View getView(int layoutId, ViewGroup viewGroup) throws DevNExcp, DevNExcpTh {
        return getInflater().inflate(layoutId, viewGroup);
    }

    protected String getStr(String str) throws DevNExcp, DevNExcpTh {
        if (str == null)
            return "";
        else
            return str;
    }

    protected String getVal(EditText edtTxt) {
        return edtTxt.getText().toString();
    }


    protected boolean isEmpty(String str) throws DevNExcp, DevNExcpTh {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

    @Override
    protected String screenTitle() throws DevNExcp, DevNExcpTh {
        return null;
    }

    @Override
    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
        return null;
    }

    @Override
    protected void onBackButtonPressed() {
        super.callSuperBackButton();

//        super.onBackPressed();
    }

    protected Activity getActivity() {
        return this;
    }
}
