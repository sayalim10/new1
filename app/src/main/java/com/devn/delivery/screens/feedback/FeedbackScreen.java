package com.devn.delivery.screens.feedback;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.devn.delivery.R;
import com.devn.delivery.controller.SuperMessActivity;
import com.devn.delivery.devn_exceptions.DevNExcp;
import com.devn.delivery.devn_exceptions.DevNExcpTh;

import android.view.View;

public class FeedbackScreen extends SuperMessActivity {

//    @OnClick(R.id.id_change_pass_btn)
//    void onUpdatePasswordBtnClicked() {
//        if (validate())
//            Toast.makeText(this, "Your passoword has been changed", Toast.LENGTH_SHORT).show();
//    }
@Override
protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
    return "Feedback";
}

    @Override
    protected void onBackButtonPressed() {
        super.onBackButtonPressed();
    }

    @Override
    protected boolean scrollable() throws DevNExcp, DevNExcpTh {
        return true;
    }

    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.activity_about_tc_privacy_policy);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.id_about_vp);
        FeedbackAdapter adapter = new FeedbackAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.id_about_tl);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }

    @Override
    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {

    }

    @Override
    protected String TAG() {
        return "About Screen";
    }

//    @Override
//    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
//        return "Your Profile";
//    }


//    @Override
//    protected String screenTitle() throws DevNExcp, DevNExcpTh {
//        return "Your Profile";
//    }

//    private boolean validate() {
//        boolean valid = false;
//        if (V.isEmpty(getVal(null))) {
//            valid = false;
////            currentPasswordWrapper.setError("Enter current password");
//        } else
//            valid = true;
//
//
//        return valid;
//    }

}



