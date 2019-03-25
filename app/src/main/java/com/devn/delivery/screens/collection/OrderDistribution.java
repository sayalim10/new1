package com.devn.delivery.screens.collection;

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

public class OrderDistribution extends Fragment {
    private Context mContext;


    public void setOrderCotect(Context context) {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_order_distribution, container, false);

        RecyclerView orderdistribution = view.findViewById(R.id.OrderDistribution);

        String[] order = {"DC#17", "DC#18", "DC#19", "DC#20"};
        orderdistribution.setAdapter(new DistributionAdapter(order, mContext));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        orderdistribution.setLayoutManager(layoutManager);

        return view;
    }
//    private Context mContext;
//    private Button bt1,bt2;

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order_distribution);
//        RecyclerView distribution = findViewById(R.id.OrderDistribution);
//        distribution.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#12345"};
//        distribution.setAdapter(new DistributionAdapter(order));
//
//    }
//
//    @Override
//    protected View onDevNCreate(Bundle savedInstanceState) {
//        final View rootView = getView(R.layout.activity_order_distribution);
//        final RecyclerView distribution = rootView.findViewById(R.id.OrderDistribution);
//        distribution.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#123", "DC#134", "DC#1323", "DC#12343"};
//        distribution.setAdapter(new DistributionAdapter(order, this));
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
//        Intent intent = new Intent(this,  DistributionCollect.class);
//        startActivity(intent);
//
//    }
//    @Override
//    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
//        return "Distribution Center";
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
