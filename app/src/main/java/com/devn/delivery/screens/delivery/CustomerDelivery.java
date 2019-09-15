package com.devn.delivery.screens.delivery;

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

public class CustomerDelivery extends Fragment {
    private Context mContext;


    public void setOrderCotect(Context context) {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_customer_delivery, container, false);

        RecyclerView customerdelivery = view.findViewById(R.id.CustomerDelivery);

        String[] order = {"DC#30", "DC#10", "DC#50", "DC#70"};
        customerdelivery.setAdapter(new DeliveryAdapter(order, mContext));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        customerdelivery.setLayoutManager(layoutManager);

        return view;
    }
//    private Context mContext;
//    private Button bt1,bt2;
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_customer_delivery);
////        RecyclerView customer = findViewById(R.id.CustomerDelivery);
////        customer.setLayoutManager(new LinearLayoutManager(this));
////        String[] order = {"Name"};
////        customer.setAdapter(new DeliveryAdapter(order));
////    }
//
//    @Override
//    protected View onDevNCreate(Bundle savedInstanceState) {
//        final View rootView = getView(R.layout.activity_customer_delivery);
//        final RecyclerView cutomer = rootView.findViewById(R.id.CustomerDelivery);
//        cutomer.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"Name", "Name", "Name", "Name"};
//        cutomer.setAdapter(new DeliveryAdapter(order, this));
//        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
//        rootView.setLayoutParams(params);
//        bt2=findViewById(R.id.n);
//        bt2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dist();
//            }
//        });
//
//        return rootView;
//    }
//    public void dist(){
//        Intent intent = new Intent(this,  ReturnDC.class);
//        startActivity(intent);
//
//    }
//    @Override
//    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
//        return "Customer Delivery";
//    }
//
//    @Override
//    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {
//
//    }
//
//    @Override
//    protected String TAG() {
//        return getClass().getName();
//    }
}
