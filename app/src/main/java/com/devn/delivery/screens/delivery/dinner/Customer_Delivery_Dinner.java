package com.devn.delivery.screens.delivery.dinner;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devn.delivery.R;

public class Customer_Delivery_Dinner extends Fragment {
    private Context mContext;


    public void setOrderCotect(Context context) {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_customer_delivery_dinner, container, false);

        RecyclerView customerdeliverydinner = view.findViewById(R.id.customerdeliverydinner);

        String[] order = {"DC#55", "DC#66", "DC#44", "DC#33"};
        customerdeliverydinner.setAdapter(new CustomerDeliveryAdapter(order, mContext));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        customerdeliverydinner.setLayoutManager(layoutManager);

        return view;
    }

//    private Context mContext;
//
//    @Override
//    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
//        return "Customer Delivery";
//    }
//    @Override
//    protected View onDevNCreate(Bundle savedInstanceState) {
//        final View rootView = getView(R.layout.activity_customer_delivery_dinner);
//        this.setTitle("My Title");
//        final RecyclerView customerdeliverydinner = rootView.findViewById(R.id.customerdeliverydinner);
//        customerdeliverydinner.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#1111", "DC#2648", "DC#6999"};
//        customerdeliverydinner.setAdapter(new CustomerDeliveryAdapter(order));
//        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
//        rootView.setLayoutParams(params);
//        return rootView;
//    }
//
//    @Override
//    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {
//
//    }
//
//    @Override
//    public void setTitle(int titleId) {
//        super.setTitle("home");
//    }
//
//
//    @Override
//    protected String TAG() {
//        return getClass().getName();
//    }
}
