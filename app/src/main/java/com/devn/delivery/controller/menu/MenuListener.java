package com.devn.delivery.controller.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.devn.delivery.screens.collection.OrderCollection;
import com.devn.delivery.screens.collection.OrderDistribution;
import com.devn.delivery.screens.delivery.CustomerDelivery;
import com.devn.delivery.screens.delivery.DistributionCollect;
import com.devn.delivery.screens.feedback.FeedbackScreen;
import com.devn.delivery.screens.myprofile.MyProfile;
import com.devn.delivery.screens.returnprocess.ReturnDC;
import com.devn.delivery.screens.returnprocess.ReturnVender;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import static com.devn.delivery.controller.menu.Menu.MENU_CUSTOMER_DELIVERY;
import static com.devn.delivery.controller.menu.Menu.MENU_DC_COLLETION;
import static com.devn.delivery.controller.menu.Menu.MENU_DISTRIBUTION;
import static com.devn.delivery.controller.menu.Menu.MENU_EXIT_APP;
import static com.devn.delivery.controller.menu.Menu.MENU_FEEDBACK;
import static com.devn.delivery.controller.menu.Menu.MENU_MY_PROFILE;
import static com.devn.delivery.controller.menu.Menu.MENU_ORDER_COLLECTION;
import static com.devn.delivery.controller.menu.Menu.MENU_OTHER;
import static com.devn.delivery.controller.menu.Menu.MENU_RETURN_PROCESSING;

/**
 * Created by Nitin.Kalokhe on 23-06-2017.
 */
public class MenuListener implements Drawer.OnDrawerItemClickListener, Drawer.OnDrawerNavigationListener, AccountHeader.OnAccountHeaderListener, IProductListener, View.OnClickListener {
    private Context mContext;
    private Drawer mDrawer;
    private ProfileSetter mProfileSetter;

    public void setDrawer(Drawer mDrawer) {
        this.mDrawer = mDrawer;
    }

    public MenuListener(Context context, ProfileSetter profileSetter) {
        this.mContext = context;
        this.mProfileSetter = profileSetter;
    }


    /**
     * this method is only called if the Arrow icon is shown. The hamburger is automatically managed by the MaterialDrawer
     * if the back arrow is shown. close the activity
     * return true if we have consumed the event
     *
     * @param clickedView
     * @return
     */
    @Override
    public boolean onNavigationClickListener(View clickedView) {
        ((Activity) mContext).finish();
        return true;
    }

    @Override
    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
        mProfileSetter.set(profile);
//        if (profile instanceof IDrawerItem && ((IDrawerItem) profile).getIdentifier() == PROFILE_SETTING) {
//            IProfile newProfile = new ProfileDrawerItem().withNameShown(true).withName("Batman").withEmail("batman@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile5));
//            if (headerResult.getProfiles() != null) {
//                //we know that there are 2 setting elements. set the new profile above them ;)
//                headerResult.addProfile(newProfile, headerResult.getProfiles().size() - 2);
//            } else {
//                headerResult.addProfiles(newProfile);
//            }
        //false if you have not consumed the event and it should close the drawer
        return false;

    }


    @Override
    public void onProductClick(String category, String PRODUCT_NAME, int position) {
//        if (PRODUCT_NAME.equals(MOTOR_POLICY.NAME))
//            Toast.makeText(mContext, PRODUCT_NAME, Toast.LENGTH_SHORT).show();

//        Toast.makeText(mContext, "Category: " + category + "\nprod name: " + PRODUCT_NAME + "\nposition: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
        final int SELECTED_ID = (int) drawerItem.getIdentifier();
        if (SELECTED_ID == MENU_EXIT_APP.getIdInt())
            exitApplication(mContext);


        if (SELECTED_ID == MENU_MY_PROFILE.getIdInt())
            gotoProfile(mContext);
        else  if (SELECTED_ID == MENU_FEEDBACK.getIdInt())
            gotoFeedback(mContext);
        else if (SELECTED_ID == MENU_ORDER_COLLECTION.getIdInt())
            gotoOrderCollection(mContext);
        else if (SELECTED_ID == MENU_DC_COLLETION.getIdInt())
            gotoDistributionCollect(mContext);
        else if (SELECTED_ID == MENU_DISTRIBUTION.getIdInt())
            gotoOrderDistribution(mContext);
        else if (SELECTED_ID == MENU_CUSTOMER_DELIVERY.getIdInt())
            gotoCustomerDelivery(mContext);
        else if (SELECTED_ID == MENU_RETURN_PROCESSING.getIdInt())
            gotoReturn(mContext);
        else if (SELECTED_ID == MENU_OTHER.getIdInt())
            Toast.makeText(mContext, "Position: " + position + "\nID: " + drawerItem.getIdentifier(), Toast.LENGTH_SHORT).show();
        else if (SELECTED_ID == MENU_EXIT_APP.getIdInt())
            Toast.makeText(mContext, "Position: " + position + "\nID: " + drawerItem.getIdentifier(), Toast.LENGTH_SHORT).show();

//        Toast.makeText(mContext, "Position: " + position + "\nID: " + drawerItem.getIdentifier(), Toast.LENGTH_SHORT).show();
        return false;
    }

    public static void sankatMochanClicked(final Context context) {
    }

    @Override
    public void onClick(View v) {

    }

    public static void exitApplication(final Context context) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(
                context);
        builder.setTitle("Application Exit ?").setCancelable(true);
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ((Activity) context).finish();
                        ((Activity) context).moveTaskToBack(true);
                    }
                }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.create().dismiss();
                    }
                });
        builder.create().show();
    }


    public static void gotoOrderCollection(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(context, OrderCollection.class);
        ((Activity) context).startActivity(intent);

    }

    public static void gotoOrderDistribution(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(context, OrderDistribution.class);
        ((Activity) context).startActivity(intent);

    }

    public static void gotoDistributionCollect(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(context, DistributionCollect.class);
        ((Activity) context).startActivity(intent);

    }

    public static void gotoCustomerDelivery(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(context, CustomerDelivery.class);
        ((Activity) context).startActivity(intent);

    }

    public static void gotoReturn(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(context, ReturnDC.class);
        ((Activity) context).startActivity(intent);

    }

    public static void gotoFeedback(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(context, FeedbackScreen.class);
        ((Activity) context).startActivity(intent);

    }

    public static void gotoProfile(Context context) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(context, MyProfile.class);
        ((Activity) context).startActivity(intent);

    }
}
