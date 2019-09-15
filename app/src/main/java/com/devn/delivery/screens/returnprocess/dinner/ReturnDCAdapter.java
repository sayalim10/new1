package com.devn.delivery.screens.returnprocess.dinner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devn.delivery.R;

public class ReturnDCAdapter extends RecyclerView.Adapter<ReturnDCAdapter.ReturndinnerViewHolder> {

    private String[] data;
    public ReturnDCAdapter(String[] data, Context mContext)
    {
      this.data = data;
    }

    @NonNull
    @Override
    public ReturndinnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_return_dc_dinner, parent, false);
        return new ReturndinnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReturndinnerViewHolder holder, int position) {
        String title = data[position];
        holder.texttitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ReturndinnerViewHolder extends RecyclerView.ViewHolder{
        TextView texttitle;
        public ReturndinnerViewHolder(View itemView) {
            super(itemView);
            texttitle = itemView.findViewById(R.id.textTitle1);
        }
    }
}
