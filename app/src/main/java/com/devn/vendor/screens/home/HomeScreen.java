package com.devn.vendor.screens.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.devn.vendor.R;
import com.devn.vendor.controller.SuperMessActivity;
import com.devn.vendor.devn_exceptions.DevNExcp;
import com.devn.vendor.devn_exceptions.DevNExcpTh;
import com.devn.vendor.utils.Alert;
import com.devn.vendor.utils.cardview.CardViewer;
import com.devn.vendor.utils.sliderlayout.ImageSliderLayout;


/**
 * Created by Nitin Kalokhe, 9762279667, nitin3kalokhe@gmail.com on 6/12/2016.
 */
public class HomeScreen extends SuperMessActivity {

    private ImageSliderLayout mSliderLayout;


    @Override
    protected String TAG() {
        return "Home Screen";
    }

    @Override
    protected boolean scrollable() {
        return false;
    }

    @Override
    protected boolean addInFrame() throws DevNExcp, DevNExcpTh {
        return true;
    }


    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.home_screen);
        new CardViewer(this, rootView).view();
        mSliderLayout = new ImageSliderLayout(this, rootView, new ImageSliderLayout.IOnImageSliderClick() {
            @Override
            public void onSliderClick(String tag, int id) {
//                mSliderLayout.slide();
//                Functions.launch(HomeScreen.this, getFrameLayout().getId(), new PreLoginScreen(), true, true);
                onClick();
                Toast.makeText(HomeScreen.this, "Tag: " + tag + " id: " + id, Toast.LENGTH_SHORT).show();
            }
        });
        mSliderLayout.slide();

        return rootView;
    }

    private void onClick() {
//        Functions.launch(HomeScreen.this, getFrameLayout().getId(), new PreLoginScreen(), true, true);
//        functions.launch(this,getframelayout().getid(), new picklocationscreen(),true,true);
    }

    @Override
    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {
    }


    @Override
    protected void onStop() {
        mSliderLayout.onStop();
        super.onStop();
    }


    private DialogInterface.OnClickListener yesListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            HomeScreen.this.finish();
        }
    };


    @Override
    protected String actionbarTitle() {
        return this.TAG();
    }

    @Override
    protected void onBackButtonPressed() {
        Alert.INSTANCE(HomeScreen.this).show(Alert.TYPE.OK_CANCEL, "Do you want to exit from application?", new String[]{"No", "Yes"}, yesListener);
    }
}
