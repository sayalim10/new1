package com.devn.delivery.screens.returnprocess.dinner;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.devn.delivery.screens.feedback.PrivacyPolicyFragment;
import com.devn.delivery.screens.returnprocess.ReturnVender;

public class ReturnVenderDinnerAdapter extends FragmentPagerAdapter {
    final String[] tabNames = {"Lunch", "Dinner"};
    private Context mContext;

    public void setContext(Context context){
        this.mContext = context;
    }

    public ReturnVenderDinnerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ReturnVender rvl = new ReturnVender();
                rvl.setOrderCotect(mContext);
                return rvl;
            case 1:
                ReturnVenderDinner rvd = new ReturnVenderDinner();
                rvd.setOrderCotect(mContext);
                return rvd;
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
