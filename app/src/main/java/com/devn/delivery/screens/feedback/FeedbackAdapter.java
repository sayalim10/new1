package com.devn.delivery.screens.feedback;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FeedbackAdapter extends FragmentPagerAdapter {
    final String[] tabNames = {"Company", "Complaints","Apriciation"};

    public FeedbackAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CompanyFragment();
            case 1:
                return new ComplaintsFragment();
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
