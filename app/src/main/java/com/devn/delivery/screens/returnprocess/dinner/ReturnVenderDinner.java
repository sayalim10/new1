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

public class ReturnVenderDinner extends Fragment {
    private Context mContext;


    public void setOrderCotect(Context context) {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_return_vender_dinner, container, false);

        RecyclerView returnvenderdinner = view.findViewById(R.id.returnvenderdinner);

        String[] order = {"DC#46", "DC#78", "DC#21", "DC#67"};
        returnvenderdinner.setAdapter(new ReturnVenderAdapter(order, mContext));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        returnvenderdinner.setLayoutManager(layoutManager);

        return view;
    }

//    private Context mContext;
//
//    @Override
//    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
//        return "Return to Vender";
//    }
//    @Override
//    protected View onDevNCreate(Bundle savedInstanceState) {
//        final View rootView = getView(R.layout.activity_return_vender_dinner);
//        final RecyclerView returndcdinner = rootView.findViewById(R.id.returnvenderdinner);
//        returndcdinner.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#154456", "DC#71111", "DC#51111", "DC#00000"};
//        returndcdinner.setAdapter(new ReturnVenderLunchAdapter(order));
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
