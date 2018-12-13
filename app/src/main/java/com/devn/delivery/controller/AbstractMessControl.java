package com.devn.delivery.controller;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.devn.delivery.R;
import com.devn.delivery.constants.Constants;
import com.devn.delivery.controller.menu.MenuListener;
import com.devn.delivery.controller.menu.ProfileSetter;
import com.devn.delivery.devn_exceptions.DevNExcp;
import com.devn.delivery.devn_exceptions.DevNExcpTh;
import com.devn.delivery.devn_exceptions.DevNLogWriter;
import com.devn.delivery.screens.home.HomeScreenDrawer;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.lang.annotation.Annotation;

import butterknife.ButterKnife;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_CALENDAR;
import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_CALENDAR;
import static android.Manifest.permission.WRITE_CONTACTS;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by Nitin Kalokhe, 9762279667, nitin3kalokhe@gmail.com on 6/12/2016.
 */
@RuntimePermissions
public abstract class AbstractMessControl extends NewAbstractionLayer implements Constants, RuntimePermissions {
    protected String TAG = getClass().getName();
    private FrameLayout frameLayout = null;
    private TextView actionTV = null;
    private FirebaseAnalytics mFirebaseAnalytics;
    private HomeScreenDrawer homeDrawer;
    private ProfileSetter mProfileSetter;

    @Override
    protected View onSuperCreate(@Nullable final Bundle savedInstanceState) {
        final View mainView = getView(R.layout.activity_super);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Toolbar toolbar = (Toolbar) findViewById(R.id.id_main_toolbar);
                    FrameLayout container = (FrameLayout) findViewById(R.id.id_frame_container);
                    mProfileSetter = new ProfileSetter(AbstractMessControl.this);
                    MenuListener menuListener = new MenuListener(AbstractMessControl.this, mProfileSetter);
                    homeDrawer = new HomeScreenDrawer(AbstractMessControl.this, toolbar, container, menuListener);
                    homeDrawer.build(savedInstanceState);
                    menuListener.setDrawer(homeDrawer.getDrawer());
                    mProfileSetter.setDrawer(homeDrawer.getDrawer());
                    mProfileSetter.setAccountHeader(homeDrawer.getAccountHeader());
//                    container.addView(onDevNCreate(savedInstanceState));
//                    RecyclerView serviceRV = (RecyclerView) findViewById(R.id.id_my_products_services_rv);
//                    RecyclerView policyRV = (RecyclerView) findViewById(R.id.id_my_products_policy_issuance_rv);
//
//                    final LinearLayout profileview = (LinearLayout) findViewById(R.id.id_user_info_header_ll);
//                    final LinearLayout polIssTV = (LinearLayout) findViewById(R.id.id_home_screen_policy_issuance_ll);
//                    final LinearLayout servicesTV = (LinearLayout) findViewById(R.id.id_home_screen_services_ll);
//                    new HomeScreenAnimations(AbstractMessControl.this).animateHomeScreen(profileview, polIssTV, servicesTV);
//                    homeScrenView = new HomeScreenView(AbstractMessControl.this, serviceRV, policyRV, menuListener).show();

//                    mFirebaseAnalytics = FirebaseAnalytics.getInstance(AbstractMessControl.this);


//            --------------------
                    RelativeLayout subContainer = null;
                    boolean scrollable = scrollable(), addInFrame = addInFrame();
                    final View childView = onDevNCreate(savedInstanceState);
                    if (childView == null) {
                        Log.e(TAG(), "child view is null", new DevNExcp("Your OnDevNCreate() returning Null view"));
                        return;
                    }

                    TextView titleTV = null;
                    if (scrollable && addInFrame) {
                        titleTV = (TextView) getChild(mainView, R.id.id_frame_container_title_tv);
                        frameLayout = (FrameLayout) getChild(mainView, R.id.id_frame_container);
                        setFrameLayout(frameLayout);
                        ScrollView scroll = (ScrollView) getChild(mainView, R.id.id_frame_container_scrollview);
                        scroll.setVisibility(View.VISIBLE);
                        frameLayout.addView(childView);
                    } else if (scrollable && !addInFrame) {
                        titleTV = (TextView) getChild(mainView, R.id.id_super_container_title_tv);
                        subContainer = (RelativeLayout) getChild(mainView, R.id.id_super_container);
                        ScrollView scroll = (ScrollView) getChild(mainView, R.id.id_super_scrollbar);
                        scroll.setVisibility(View.VISIBLE);
                        subContainer.addView(childView);
                    } else if (!scrollable && addInFrame) {
                        titleTV = (TextView) getChild(mainView, R.id.id_frame_container_non_scrollable_title_tv);
                        frameLayout = (FrameLayout) getChild(mainView, R.id.id_frame_container_non_scrollable);
                        setFrameLayout(frameLayout);
                        RelativeLayout frameParent = (RelativeLayout) getChild(mainView, R.id.id_frame_container_parent_rl);
                        frameParent.setVisibility(View.VISIBLE);
                        frameLayout.addView(childView);
                    } else if (!scrollable && !addInFrame) {
                        titleTV = (TextView) getChild(mainView, R.id.id_super_container_non_scrollable_title_tv);
                        subContainer = (RelativeLayout) getChild(mainView, R.id.id_super_container_non_scrollable);
                        RelativeLayout superContainerParent = (RelativeLayout) getChild(mainView, R.id.id_super_container_parent_rl);
                        superContainerParent.setVisibility(View.VISIBLE);
                        subContainer.addView(childView);
                    }

                    ButterKnife.bind(AbstractMessControl.this);
                    if (!PRODUCTION)
                        ButterKnife.setDebug(true);

                    final String scnTle = screenTitle();
                    if (titleTV != null && scnTle != null && scnTle.trim().length() > 0)
                        titleTV.setText(scnTle);
                    else if (titleTV != null)
                        titleTV.setVisibility(View.GONE);

                    actionTV = (TextView) toolbar.findViewById(R.id.id_toolbar_action_title_tv);
                    updateActionbarTitle(actionbarTitle());
                    onDevNReady(getWindow().getDecorView().findViewById(android.R.id.content));
                } catch (Exception devNexc) {
                    try {
                        new DevNExcp(TAG(), devNexc);
                    } catch (DevNExcp devNe) {
                        DevNLogWriter.print(TAG, devNe.getMessage());
                    } catch (DevNExcpTh devNth) {
                        DevNLogWriter.print(TAG, devNth.getMessage());
                    }
                } catch (Throwable devNth) {
                    try {
                        new DevNExcpTh(TAG(), devNth);
                    } catch (DevNExcp devNe) {
                        DevNLogWriter.print(TAG, devNe.getMessage());
                    } catch (DevNExcpTh devNt) {
                        DevNLogWriter.print(TAG, devNt.getMessage());
                    }
                }

            }
        }, 0);

        return mainView;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    private void updateActionbar() {
        try {
            if (actionbarTitle() != null)
                updateActionbarTitle(actionbarTitle());
        } catch (DevNExcp e) {
            new DevNExcp(e.getMessage());
        } catch (DevNExcpTh ex) {
            new DevNExcpTh(ex.getMessage());
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager() != null && getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            updateActionbar();
        } else {
            onBackButtonPressed();
        }
    }

    protected void callSuperBackButton() {
        super.onBackPressed();
    }

    public void updateActionbarTitle(String actionbarTitle) {
        try {
            if (actionTV != null && actionbarTitle != null && actionbarTitle.trim().length() > 0)
                actionTV.setText(actionbarTitle);
            else if (actionTV != null)
                actionTV.setVisibility(View.GONE);

        } catch (Exception ex) {
            new DevNExcp(ex.getMessage());
        }
    }


    public FrameLayout getFrameLayout() {
        return frameLayout;
    }

    private void setFrameLayout(FrameLayout frameLayout) {
        this.frameLayout = frameLayout;
    }


    /**
     * Used to get child (activity) view only. To deal with(access) view/components please use onDevNReady() method.
     *
     * @param savedInstanceState
     * @return
     */
    protected abstract View onDevNCreate(Bundle savedInstanceState) throws DevNExcp, DevNExcpTh;

    /**
     * You can initialize your components in this method.
     */
    protected abstract void onDevNReady(final View contentView) throws DevNExcp, DevNExcpTh;

    /**
     * Gets Screen Name
     *
     * @return
     */
    protected abstract String TAG() throws DevNExcp, DevNExcpTh;

    /**
     * Call this method to set screen scrollable: Default -> Scrollable
     *
     * @return whether the screen is scrollable or not
     */
    protected abstract boolean scrollable() throws DevNExcp, DevNExcpTh;

    /**
     * Use this method add child view in FrameLayout
     *
     * @return whether the screen is scrollable or not
     */
    protected abstract boolean addInFrame() throws DevNExcp, DevNExcpTh;


    /**
     * Use this method to set title in the screen provided in TAG() method
     *
     * @return true - will add title, Default:false
     */
    protected abstract String screenTitle() throws DevNExcp, DevNExcpTh;

    /**
     * Use this method to set Actionbar title
     *
     * @return
     * @throws DevNExcp
     * @throws DevNExcpTh
     */
    protected abstract String actionbarTitle() throws DevNExcp, DevNExcpTh;

    // ********************************* Functionality ***************************************
    protected abstract LayoutInflater getInflater();

    protected abstract View getView(int layoutId);

    protected abstract View getChild(View parent, int resId_child);

    protected abstract View getView(int layoutId, ViewGroup viewGroup) throws DevNExcp, DevNExcpTh;

    protected abstract String getStr(String str) throws DevNExcp, DevNExcpTh;

    protected abstract boolean isEmpty(String str) throws DevNExcp, DevNExcpTh;

    protected abstract void onBackButtonPressed();

//    /**
//     * Handling application permissions
//     */
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
////        AbstractMessControlPermissionsDispatcher.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }


    @NeedsPermission(READ_CALENDAR)
    public void testPermission() {

    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }

    @OnShowRationale({READ_CALENDAR, WRITE_CALENDAR, CAMERA, READ_CONTACTS, WRITE_CONTACTS, ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, RECORD_AUDIO, CALL_PHONE, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE})
    public void showOnRationalPermissions(PermissionRequest request) {
        Toast.makeText(AbstractMessControl.this, "on rational permissions", Toast.LENGTH_SHORT).show();
    }

    @OnPermissionDenied({READ_CALENDAR, WRITE_CALENDAR, CAMERA, READ_CONTACTS, WRITE_CONTACTS, ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, RECORD_AUDIO, CALL_PHONE, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE})
    public void showOnDenielPermissions() {
        Toast.makeText(AbstractMessControl.this, "on deniel permissions", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain({READ_CALENDAR, WRITE_CALENDAR, CAMERA, READ_CONTACTS, WRITE_CONTACTS, ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, RECORD_AUDIO, CALL_PHONE, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE})
    public void onNeverAskPermissions() {
        Toast.makeText(AbstractMessControl.this, "on never ask again permissions", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
