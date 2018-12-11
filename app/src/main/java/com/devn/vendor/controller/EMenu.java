package com.devn.vendor.controller;

import com.devn.vendor.R;

/**
 * Created by Nitin Kalokhe on 7/2/2017
 * * you can contact me at : nitin3kalokhe@gmail.com
 */

public enum EMenu {
    MENU_HOME("HOME",R.mipmap.mess_thali);

    EMenu(String NAME,int IMG){
        this.NAME = NAME;
        this.IMG =IMG;
        this.ID = (long)this.IMG;
    }
    public String NAME;
    public long ID;
    public int IMG;
}
