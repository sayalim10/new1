package com.devn.delivery.screens.collection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.devn.delivery.R;

public class DistributionAdapter extends RecyclerView.Adapter<DistributionAdapter.DistributionViewHolder> {

    private String[] data;
    private Context mContext;
    DistributionAdapter(String[] data, Context mContext)
    {
        this.data = data;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public DistributionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_distribution_layout, parent, false);
        return new DistributionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DistributionViewHolder holder, int position) {
        String title = data[position];
        holder.textTitle.setText(title);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class DistributionViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        Button button;
        DistributionViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            button = (Button) itemView.findViewById(R.id.cancle);
        }
    }
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.card_view_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new DistributionAdapter.MyMenuItemClickListener());
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
}
