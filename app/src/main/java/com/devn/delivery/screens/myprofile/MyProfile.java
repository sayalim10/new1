package com.devn.delivery.screens.myprofile;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.devn.delivery.R;
import com.devn.delivery.controller.SuperMessActivity;
import com.devn.delivery.devn_exceptions.DevNExcp;
import com.devn.delivery.utils.MyTextInputLayout;
import com.devn.delivery.devn_exceptions.DevNExcpTh;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MyProfile extends SuperMessActivity {

    @BindView(R.id.id_ur_profile_title_tv)
    TextView titleTV;

    @BindView(R.id.id_ur_profile_cust_id_tv)
    TextView custIdTV;

    @BindView(R.id.id_ur_profile_your_f_name_wrapper)
    MyTextInputLayout fNameWrapper;

    @OnTextChanged(R.id.id_ur_profile_your_f_name_et)
    void onFNameTextChanged() {
        fNameWrapper.setErrorEnabled(false);
    }

    @BindView(R.id.id_ur_profile_your_f_name_et)
    TextInputEditText fNameET;

    @BindView(R.id.id_ur_profile_your_l_name_wrapper)
    MyTextInputLayout lNameWrapper;

    @OnTextChanged(R.id.id_ur_profile_your_l_name_et)
    void onLNameTextChanged() {
        lNameWrapper.setErrorEnabled(false);
    }

    @BindView(R.id.id_ur_profile_your_l_name_et)
    TextInputEditText lNameET;

    @BindView(R.id.id_ur_profile_your_mob_no_wrapper)
    MyTextInputLayout mobNoWrapper;

    @BindView(R.id.id_ur_profile_your_mail_id_wrapper)
    MyTextInputLayout emailIdWrapper;

    @OnTextChanged(R.id.id_ur_profile_your_mail_id_et)
    void onEmailIdTextChanged() {
        emailIdWrapper.setErrorEnabled(false);
    }

    @BindView(R.id.id_ur_profile_your_mail_id_et)
    TextInputEditText emaildIdET;

    @BindView(R.id.id_ur_profile_your_password_wrapper)
    MyTextInputLayout passwordWrapper;

    @OnTextChanged(R.id.id_ur_profile_your_password_et)
    void onPasswordTextChanged() {
        passwordWrapper.setErrorEnabled(false);
    }

    @BindView(R.id.id_ur_profile_your_password_et)
    TextInputEditText passwordET;

    @BindView(R.id.id_ur_profile_your_home_addr_wrapper)
    MyTextInputLayout homeAddrsWrapper;

    @OnTextChanged(R.id.id_ur_profile_your_home_addr_et)
    void onHomeAddressTextChanged() {
        homeAddrsWrapper.setErrorEnabled(false);
    }

    @BindView(R.id.id_ur_profile_your_home_addr_et)
    TextInputEditText homeAddrsET;

    @BindView(R.id.id_ur_profile_your_work_addr_wrapper)
    MyTextInputLayout workAddrsWrapper;

    @OnTextChanged(R.id.id_ur_profile_your_work_addr_et)
    void onWordAddressTextChanged() {
        workAddrsWrapper.setErrorEnabled(false);
    }


    @BindView(R.id.id_ur_profile_your_work_addr_et)
    TextInputEditText workAddrsET;

    @BindView(R.id.id_ur_profile_your_password_wrapper1)
    MyTextInputLayout moreAddrsWrapper;

    @Override
    protected void onBackButtonPressed() {
        super.onBackButtonPressed();
    }

    @Override
    protected boolean scrollable() throws DevNExcp, DevNExcpTh {
        return true;
    }
    @Override
    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
        return "My Profile";
    }

    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.activity_my_profile_screen);
        return rootView;
    }

    @Override
    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {

    }

    @Override
    protected String TAG() {
        return "My Profile Screen";
    }
}
