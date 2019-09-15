package com.devn.delivery.screens.delivery.dinner;

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
import com.devn.delivery.screens.collection.distribution_dinner.DistributionCenterAdapter;

public class DCCollectAdapter extends RecyclerView.Adapter<DCCollectAdapter.DcCollectViewHolder> {

    private String[] data;
    private Context mContext;
    public DCCollectAdapter(String[] data, Context mContext)
    {
       this.data = data;
       this.mContext = mContext;
    }

    @NonNull
    @Override
    public DcCollectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_dc_collect_dinner, parent, false);
        return new DcCollectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DcCollectViewHolder holder, int position) {
        String title = data[position];
        holder.texttitle.setText(title);
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

    public class DcCollectViewHolder extends RecyclerView.ViewHolder{
        TextView texttitle;
        Button  button;
        public DcCollectViewHolder(View itemView) {
            super(itemView);
            texttitle = itemView.findViewById(R.id.textTitle);
            button = itemView.findViewById(R.id.cancle);
        }
    }
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.card_view_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new DCCollectAdapter.MyMenuItemClickListener());
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
                case R.id.action_reject:
                    Toast.makeText(mContext, "Are you sure want to reject the order", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_divert:
                    Toast.makeText(mContext, "Are you sure want to divert the order", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_cancle:
                    Toast.makeText(mContext, "Are you sure want to cancel the order ", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.action_return:
                    Toast.makeText(mContext, "Are you sure want to return the order", Toast.LENGTH_SHORT).show();
                    return true;

                default:
            }
            return false;
        }
    }
}
