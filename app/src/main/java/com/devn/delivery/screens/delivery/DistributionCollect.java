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

public class DistributionCollect extends Fragment {
    private Context mContext;


    public void setOrderCotect(Context context) {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dc_collection, container, false);

        RecyclerView distributioncollect = view.findViewById(R.id.DistributionCollect);

        String[] order = {"DC#10", "DC#20", "DC#30", "DC#40"};
        distributioncollect.setAdapter(new DcAdapter(order, mContext));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        distributioncollect.setLayoutManager(layoutManager);

        return view;
    }
//    private Context mContext;
//    private Button bt1,bt2;
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_dc_collection);
////        RecyclerView collection = findViewById(R.id.DistributionCollect);
////        collection.setLayoutManager(new LinearLayoutManager(this));
////        String[] order = {"DC#123"};
////        collection.setAdapter(new DcAdapter(order));
////    }
//
//    @Override
//    protected View onDevNCreate(Bundle savedInstanceState) {
//        final View rootView = getView(R.layout.activity_dc_collection);
//        final RecyclerView collection = rootView.findViewById(R.id.DistributionCollect);
//        collection.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#123", "DC#134", "DC#1323", "DC#12343"};
//        collection.setAdapter(new DcAdapter(order, this));
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
//        Intent intent = new Intent(this,  CustomerDelivery.class);
//        startActivity(intent);
//
//    }
//    @Override
//    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
//        return "DC Collect";
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
