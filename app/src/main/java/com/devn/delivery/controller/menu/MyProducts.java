package com.devn.delivery.controller.menu;

/**
 * Created by Nitin.Kalokhe on 21-06-2017.
 */

public class MyProducts {
    private int iconResourceId;
    private String title;

    public MyProducts(int iconResourceId, String title) {
        this.iconResourceId = iconResourceId;
        this.title = title;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
