package com.devn.delivery.screens.returnprocess;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.devn.delivery.screens.feedback.PrivacyPolicyFragment;
import com.devn.delivery.screens.returnprocess.dinner.ReturnDCDinner;

public class ReturnDcLunchAdapter extends FragmentPagerAdapter {
    final String[] tabNames = {"Lunch", "Dinner"};
    private Context mContext;

    public void setContext(Context context){
        this.mContext = context;
    }

    public ReturnDcLunchAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ReturnDC rdc = new ReturnDC();
                rdc.setOrderCotect(mContext);
                return rdc;
            case 1:
                ReturnDCDinner rdcd = new ReturnDCDinner();
                rdcd.setOrderCotect(mContext);
                return rdcd;
 //           case 2:
 //               return new ApriciationCFragment();
            default:
                return new PrivacyPolicyFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames[position];
    }

    @Override
    public int getCount() {
        return tabNames.length;
    }
}
