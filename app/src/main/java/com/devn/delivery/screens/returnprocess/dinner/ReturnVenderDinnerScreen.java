package com.devn.delivery.screens.returnprocess.dinner;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.devn.delivery.R;
import com.devn.delivery.controller.SuperMessActivity;
import com.devn.delivery.devn_exceptions.DevNExcp;
import com.devn.delivery.devn_exceptions.DevNExcpTh;

public class ReturnVenderDinnerScreen extends SuperMessActivity {
    private Context mContext;

//    @OnClick(R.id.id_change_pass_btn)
//    void onUpdatePasswordBtnClicked() {
//        if (validate())
//            Toast.makeText(this, "Your passoword has been changed", Toast.LENGTH_SHORT).show();
//    }

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
        return "Return to Vender";
    }

    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.activity_about_tc_privacy_policy);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.id_about_vp);
        ReturnVenderDinnerAdapter adapter = new ReturnVenderDinnerAdapter(getSupportFragmentManager());
        adapter.setContext(this);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.id_about_tl);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }

    @Override
    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {

    }

    @Override
    public void setTitle(int titleId) {
        super.setTitle("home");
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



