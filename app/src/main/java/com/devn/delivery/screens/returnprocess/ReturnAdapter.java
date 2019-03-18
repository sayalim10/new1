package com.devn.delivery.screens.returnprocess;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devn.delivery.R;

public class ReturnAdapter extends RecyclerView.Adapter<ReturnAdapter.ReturnViewHolder> {

    private String[] data;
    public ReturnAdapter(String[] data)
    {
        this.data = data;
    }
    @NonNull
    @Override
    public ReturnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_return_vender_layout, parent, false);
        return new ReturnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReturnViewHolder holder, int position) {
        String title = data[position];
        holder.textTitle.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ReturnViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        public ReturnViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
        }
    }
}
