package com.devn.delivery.screens.collection.distribution_dinner;

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

public class DistributionCenter extends Fragment {
    private Context mContext;


    public void setOrderCotect(Context context) {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_distribution_center_dinner, container, false);

        RecyclerView distributioncenter = view.findViewById(R.id.dcdinner);

        String[] order = {"DC#160", "DC#128", "DC#10", "DC#16"};
        distributioncenter.setAdapter(new DistributionCenterAdapter(order, mContext));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        distributioncenter.setLayoutManager(layoutManager);

        return view;
    }

//    private Context mContext;
//
//    @Override
//    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
//        return "Distribution Center";
//    }
//
//    @Override
//    protected View onDevNCreate(Bundle savedInstanceState) {
//        final View rootView = getView(R.layout.activity_distribution_center_dinner);
//        this.setTitle("My Title");
//        final RecyclerView distributioncenterdinner = rootView.findViewById(R.id.dcdinner);
//        distributioncenterdinner.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#123", "DC#134", "DC#1323"};
//        distributioncenterdinner.setAdapter(new DistributionCenterAdapter(order));
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
//    @Override
//    protected String TAG() {
//        return getClass().getName();
//    }
}
