package com.devn.vendor.screens.home;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devn.vendor.R;
import com.devn.vendor.controller.SuperMessActivity;
import com.devn.vendor.devn_exceptions.DevNExcp;
import com.devn.vendor.devn_exceptions.DevNExcpTh;
import com.devn.vendor.utils.Functions;
import com.devn.vendor.utils.V;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Lenovo on 7/30/2018.
 */

public class ResetPasswordScreen extends SuperMessActivity {

    @Override
    protected void onBackButtonPressed() {
        super.onBackButtonPressed();
    }

    @Override
    protected String TAG() {
        return "Reset Password Screen";
    }

    @Override
    protected String screenTitle() throws DevNExcp, DevNExcpTh {
        return "Reset Password";
    }

    @Override
    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
        return this.screenTitle();
    }


    @BindView(R.id.id_rest_psswrd_re_pass_et)
    EditText rePassET;

    @BindView(R.id.id_rest_psswrd_pass_et)
    EditText passET;

    @BindView(R.id.id_rest_psswrd_cnfrm_btn)
    Button confrmBtn;

    @BindView(R.id.id_rest_psswrd_pass_wrapper)
    TextInputLayout passWrapper;

    @BindView(R.id.id_rest_psswrd_re_pass_wrapper)
    TextInputLayout repassWrapper;

    @OnClick(R.id.id_rest_psswrd_cnfrm_btn)
    void confrmPasswordBtnClicked(Button btn) {
        if (!validate())
            return;
        Functions.hideKeyboard(getActivity());
        Toast.makeText(getActivity(), "New password confirmed", Toast.LENGTH_SHORT).show();
//        Functions.launch(getActivity(), DisclaimerScreen.class);
    }

    @OnTextChanged(R.id.id_rest_psswrd_pass_et)
    void onUserIDTextChanged() {
        passWrapper.setErrorEnabled(false);
    }

    @OnTextChanged(R.id.id_rest_psswrd_re_pass_et)
    void onPasswordTextChanged() {
        repassWrapper.setErrorEnabled(false);
    }


    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.activity_reset_password);

        return rootView;
    }

    @Override
    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {
        confrmBtn.requestFocus();
    }

    private boolean validate() {
        boolean valid = false;
        String msg = null;
        if (V.isEmpty(getVal(passET))) {
            valid = false;
            repassWrapper.setError("Enter password");
        } else if (V.isEmpty(getVal(rePassET))) {
            valid = false;
            passWrapper.setError("Enter confirm password");
        } else if (getVal(passET).length() != getVal(rePassET).length()) {
            valid = false;
            Toast.makeText(this, "Password mismatch", Toast.LENGTH_SHORT).show();
        } else if (!getVal(passET).equals(getVal(rePassET))) {
            valid = false;
            Toast.makeText(this, "Password mismatch", Toast.LENGTH_SHORT).show();
        } else
            valid = true;

        return valid;
    }

}
