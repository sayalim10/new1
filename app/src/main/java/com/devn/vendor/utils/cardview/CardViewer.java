package com.devn.vendor.utils.cardview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.devn.vendor.R;
import com.devn.vendor.utils.Functions;

import java.util.ArrayList;

/**
 * Created by Nitin Kalokhe on 11/13/2016
 * for AMI Pvt Ltd.
 * you can contact me at : nitin3kalokhe@gmail.com
 * * Copyright (c) 2016 AMI Pvt Ltd. All rights reserved.
 */
public class CardViewer {

    private Context mContext;
    private View mView;
    private ArrayList<MessMenu> messMenu;
    private CardViewAdapter adapter;


    public CardViewer(Context context, View rootView) {
        this.mContext = context;
        this.mView = rootView;
    }


    public void view() {
        RecyclerView recyclerView = (RecyclerView) mView.findViewById(R.id.home_screen_recycler_view);
        messMenu = new ArrayList<>();
        adapter = new CardViewAdapter(mContext, messMenu);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, Functions.dpToPx(mContext, 10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.mipmap.mess_thali,
                R.mipmap.mess_thali,
                R.mipmap.mess_thali,
                R.mipmap.mess_thali,
                R.mipmap.mess_thali,
                R.mipmap.mess_thali,
                R.mipmap.mess_thali,
                R.mipmap.mess_thali,
                R.mipmap.mess_thali,
                R.mipmap.mess_thali,
                R.mipmap.mess_thali};

        MessMenu a = new MessMenu("Mix Veg", 13, covers[0]);
        messMenu.add(a);

        a = new MessMenu("Tur Dal Khichdi", 8, covers[1]);
        messMenu.add(a);

        a = new MessMenu("Corn Palak", 11, covers[2]);
        messMenu.add(a);

        a = new MessMenu("Rajastani Dal", 12, covers[3]);
        messMenu.add(a);

        a = new MessMenu("Chamcham", 14, covers[4]);
        messMenu.add(a);

        a = new MessMenu("Bhendi Fry", 1, covers[5]);
        messMenu.add(a);

        a = new MessMenu("Veg Handi", 11, covers[6]);
        messMenu.add(a);

        a = new MessMenu("Shahi Paneer", 14, covers[7]);
        messMenu.add(a);

        a = new MessMenu("Paneer Chatpata", 11, covers[8]);
        messMenu.add(a);

        a = new MessMenu("AMI Special", 17, covers[9]);
        messMenu.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }


}
