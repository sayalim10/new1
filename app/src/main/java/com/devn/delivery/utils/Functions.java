package com.devn.delivery.utils;

import android.app.Activity;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.devn.delivery.devn_exceptions.DevNExcp;

/**
 * Created by SonaliRewadkar on 6/10/2016.
 */
public class Functions {

    public static void launch(AppCompatActivity activity, int fragment_container, Fragment frag, boolean saveInBackstack, boolean animate) {
        String TAG = ((Object) frag).getClass().getName();

        try {
            FragmentManager manager = activity.getSupportFragmentManager();
            boolean fragmentPopped = manager.popBackStackImmediate(TAG, 0);

            if (!fragmentPopped && manager.findFragmentByTag(TAG) == null) {
                // fragment not in back stack, create it.
                FragmentTransaction transaction = manager.beginTransaction();

                if (animate) {
                    Log.d(TAG, "Change Fragment: animate");
                    transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                }

                transaction.replace(fragment_container, frag, TAG);

                if (saveInBackstack) {
                    Log.d(TAG, "Change Fragment: addToBackTack " + TAG);
                    transaction.addToBackStack(TAG);
                } else {
                    Log.d(TAG, "Change Fragment: NO addToBackTack");
                }

                transaction.commit();
            } else {
                // custom effect if fragment is already instanciated
            }
        } catch (IllegalStateException exception) {
            new DevNExcp("Unable to commit fragment, could be activity as been killed in background. " + exception.toString());
//            Log.w(TAG, "Unable to commit fragment, could be activity as been killed in background. " + exception.toString());
        }
    }

    public static int launch(Context context, Class<?> newClass) {
        try {
            Intent intent = new Intent(context, newClass);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            new DevNExcp("Launch New Screen", "Activity Not Found");
            return 1;
        }

        return 0;
    }

    public static int launch(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            new DevNExcp("Launch New Screen", "Activity Not Found");
            return 1;
        }
        return 0;
    }


    /**
     * Converting dp to pixel
     */
    public static int dpToPx(Context context, int dp) {
        Resources r = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public static void hideKeyboard(Context context) {
        View view = ((Activity) context).getCurrentFocus();
        if (view != null) {
            InputMethodManager service = (InputMethodManager) context.getSystemService(Service.INPUT_METHOD_SERVICE);
            service.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void sendMail(Activity activity, String mailId, String subject, String body) {
        try {

            ShareCompat.IntentBuilder.from(activity).setType("message/rfc822").addEmailTo(mailId).setSubject(subject).setText(body).setChooserTitle("Select application to send EMail").startChooser();
        } catch (Exception e) {
            Toast.makeText(activity, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void makePhoneCall(Context context, String phoneNo) {
        try {

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + Uri.encode(phoneNo.trim())));
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(callIntent);
        } catch (Exception e) {
            Toast.makeText(context, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void openGoogleMap(Context context, String address) {
        try {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + address.trim());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            context.startActivity(mapIntent);
        } catch (Exception e) {
            Toast.makeText(context, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
