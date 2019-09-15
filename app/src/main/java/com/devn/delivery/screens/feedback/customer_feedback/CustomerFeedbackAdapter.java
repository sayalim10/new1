package com.devn.delivery.screens.feedback.customer_feedback;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devn.delivery.R;

public class CustomerFeedbackAdapter extends RecyclerView.Adapter<CustomerFeedbackAdapter.CustomerFeedbackViewHolder> {
    private String[] data;
    public CustomerFeedbackAdapter(String[] data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public CustomerFeedbackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_customer_feedback, parent, false);;
        return new CustomerFeedbackViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerFeedbackViewHolder holder, int position) {
        String title = data[position];
        holder.textTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class CustomerFeedbackViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        public CustomerFeedbackViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle2);
        }
    }
}
