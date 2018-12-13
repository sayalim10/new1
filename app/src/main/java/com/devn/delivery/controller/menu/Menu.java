package com.devn.delivery.controller.menu;


import com.devn.delivery.R;
import com.devn.delivery.constants.Constants;

/**
 * Created by Nitin.Kalokhe on 22-06-2017.
 */

public enum Menu implements Constants {
    /**
     * Go to Home Screen
     */
    MENU_HOME_PAGE(APPLICATION_NAME, HOME, R.mipmap.menu_home_screen),
    /**
     * Exit App
     */
    MENU_EXIT_APP(APPLICATION_NAME, "Exit " + APPLICATION_NAME, R.mipmap.menu_exit),
    /**
     * TITLE_1 Details
     */
    MENU_MY_PROFILE_TITLE(MENU_DRAWER_TITLE_1, MENU_DRAWER_TITLE_1, R.mipmap.menu_my_profile),

    /**
     * Home Product
     */
    MENU_MY_ORDERS(MENU_DRAWER_TITLE_2, MENU_DRAWER_TITLE_2, R.mipmap.menu_my_orders),


    /**
     * Utilities
     */
    MENU_MY_WALLET(MENU_DRAWER_TITLE_4, "My Wallet", R.mipmap.menu_my_wallet),
    MENU_NOTIFICATIONS(MENU_DRAWER_TITLE_4, "Notifications", R.mipmap.menu_notification),
    MENU_FEEDBACK(MENU_DRAWER_TITLE_4, "Feedback", R.mipmap.menu_feedback),
    MENU_ABOUT_US(MENU_DRAWER_TITLE_4, "About Us", R.mipmap.menu_about_us),
    MENU_PAYMENT(MENU_DRAWER_TITLE_2, "Payments", R.mipmap.menu_payment);


    Menu(String cat, String menu, long id) {
        this.cat = cat;
        this.menu = menu;
        this.id = id;
    }

    private String cat;
    private String menu;
    private int icon;
    private long id;

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public long getId() {
        return id;
    }

    public int getIdInt() {
        return (int) id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
