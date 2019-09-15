package com.devn.delivery.screens.returnprocess.dinner;

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

public class ReturnDCDinner extends Fragment {

    private Context mContext;


    public void setOrderCotect(Context context) {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_return_dc_dinner, container, false);

        RecyclerView returndcdiiner = view.findViewById(R.id.returndcdinner);

        String[] order = {"DC#19", "DC#78", "DC#45", "DC#16"};
        returndcdiiner.setAdapter(new ReturnDCAdapter(order, mContext));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        returndcdiiner.setLayoutManager(layoutManager);

        return view;
    }
//    private Context mContext;
//
//    @Override
//    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
//        return "Return to DC";
//    }
//    @Override
//    protected View onDevNCreate(Bundle savedInstanceState) {
//        final View rootView = getView(R.layout.activity_return_dc_dinner);
//        final RecyclerView returndcdinner = rootView.findViewById(R.id.returndcdinner);
//        returndcdinner.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#369", "DC#58", "DC#9985", "DC#56491"};
//        returndcdinner.setAdapter(new ReturnDCAdapter(order));
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
