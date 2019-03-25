package com.devn.delivery.screens.collection;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.devn.delivery.screens.collection.distribution_dinner.DistributionCenter;
import com.devn.delivery.screens.feedback.PrivacyPolicyFragment;

public class LunchDinnerAdapter extends FragmentPagerAdapter {
    final String[] tabNames = {"Lunch", "Dinner"};
    private Context mContext;

    public void setContext(Context context){
        this.mContext = context;
    }

    public LunchDinnerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                OrderDistribution oc = new OrderDistribution();
                oc.setOrderCotect(mContext);
                return oc;
            case 1:
                DistributionCenter dc = new DistributionCenter();
                dc.setOrderCotect(mContext);
                return dc;
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
