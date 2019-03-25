package com.devn.delivery.screens.feedback.customer_feedback;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.devn.delivery.R;
import com.devn.delivery.controller.SuperMessActivity;
import com.devn.delivery.devn_exceptions.DevNExcp;
import com.devn.delivery.devn_exceptions.DevNExcpTh;

public class CustomerFeedback extends SuperMessActivity {
    private Context mContext;

    @Override
    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
        return "Customer Feedback";
    }

    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.activity_customer_feedback);
        this.setTitle("My Title");
        final RecyclerView customerfeedback = rootView.findViewById(R.id.CustomerFeedback);
        customerfeedback.setLayoutManager(new LinearLayoutManager(this));
        String[] order = {"DC#123", "DC#134", "DC#9999"};
        customerfeedback.setAdapter(new CustomerFeedbackAdapter(order));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        rootView.setLayoutParams(params);
        return rootView;
    }

    @Override
    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {

    }

    @Override
    public void setTitle(int titleId) {
        super.setTitle("home");
    }

    @Override
    protected String TAG() {
        return getClass().getName();
    }
}
