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

public class DC_Collect extends Fragment {
    private Context mContext;


    public void setOrderCotect(Context context) {
        this.mContext = context;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dc_collect_dinner, container, false);

        RecyclerView dccollect = view.findViewById(R.id.dccollectdinner);

        String[] order = {"DC#10", "DC#20", "DC#30", "DC#40"};
        dccollect.setAdapter(new DCCollectAdapter(order, mContext));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        dccollect.setLayoutManager(layoutManager);

        return view;
    }

//    private Context mContext;
//
//    @Override
//    protected String actionbarTitle() throws DevNExcp, DevNExcpTh {
//        return "DC Collect";
//    }
//
//    @Override
//    protected View onDevNCreate(Bundle savedInstanceState) {
//        final View rootView = getView(R.layout.activity_dc_collect_dinner);
//        this.setTitle("My Title");
//        final RecyclerView dccollectdinner = rootView.findViewById(R.id.dccollectdinner);
//        dccollectdinner.setLayoutManager(new LinearLayoutManager(this));
//        String[] order = {"DC#888", "DC#456", "DC#9745"};
//        dccollectdinner.setAdapter(new DCCollectAdapter(order));
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
