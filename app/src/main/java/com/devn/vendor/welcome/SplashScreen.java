package com.devn.vendor.welcome;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.devn.vendor.utils.Functions;


/**
 * Created by Nitin Kalokhe
 */
public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Functions.launch(SplashScreen.this, DisclaimerScreen.class);
                SplashScreen.this.finish();
            }
        }, 2000);


    }

}
