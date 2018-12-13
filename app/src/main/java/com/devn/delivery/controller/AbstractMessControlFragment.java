package com.devn.delivery.controller;

import android.app.Service;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import com.devn.delivery.R;
import com.devn.delivery.constants.Constants;
import com.devn.delivery.controller.AbstractMessControl;
import com.devn.delivery.devn_exceptions.DevNExcp;
import com.devn.delivery.devn_exceptions.DevNExcpTh;
import com.devn.delivery.devn_exceptions.DevNLogWriter;

import butterknife.ButterKnife;

/**
 * Created by Nitin Kalokhe on 10/2/2016
 * you can contact me at : nitin3kalokhe@gmail.com
 */
public abstract class AbstractMessControlFragment extends Fragment implements Constants {
    private final String TAG = getClass().getName();
    private LayoutInflater inflater = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup fragmentContainer, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        View mainView = null;
        try {
            mainView = inflater.inflate(R.layout.fragment_super, fragmentContainer, false);
            new DevNLogWriter().registerCrash(getContext());
//            MenuController.getInstance().create(getActivity(), toolbar, savedInstanceState);

            RelativeLayout container = null;
            FrameLayout frameLayout = null;
            TextView titleTV = null;
            boolean scrollable = scrollable(), addInFrame = addInFrame();
            final View childView = onDevNCreate(savedInstanceState);
            if (childView == null) {
                Log.e(TAG(), "child view is null", new DevNExcpTh("Your OnDevNCreate() returning Null view"));
                return fragmentContainer;
            }

            if (scrollable && addInFrame) {
                titleTV = (TextView) getChild(mainView, R.id.id_frame_container_title_tv);
                frameLayout = (FrameLayout) getChild(mainView, R.id.id_frame_container);
                ScrollView scroll = (ScrollView) getChild(mainView, R.id.id_frame_container_scrollview);
                scroll.setVisibility(View.VISIBLE);
                frameLayout.addView(childView);
            } else if (scrollable && !addInFrame) {
                titleTV = (TextView) getChild(mainView, R.id.id_super_container_title_tv);
                container = (RelativeLayout) getChild(mainView, R.id.id_super_container);
                ScrollView scroll = (ScrollView) getChild(mainView, R.id.id_super_scrollbar);
                scroll.setVisibility(View.VISIBLE);
                container.addView(childView);
            } else if (!scrollable && addInFrame) {
                titleTV = (TextView) getChild(mainView, R.id.id_frame_container_non_scrollable_title_tv);
                frameLayout = (FrameLayout) getChild(mainView, R.id.id_frame_container_non_scrollable);
                RelativeLayout frameParent = (RelativeLayout) getChild(mainView, R.id.id_frame_container_parent_rl);
                frameParent.setVisibility(View.VISIBLE);
                frameLayout.addView(childView);
            } else if (!scrollable && !addInFrame) {
                titleTV = (TextView) getChild(mainView, R.id.id_super_container_non_scrollable_title_tv);
                container = (RelativeLayout) getChild(mainView, R.id.id_super_container_non_scrollable);
                RelativeLayout superContainerParent = (RelativeLayout) getChild(mainView, R.id.id_super_container_parent_rl);
                superContainerParent.setVisibility(View.VISIBLE);
                container.addView(childView);
            }

            ButterKnife.bind(this, mainView);
            if (!PRODUCTION)
                ButterKnife.setDebug(true);

            final String scnTle = screenTitle();
            if (scnTle != null && scnTle.length() > 0)
                titleTV.setText(TAG());
            else
                titleTV.setVisibility(View.GONE);

            updateActionbarTitle();

//            final String actionbarTitle = actionbarTitle();
//            final TextView actionTV = (TextView) toolbar.findViewById(R.id.id_toolbar_action_title_tv);
//            if (actionbarTitle != null && actionbarTitle.trim().length() > 0)
//                actionTV.setText(actionbarTitle);
//            else
//                actionTV.setVisibility(View.GONE);

            onDevNReady(getActivity().getWindow().getDecorView().findViewById(android.R.id.content));
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

        if (mainView != null)
            return mainView;
        else {
            new DevNExcp(TAG, "Child view is null");
            return super.onCreateView(inflater, fragmentContainer, savedInstanceState);
        }
    }

    @Override
    public void onResume() {
        updateActionbarTitle();
        super.onResume();
    }


    private void updateActionbarTitle() {
        try {
            if (actionbarTitle() != null && getActivity() != null && getActivity() instanceof com.devn.delivery.controller.AbstractMessControl) {
                ((AbstractMessControl) getActivity()).updateActionbarTitle(actionbarTitle());
            }
        } catch (DevNExcp ex) {
            new DevNExcp(ex.getMessage());
        } catch (DevNExcpTh e) {
            new DevNExcpTh(e.getMessage());
        }

    }

    // ********************************* Functionality ***************************************

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

    protected abstract View getView(int layoutId);

    protected abstract View getChild(View parent, int resId_child);

    protected abstract String getStr(String str) throws DevNExcp, DevNExcpTh;

    protected abstract boolean isEmpty(String str) throws DevNExcp, DevNExcpTh;

    protected LayoutInflater getInflater() {
        return this.inflater != null ? this.inflater : (LayoutInflater) getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
    }

    protected View getView(int layoutId, ViewGroup viewGroup) throws DevNExcp, DevNExcpTh {
        return getInflater().inflate(layoutId, viewGroup);
    }


}
