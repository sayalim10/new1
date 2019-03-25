package com.devn.delivery.screens.delivery.dinner;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.devn.delivery.screens.delivery.CustomerDelivery;
import com.devn.delivery.screens.feedback.PrivacyPolicyFragment;

public class Cust_DeliveryAdapter extends FragmentPagerAdapter {
    final String[] tabNames = {"Lunch", "Dinner"};
    private Context mContext;

    public void setContext(Context context){
        this.mContext = context;
    }

    public Cust_DeliveryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CustomerDelivery cd = new CustomerDelivery();
                cd.setOrderCotect(mContext);
                return cd;
            case 1:
                Customer_Delivery_Dinner cdd = new Customer_Delivery_Dinner();
                cdd.setOrderCotect(mContext);
                return cdd;
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
