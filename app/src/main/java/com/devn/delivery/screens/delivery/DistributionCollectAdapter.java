package com.devn.delivery.screens.delivery;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.devn.delivery.screens.delivery.dinner.DC_Collect;
import com.devn.delivery.screens.feedback.PrivacyPolicyFragment;

public class DistributionCollectAdapter extends FragmentPagerAdapter {
    final String[] tabNames = {"Lunch", "Dinner"};
    private Context mContext;

    public void setContext(Context context){
        this.mContext = context;
    }

    public DistributionCollectAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DistributionCollect dc = new DistributionCollect();
                dc.setOrderCotect(mContext);
                return dc;
            case 1:
                DC_Collect dcc = new DC_Collect();
                dcc.setOrderCotect(mContext);
                return dcc;
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
