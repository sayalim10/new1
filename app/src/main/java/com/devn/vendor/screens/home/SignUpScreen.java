package com.devn.vendor.screens.home;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devn.vendor.R;
import com.devn.vendor.controller.SuperMessActivity;
import com.devn.vendor.devn_exceptions.DevNExcp;
import com.devn.vendor.devn_exceptions.DevNExcpTh;
import com.devn.vendor.screens.custom_screens.TandCView;
import com.devn.vendor.utils.Functions;
import com.devn.vendor.utils.V;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Lenovo on 7/29/2018.
 */

public class SignUpScreen extends SuperMessActivity {


    @Override
    protected String TAG() {
        return "Sign Up Screen";
    }

    @Override
    protected String screenTitle() throws DevNExcp, DevNExcpTh {
        return "Sign Up";
    }

    @Override
    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
        return this.screenTitle();
    }

    @Override
    protected void onBackButtonPressed() {
        super.onBackButtonPressed();
    }

    @BindView(R.id.id_signup_screen_fname_et)
    EditText fNameET;

    @BindView(R.id.id_signup_screen_lname_et)
    EditText lNameET;

    @BindView(R.id.id_signup_screen_emailid_et)
    EditText mailET;

    @BindView(R.id.id_signup_screen_u_name_et)
    EditText uNameET;

    @BindView(R.id.id_signup_screen_pass_et)
    EditText passET;

    @BindView(R.id.id_signup_screen_sign_btn)
    Button loginBtn;

    @BindView(R.id.id_signup_screen_fname_wrapper)
    TextInputLayout fNameWrapper;

    @BindView(R.id.id_signup_screen_emailid_wrapper)
    TextInputLayout emailWrapper;

    @BindView(R.id.id_signup_screen_lname_wrapper)
    TextInputLayout lNameWrapper;

    @BindView(R.id.id_signup_screen_userid_wrapper)
    TextInputLayout usernameWrapper;

    @BindView(R.id.id_signup_screen_password_wrapper)
    TextInputLayout passwordWrapper;

    @OnClick(R.id.id_signup_screen_sign_btn)
    void loginBtnClicked(Button btn) {
//        if (!validate())
//            return;
        Functions.hideKeyboard(getActivity());
//        Toast.makeText(getActivity(), "Login Btn Clicked", Toast.LENGTH_SHORT).show();
//        Functions.launch(this, AddressScreen.class);
//        Functions.launch(this, ValidateOTPScreen.class);
    }

    @OnClick(R.id.id_signup_screen_forgot_password_tv)
    void forgotPasswordTVClicked() {
//        Functions.launch((AppCompatActivity) getActivity(), ((SuperMessActivity) getActivity()).getFrameLayout().getId(), new ForgotPassword(), true, true);
        Functions.launch((AppCompatActivity) getActivity(), ForgotPassword.class);
    }

    @OnCheckedChanged(R.id.id_signup_screen_tc_cb)
    void TCCBClicked(android.widget.CompoundButton checkBox, boolean checked) {
        if (checked) {
            Toast.makeText(getActivity(), "Checked", Toast.LENGTH_SHORT).show();
        } else if (!checked) {
            Toast.makeText(getActivity(), "Unchecked", Toast.LENGTH_SHORT).show();
        }
    }

    @OnTextChanged(R.id.id_signup_screen_u_name_et)
    void onUserIDTextChanged() {
        usernameWrapper.setErrorEnabled(false);
    }

    @OnTextChanged(R.id.id_signup_screen_pass_et)
    void onPasswordTextChanged() {
        passwordWrapper.setErrorEnabled(false);
    }

    @OnTextChanged(R.id.id_signup_screen_fname_et)
    void onFirstNameTextChanged() {
        fNameWrapper.setErrorEnabled(false);
    }


    @OnTextChanged(R.id.id_signup_screen_lname_et)
    void onLastNameTextChanged() {
        lNameWrapper.setErrorEnabled(false);
    }


    @OnTextChanged(R.id.id_signup_screen_emailid_et)
    void onEmailIdTextChanged() {
        emailWrapper.setErrorEnabled(false);
    }


    @OnClick(R.id.id_signup_screen_tc_tv)
    void TCTVClicked() {
        new TandCView(this).showDialog();
    }

    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.activity_singup_screen);

        return rootView;
    }

    @Override
    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {
        loginBtn.requestFocus();
    }

//    @Override
//    public void onBackPressed() {
//        moveTaskToBack(true);
//    }

    private void onLoginSuccess() {

    }

    private void onLoginFailed() {

    }

    private boolean validate() {
        boolean valid = false;
        String msg = null;
        if (V.isEmpty(getVal(fNameET))) {
            valid = false;
            fNameWrapper.setError("Enter first name");
        } else if (V.isEmpty(getVal(lNameET))) {
            valid = false;
            lNameWrapper.setError("Enter last name");
        } else if (V.isEmpty(getVal(uNameET))) {
            valid = false;
            usernameWrapper.setError("Enter user ID");
        } else if (valid && !V.isValidMobile(getVal(uNameET))) {
            valid = false;
            usernameWrapper.setError("Enter valid user ID");
        } else if (getVal(mailET).contains("@") && !V.isValidEmail(getVal(mailET))) {
            valid = false;
            emailWrapper.setError("Enter valid user ID");
        } else if (V.isEmpty(getVal(passET))) {
            valid = false;
            passwordWrapper.setError("Enter password");
        } else
            valid = true;

        return valid;
    }

}
