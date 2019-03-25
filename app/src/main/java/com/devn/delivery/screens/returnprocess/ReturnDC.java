package com.devn.delivery.screens.returnprocess;

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

public class ReturnDC extends Fragment {
    private Context mContext;


    public void setOrderCotect(Context context) {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_return_dc, container, false);

        RecyclerView returndc = view.findViewById(R.id.returndc);

        String[] order = {"DC#24", "DC#71", "DC#81", "DC#91"};
        returndc.setAdapter(new ReturndcAdapter(order, mContext));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        returndc.setLayoutManager(layoutManager);

        return view;
    }
//    private Context mContext;
//    @Override
//    protected View onDevNCreate(Bundle savedInstanceState) {
//        final View rootView = getView(R.layout.activity_return_dc);
//        final RecyclerView returndc = rootView.findViewById(R.id.returndc);
//        returndc.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#123", "DC#134", "DC#1323", "DC#12343"};
//        returndc.setAdapter(new ReturndcAdapter(order, this));
//        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
//        rootView.setLayoutParams(params);
//        return rootView;
//    }
//    @Override
//    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
//        return "Return to DC";
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
