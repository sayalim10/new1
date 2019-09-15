package com.devn.delivery.screens.returnprocess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.devn.delivery.R;
import com.devn.delivery.controller.SuperMessActivity;
import com.devn.delivery.devn_exceptions.DevNExcp;
import com.devn.delivery.devn_exceptions.DevNExcpTh;
import com.devn.delivery.screens.collection.OrderCollection;

public class ReturnDcLunchScreen extends SuperMessActivity {
    private Context mContext;
    private Button bt1,bt2;

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
        return "Return to DC";
    }

    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.activity_about_tc_privacy_policy);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.id_about_vp);
        ReturnDcLunchAdapter adapter = new ReturnDcLunchAdapter(getSupportFragmentManager());
        adapter.setContext(this);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.id_about_tl);
        tabLayout.setupWithViewPager(viewPager);
        bt2=findViewById(R.id.n);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dist();
            }
        });

        return rootView;
    }

    public void dist(){
        Intent intent = new Intent(this,  OrderCollection.class);
        startActivity(intent);

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



