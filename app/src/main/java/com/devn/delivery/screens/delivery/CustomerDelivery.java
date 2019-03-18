package com.devn.delivery.screens.delivery;

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

public class CustomerDelivery extends SuperMessActivity {
    private Context mContext;
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_customer_delivery);
//        RecyclerView customer = findViewById(R.id.CustomerDelivery);
//        customer.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"Name"};
//        customer.setAdapter(new DeliveryAdapter(order));
//    }

    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.activity_customer_delivery);
        final RecyclerView cutomer = rootView.findViewById(R.id.CustomerDelivery);
        cutomer.setLayoutManager(new LinearLayoutManager(this));
        String[] order = {"Name", "Name", "Name", "Name"};
        cutomer.setAdapter(new DeliveryAdapter(order, this));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        rootView.setLayoutParams(params);
        return rootView;
    }
    @Override
    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
        return "Customer Delivery";
    }

    @Override
    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {

    }

    @Override
    protected String TAG() {
        return getClass().getName();
    }
}
