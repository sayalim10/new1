package com.devn.vendor.controller;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

/**
 * Created by Nitin Kalokhe on 7/2/2017
 * * you can contact me at : nitin3kalokhe@gmail.com
 */

public class ProfileMenuListener implements AccountHeader.OnAccountHeaderListener,Drawer.OnDrawerItemClickListener {

    private Context mContext;

    public ProfileMenuListener(Context context) {
        this.mContext = context;
    }

    @Override
    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
        Toast.makeText(mContext, "Profile: " + profile.getName(), Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
        Toast.makeText(mContext, "Identifier: " + drawerItem.getIdentifier(), Toast.LENGTH_SHORT).show();

        return false;
    }
}
