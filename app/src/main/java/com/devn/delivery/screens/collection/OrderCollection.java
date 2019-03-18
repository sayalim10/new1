package com.devn.delivery.screens.collection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.devn.delivery.R;
import com.devn.delivery.controller.SuperMessActivity;
import com.devn.delivery.devn_exceptions.DevNExcp;
import com.devn.delivery.devn_exceptions.DevNExcpTh;

public class OrderCollection extends SuperMessActivity {
    private Context mContext;
    private Button bt1,bt2;

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order_collection);
//        RecyclerView recyclerView = findViewById(R.id.recycleview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#123"};
//        recyclerView.setAdapter(new OrderAdapter(order));
//
//    }

    @Override
    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
        return "Order Collection";
    }

    @Override
    protected View onDevNCreate(Bundle savedInstanceState) {
        final View rootView = getView(R.layout.activity_order_collection);
        this.setTitle("My Title");
        final RecyclerView recyclerView = rootView.findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] order = {"DC#123", "DC#134", "DC#1323", "DC#12343"};
        recyclerView.setAdapter(new OrderAdapter(order, this));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        rootView.setLayoutParams(params);
        bt2=findViewById(R.id.n);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dist();
            }
        });

        return rootView;
    }
    public void dist(){
        Intent intent = new Intent(this,  OrderDistribution.class);
        startActivity(intent);

    }

    @Override
    protected void onDevNReady(View contentView) throws DevNExcp, DevNExcpTh {

    }

 //   @Override
 //   protected String screenTitle() throws DevNExcp, DevNExcpTh {
 //       setTitle("OrderCollection");
 //      return "OrderCollection";
 //   }


    @Override
    public void setTitle(int titleId) {
        super.setTitle("home");
    }

    @Override
    protected String TAG() {
        return getClass().getName();
    }
}
