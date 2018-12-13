package com.devn.delivery.welcome;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devn.delivery.R;
import com.devn.delivery.controller.SuperMessActivity;
import com.devn.delivery.devn_exceptions.DevNExcp;
import com.devn.delivery.devn_exceptions.DevNExcpTh;
import com.devn.delivery.screens.custom_screens.TandCView;
import com.devn.delivery.screens.home.ForgotPassword;
import com.devn.delivery.screens.home.ResetPasswordScreen;
import com.devn.delivery.screens.home.SignUpScreen;
import com.devn.delivery.utils.Functions;
import com.devn.delivery.utils.V;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Nitin Kalokhe on 6/10/2016.
 */
public class LoginScreen extends SuperMessActivity {

    @Override
    protected void onBackButtonPressed() {
        super.onBackButtonPressed();
    }

    @Override
    protected String TAG() {
        return "Login Screen";
    }

    @Override
    protected String screenTitle() throws DevNExcp, DevNExcpTh {
        return "Welcome";
    }

    @Override
    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
        return this.screenTitle();
    }


    @BindView(R.id.id_login_screen_u_name_et)
    EditText uNameET;

    @BindView(R.id.id_login_screen_pass_et)
    EditText passET;

    @BindView(R.id.id_login_screen_login_btn)
    Button loginBtn;

    @BindView(R.id.id_login_screen_userid_wrapper)
    TextInputLayout usernameWrapper;

    @BindView(R.id.id_login_screen_password_wrapper)
    TextInputLayout passwordWrapper;

    @OnClick(R.id.id_login_screen_login_btn)
    void loginBtnClicked(Button btn) {
        if (!validate())
            return;
        Functions.hideKeyboard(getActivity());
        Toast.makeText(getActivity(), "Login Btn Clicked", Toast.LENGTH_SHORT).show();
//        Functions.launch(getActivity(), DisclaimerScreen.class);
    }

    @OnClick(R.id.id_login_screen_signup_tv)
    void signUpTVClicked() {
//        Functions.launch((AppCompatActivity) getActivity(), ((SuperMessActivity) getActivity()).getFrameLayout().getId(), new AddressScreen(), true, true);
//        Functions.launch((AppCompatActivity) getActivity(), AddressScreen.class);
        Functions.launch((AppCompatActivity) getActivity(), SignUpScreen.class);

    }

    @OnClick(R.id.id_login_screen_forgot_password_tv)
    void forgotPasswordTVClicked() {
//        Functions.launch((AppCompatActivity) getActivity(), ((SuperMessActivity) getActivity()).getFrameLayout().getId(), new ForgotPassword(), true, true);
        Functions.launch((AppCompatActivity) getActivity(), ForgotPassword.class);
    }

    @OnClick(R.id.id_login_screen_reset_password_tv)
    void resetPasswordClicked() {
        Functions.launch(this, ResetPasswordScreen.class);
    }

    @OnCheckedChanged(R.id.id_login_screen_tc_cb)
    void TCCBClicked(android.widget.CompoundButton checkBox, boolean checked) {
        if (checked) {
            Toast.makeText(getActivity(), "Checked", Toast.LENGTH_SHORT).show();
        } else if (!checked) {
            Toast.makeText(getActivity(), "Unchecked", Toast.LENGTH_SHORT).show();
        }
    }

    @OnTextChanged(R.id.id_login_screen_u_name_et)
    void onUserIDTextChanged() {
        usernameWrapper.setErrorEnabled(false);
    }

    @OnTextChanged(R.id.id_login_screen_pass_et)
    void onPasswordTextChanged() {
        passwordWrapper.setErrorEnabled(false);
    }

    @OnClick(R.id.id_login_screen_tc_tv)
    void TCTVClicked() {
        new TandCView(this).showDialog();
    }

    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.activity_login_screen);

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
        if (V.isEmpty(getVal(uNameET))) {
            valid = false;
            usernameWrapper.setError("Enter User ID");
        } else if (V.isEmpty(getVal(passET))) {
            valid = false;
            passwordWrapper.setError("Enter Password");
        } else if (!V.isValidPassword(getVal(passET))) {
            valid = false;
            passwordWrapper.setError("Enter Valid Password");
        } else if (getVal(uNameET).contains("@") && !V.isValidEmail(getVal(uNameET))) {
            valid = false;
            usernameWrapper.setError("Enter valid User ID");
        } else if (valid && !V.isValidMobile(getVal(uNameET))) {
            valid = false;
            usernameWrapper.setError("Enter valid User ID");
        } else
            valid = true;

        return valid;
    }
}
