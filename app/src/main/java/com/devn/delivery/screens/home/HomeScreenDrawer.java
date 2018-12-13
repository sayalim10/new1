package com.devn.delivery.screens.home;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.devn.delivery.R;
import com.devn.delivery.constants.Constants;
import com.devn.delivery.controller.home.IRightsListener;
import com.devn.delivery.controller.menu.Menu;
import com.devn.delivery.controller.menu.MenuListener;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;
import java.util.List;

import static com.devn.delivery.controller.menu.Menu.MENU_ABOUT_US;
import static com.devn.delivery.controller.menu.Menu.MENU_MY_PROFILE_TITLE;
import static com.devn.delivery.controller.menu.Menu.MENU_MY_ORDERS;
import static com.devn.delivery.controller.menu.Menu.MENU_FEEDBACK;
import static com.devn.delivery.controller.menu.Menu.MENU_MY_WALLET;
import static com.devn.delivery.controller.menu.Menu.MENU_NOTIFICATIONS;
import static com.devn.delivery.controller.menu.Menu.MENU_EXIT_APP;
import static com.devn.delivery.controller.menu.Menu.MENU_HOME_PAGE;
import static com.devn.delivery.controller.menu.Menu.MENU_PAYMENT;
import static com.devn.delivery.controller.menu.ProfileSetter.getProfilePic;

/**
 * Created by Nitin.Kalokhe on 21-06-2017.
 */

public class HomeScreenDrawer implements IRightsListener, Constants {

    private Context mContext;
    private Toolbar mToolbar;
    private FrameLayout mContainer;
    private IProfile mProfile;
    private Drawer mDrawer;
    public static final long PROFILE_ID = 43423;
    private AccountHeader headerResult = null;
    private MenuListener menuListener = null;

    public HomeScreenDrawer(Context context, Toolbar mToolbar, FrameLayout container, final MenuListener menuListener) {
        this.mContext = context;
        this.mToolbar = mToolbar;
        this.mContainer = container;
        this.menuListener = menuListener;
    }

    public HomeScreenDrawer build(Bundle savedInstanceState) {
        String userName = USER_NAME;
        String userEmailId = USER_E_MAIL;

        Bitmap profilePic = getProfilePic(mContext);
        if (profilePic != null)
            mProfile = new ProfileDrawerItem().withName("" + userName).withEmail("" + userEmailId).withIcon(profilePic).withIdentifier(PROFILE_ID);
        else
            mProfile = new ProfileDrawerItem().withName("" + userName).withEmail("" + userEmailId).withIcon(R.mipmap.menu_profile).withIdentifier(PROFILE_ID);
        buildHeader(false, savedInstanceState, menuListener);
        mDrawer = new DrawerBuilder().withActivity((Activity) mContext).withToolbar(mToolbar).withAccountHeader(headerResult).addDrawerItems(
                getDrawerItems()
        ).withOnDrawerItemClickListener(menuListener).withOnDrawerNavigationListener(menuListener).addStickyDrawerItems(new SecondaryDrawerItem().withName(MENU_EXIT_APP.getMenu()).withIcon((int) MENU_EXIT_APP.getId()).withIconTintingEnabled(true).withIdentifier(MENU_EXIT_APP.getId())
        ).withSavedInstance(savedInstanceState).build();
        return this;
    }

    public Drawer getDrawer() {
        return mDrawer;
    }

    public AccountHeader getAccountHeader() {
        return headerResult;
    }

    private void buildHeader(boolean compact, Bundle savedInstanceState, MenuListener profileListener) {
        // Create the AccountHeader
        headerResult = new AccountHeaderBuilder()
                .withActivity((Activity) mContext)
                .withHeaderBackground(R.color.md_white_1000)
                .withCompactStyle(false)
                .addProfiles(mProfile)
                .withOnAccountHeaderListener(profileListener)
                .withSavedInstance(savedInstanceState)
                .withSelectionListEnabledForSingleProfile(false)
                .build();

    }

    public void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = mDrawer.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
    }

    public boolean onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (mDrawer != null && mDrawer.isDrawerOpen()) {
            mDrawer.closeDrawer();
            return true;
        } else {
            return false;
        }
    }

    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = ((Activity) mContext).getMenuInflater();
//        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.menu_1:
//                //update the profile2 and set a new image.
//                profile2.withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_android).backgroundColorRes(R.color.accent).sizeDp(48).paddingDp(4));
//                headerResult.updateProfileByIdentifier(profile2);
//                return true;
//            case R.id.menu_2:
//                //show the arrow icon
//                result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
//                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//                return true;
//            case R.id.menu_3:
//                //show the hamburger icon
//                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//                result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
//                return true;
//            case R.id.menu_4:
//                //we want to replace our current header with a compact header
//                //build the new compact header
//                buildHeader(true, null);
//                //set the view to the result
//                result.setHeader(headerResult.getView());
//                //set the drawer to the header (so it will manage the profile list correctly)
//                headerResult.setDrawer(result);
//                return true;
//            case R.id.menu_5:
//                //we want to replace our current header with a normal header
//                //build the new compact header
//                buildHeader(false, null);
//                //set the view to the result
//                result.setHeader(headerResult.getView());
//                //set the drawer to the header (so it will manage the profile list correctly)
//                headerResult.setDrawer(result);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
    }

    private void removeItm(Menu NAME) {
        mDrawer.removeItem(NAME.getId());
    }

    private IDrawerItem[] getDrawerItems() {
        ArrayList<IDrawerItem> menus = new ArrayList();
        menus.add(new PrimaryDrawerItem().withName(MENU_HOME_PAGE.getMenu()).withIcon((int) MENU_HOME_PAGE.getId()).withIconTintingEnabled(true).withIdentifier(MENU_HOME_PAGE.getId()));
        addMenuItems(menus);
        IDrawerItem[] myItems = new IDrawerItem[menus.size()];
        menus.toArray(myItems);
        return myItems;
    }


    private void addMenuItems(List<IDrawerItem> menus) {
//        menus.add(new PrimaryDrawerItem().withName(MENU_MY_PROFILE_TITLE.getMenu()).withIcon((int) MENU_MY_PROFILE_TITLE.getId()).withIconTintingEnabled(true).withIdentifier(MENU_MY_PROFILE_TITLE.getId()).withIconTintingEnabled(true).withBadge(">").withBadgeStyle(new BadgeStyle(ContextCompat.getColor(mContext, R.color.md_white_1000), ContextCompat.getColor(mContext, R.color.colorPrimary)).withTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary))));
        menus.add(new PrimaryDrawerItem().withName(MENU_MY_PROFILE_TITLE.getMenu()).withIcon((int) MENU_MY_PROFILE_TITLE.getId()).withIconTintingEnabled(true).withIdentifier(MENU_MY_PROFILE_TITLE.getId()).withIconTintingEnabled(true).withBadge(">").withTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary)));
        menus.add(new PrimaryDrawerItem().withName(MENU_MY_ORDERS.getMenu()).withIcon((int) MENU_MY_ORDERS.getId()).withIconTintingEnabled(true).withBadge(">").withIdentifier(MENU_MY_ORDERS.getId()));
        menus.add(new PrimaryDrawerItem().withName(MENU_PAYMENT.getMenu()).withIcon((int) MENU_PAYMENT.getId()).withIconTintingEnabled(true).withBadge(">").withIdentifier(MENU_PAYMENT.getId()));
        menus.add(new PrimaryDrawerItem().withName(MENU_MY_WALLET.getMenu()).withIcon((int) MENU_MY_WALLET.getId()).withIconTintingEnabled(true).withBadge(">").withIdentifier(MENU_MY_WALLET.getId()));
        menus.add(new PrimaryDrawerItem().withName(MENU_NOTIFICATIONS.getMenu()).withIcon((int) MENU_NOTIFICATIONS.getId()).withIconTintingEnabled(true).withBadge(">").withIdentifier(MENU_NOTIFICATIONS.getId()));
        menus.add(new PrimaryDrawerItem().withName(MENU_FEEDBACK.getMenu()).withIcon((int) MENU_FEEDBACK.getId()).withIconTintingEnabled(true).withBadge(">").withIdentifier(MENU_FEEDBACK.getId()));
        menus.add(new PrimaryDrawerItem().withName(MENU_ABOUT_US.getMenu()).withIcon((int) MENU_ABOUT_US.getId()).withIconTintingEnabled(true).withBadge(">").withIdentifier(MENU_ABOUT_US.getId()));
    }


}
