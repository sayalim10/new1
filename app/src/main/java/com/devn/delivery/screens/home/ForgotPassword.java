package com.devn.delivery.screens.home;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.devn.delivery.R;
import com.devn.delivery.controller.SuperMessActivity;
import com.devn.delivery.devn_exceptions.DevNExcp;
import com.devn.delivery.devn_exceptions.DevNExcpTh;
import com.devn.delivery.screens.home.SignUpScreen;
import com.devn.delivery.utils.Functions;
import com.devn.delivery.utils.V;
import com.devn.delivery.welcome.LoginScreen;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Nitin Kalokhe on 12/16/2016
 * * you can contact me at : nitin3kalokhe@gmail.com
 */
public class ForgotPassword extends SuperMessActivity {

    @Override
    protected void onBackButtonPressed() {
        super.onBackButtonPressed();
    }


    @BindView(R.id.id_forgot_password_phone_no_et)
    EditText userIdET;

    @BindView(R.id.id_forgot_password_submit_btn)
    Button submitBtn;

    @BindView(R.id.id_forgot_password_phone_no_wrapper)
    TextInputLayout phoneNoWrapper;

    @OnTextChanged(R.id.id_forgot_password_phone_no_et)
    void onPhoneNoTextChanged() {
        phoneNoWrapper.setErrorEnabled(false);
    }

    @Override
    protected String TAG() {
        return "Forgot Password";
    }

    @Override
    protected String screenTitle() throws DevNExcp, DevNExcpTh {
        return this.TAG();
    }

    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.forgot_password);

        return rootView;
    }

    @Override
    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {
        submitBtn.requestFocus();
    }


    @OnClick(R.id.id_forgot_password_sign_in_tv)
    void signInBtnClicked() {
        Functions.launch(this, LoginScreen.class);
//        Functions.launch((AppCompatActivity) getActivity(), ((SuperMessActivity) getActivity()).getFrameLayout().getId(), new LoginScreen(), true, true);
    }

    @OnClick(R.id.id_forgot_password_sign_up_tv)
    void signUpBtnClicked() {
        Functions.launch(this, SignUpScreen.class);
//        Functions.launch((AppCompatActivity) getActivity(), ((SuperMessActivity) getActivity()).getFrameLayout().getId(), new LoginScreen(), true, true);
    }

    @OnClick(R.id.id_forgot_password_submit_btn)
    void submitBtnClicked(Button btn) {
        if (getVal(userIdET).contains("@") && !V.isValidEmail(getVal(userIdET))) {
            phoneNoWrapper.setError("Enter valid User ID");
        } else if (!getVal(userIdET).contains("@") && !V.isValidMobile(getVal(userIdET))) {
            phoneNoWrapper.setError("Invalid user id.");
        } else {
            Functions.hideKeyboard(getActivity());
//            Functions.launch((AppCompatActivity) getActivity(), ((SuperMessActivity) getActivity()).getFrameLayout().getId(), new LoginScreen(), true, true);
        }
    }

    @Override
    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
        return this.TAG();
    }
}
