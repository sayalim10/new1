package com.devn.delivery.controller.menu;

import android.content.Context;
import android.view.View;

import com.devn.delivery.R;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

/**
 * Created by Nitin.Kalokhe on 04-08-2017.
 */

public class SubPrimaryDrawerItem extends SecondaryDrawerItem {

    @Override
    public void onPostBindView(IDrawerItem drawerItem, View view) {

        Context ctx = view.getContext();

        view.setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimaryFaint));

        super.onPostBindView(drawerItem, view);

    }


}
