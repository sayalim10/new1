package com.devn.delivery.screens.returnprocess.dinner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devn.delivery.R;

public class ReturnVenderAdapter extends RecyclerView.Adapter<ReturnVenderAdapter.ReturnVenderViewHolder> {

    private String[] data;
    public ReturnVenderAdapter(String[] data, Context mContext)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public ReturnVenderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_return_vender_dinner, parent, false);
        return new ReturnVenderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReturnVenderViewHolder holder, int position) {
        String title = data[position];
        holder.texttitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ReturnVenderViewHolder extends RecyclerView.ViewHolder{
        TextView texttitle;
        public ReturnVenderViewHolder(View itemView) {
            super(itemView);
            texttitle = itemView.findViewById(R.id.textTitle3);
        }
    }
}
