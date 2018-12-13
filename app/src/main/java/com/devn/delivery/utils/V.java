package com.devn.delivery.utils;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nitin Kalokhe on 10/11/2016
 * you can contact me at : nitin3kalokhe@gmail.com
 */
public class V {
    public static String getStr(String str) {
        if (str == null)
            return "";
        else
            return str;
    }

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    public static boolean isValidMobile(String str) {
        if (str == null || str.length() != 10)
            return false;
        else if (-1 == "789".indexOf(str.charAt(0)))
            return false;
        else if (str.contains(" "))
            return false;
        else
            return true;
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    //    Minimum eight characters, at least one letter and one number:
//            "^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"
//    Minimum eight characters, at least one letter, one number and one special character:
//            "^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$"
//    Minimum eight characters, at least one uppercase letter, one lowercase letter and one number:
//            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"
//    Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:
//            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}"
//    Minimum eight and maximum 10 characters, at least one uppercase letter, one lowercase letter, one number and one special character:
//            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,10}"
    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("");
        return pattern.matcher(password).matches();
    }

}
