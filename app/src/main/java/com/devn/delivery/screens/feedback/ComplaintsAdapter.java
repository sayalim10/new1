package com.devn.delivery.screens.feedback;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devn.delivery.R;

public class ComplaintsAdapter extends RecyclerView.Adapter<ComplaintsAdapter.ComplaintViewHolder> {

    private String[] data;
    public ComplaintsAdapter(String[] data)
    {
       this.data = data;
    }

    @NonNull
    @Override
    public ComplaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_complaint_layout, parent, false);
        return new ComplaintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintViewHolder holder, int position) {
        String title = data[position];
        holder.textTitle.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ComplaintViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        public ComplaintViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
        }
    }
}
