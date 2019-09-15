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

public class ReturnVender extends Fragment {
    private Context mContext;


    public void setOrderCotect(Context context) {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_return_vender, container, false);

        RecyclerView returnvender = view.findViewById(R.id.returnvender);

        String[] order = {"DC#17", "DC#18", "DC#19", "DC#20"};
        returnvender.setAdapter(new ReturnVenderLunchAdapter(order, mContext));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        returnvender.setLayoutManager(layoutManager);

        return view;
    }

//    @Override
//    protected View onDevNCreate(Bundle savedInstanceState) {
//        final View rootView = getView(R.layout.activity_return_vender);
//        final RecyclerView returnvender = rootView.findViewById(R.id.returnvender);
//        returnvender.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#123", "DC#134", "DC#1323", "DC#12343"};
//        returnvender.setAdapter(new ReturnVenderLunchAdapter(order));
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
//    protected String TAG() {
//        return getClass().getName();
//    }
}
