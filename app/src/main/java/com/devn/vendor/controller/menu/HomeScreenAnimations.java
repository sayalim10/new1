package com.devn.vendor.controller.menu;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.devn.vendor.R;

import static com.devn.vendor.controller.menu.HomeScreenAnimations.ANIM_VIEW.*;


/**
 * Created by Nitin.Kalokhe on 04-07-2017.
 */

public class HomeScreenAnimations implements Animation.AnimationListener {

    public enum ANIM_VIEW {
        PROFILE, POL_ISSUE, SERVICES;
    }

    private Context mContext;
    private Animation zoomInAnim, zoomOutAnim;
    private View profileView, polIssueView, servicesView;
    private ANIM_VIEW mAnim;

    public HomeScreenAnimations(Context mContext) {
        this.mContext = mContext;
        this.zoomInAnim = AnimationUtils.loadAnimation(
                mContext, R.anim.profile_zoom_in);
        this.zoomOutAnim = AnimationUtils.loadAnimation(
                mContext, R.anim.profile_zoom_out);
        this.zoomInAnim.setAnimationListener(this);
        this.zoomOutAnim.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == zoomInAnim)
            if (mAnim == PROFILE) {
                profileView.startAnimation(zoomOutAnim);
                animatePolicyInsuranceTitle();
            } else if (mAnim == POL_ISSUE) {
                polIssueView.startAnimation(zoomOutAnim);
                animateServicesTitle();
            } else if (mAnim == SERVICES) {
                servicesView.startAnimation(zoomOutAnim);
                mAnim = null;
            }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public HomeScreenAnimations animateHomeScreen(View profileView, View polIssView, View servicesView) {
        this.profileView = profileView;
        this.polIssueView = polIssView;
        this.servicesView = servicesView;
        animateProfileView();
        return this;
    }

    private void animateProfileView() {
        mAnim = PROFILE;
        profileView.startAnimation(zoomInAnim);
    }

    private void animatePolicyInsuranceTitle() {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAnim = POL_ISSUE;
                polIssueView.startAnimation(zoomInAnim);
            }
        }, 1000);
    }

    private void animateServicesTitle() {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAnim = SERVICES;
                servicesView.startAnimation(zoomInAnim);
            }
        }, 1000);
    }

}
