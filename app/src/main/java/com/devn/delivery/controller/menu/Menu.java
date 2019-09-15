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

    /**
     * Exit App
     */
    MENU_EXIT_APP(APPLICATION_NAME, "Exit " + APPLICATION_NAME, R.mipmap.menu_exit),
    /**
     * TITLE_1 Details
     */




    /**
     * Utilities
     */

    MENU_MY_PROFILE(MENU_DRAWER_TITLE_2, "My Profile ", R.mipmap.menu_profile),
    MENU_ORDER_COLLECTION(MENU_DRAWER_TITLE_2, "Order Collection", R.mipmap.menu_my_orders),
    MENU_DISTRIBUTION(MENU_DRAWER_TITLE_2, "Distribution", R.mipmap.menu_about_us),
    MENU_DC_COLLETION(MENU_DRAWER_TITLE_4, "DC Collection", R.mipmap.menu_my_wallet),
    MENU_CUSTOMER_DELIVERY(MENU_DRAWER_TITLE_4, "Customer Delivery", R.mipmap.menu_my_profile),
    MENU_RETURN_PROCESSING(MENU_DRAWER_TITLE_4, "Return Processing", R.mipmap.menu_my_orders1),
    MENU_FEEDBACK(MENU_DRAWER_TITLE_4, "Feedback", R.mipmap.menu_feedback),
    MENU_OTHER(MENU_DRAWER_TITLE_4, "Other", R.mipmap.menu_my_orders2);


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
