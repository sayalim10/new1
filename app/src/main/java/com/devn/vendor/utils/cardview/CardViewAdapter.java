package com.devn.vendor.utils.cardview;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.devn.vendor.R;

import java.util.List;

/**
 * Created by Nitin Kalokhe on 11/12/2016
 * for AMI Pvt Ltd.
 * you can contact me at : nitin3kalokhe@gmail.com
 * * Copyright (c) 2016 AMI Pvt Ltd. All rights reserved.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<MessMenu> MessMenu;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.card_view_title);
            count = (TextView) view.findViewById(R.id.card_view_count);
            thumbnail = (ImageView) view.findViewById(R.id.card_view_thumbnail);
            overflow = (ImageView) view.findViewById(R.id.card_view_overflow);
        }
    }


    public CardViewAdapter(Context mContext, List<MessMenu> messMenuList) {
        this.mContext = mContext;
        this.MessMenu = messMenuList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        MessMenu messMenuList = MessMenu.get(position);
        holder.title.setText(messMenuList.getName());
        holder.count.setText(messMenuList.getNumOfSongs() + " Likes");

        // loading messMenuList cover using Glide library
        Glide.with(mContext).load(messMenuList.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.card_view_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_order:
                    Toast.makeText(mContext, "Ordered", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_add_to_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_like:
                    Toast.makeText(mContext, "Liked", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.action_donate:
                    Toast.makeText(mContext, "Donated", Toast.LENGTH_SHORT).show();
                    return true;

                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return MessMenu.size();
    }
}
