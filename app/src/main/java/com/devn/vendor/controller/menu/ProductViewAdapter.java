package com.devn.vendor.controller.menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devn.vendor.R;

import java.util.List;

/**
 * Created by Nitin.Kalokhe on 21-06-2017.
 */

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private Context mContext;
    private String mCategory;
    private List<MyProducts> itemList;
    private IProductListener mListener;

    public ProductViewAdapter(Context context, String category, List<MyProducts> itemLst, IProductListener listener) {
        this.mContext = context;
        this.mCategory = category;
        this.itemList = itemLst;
        this.mListener = listener;
    }

    public List<MyProducts> getProducts() {
        return this.itemList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(mContext).inflate(R.layout.my_product_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, final int position) {
        final MyProducts prod = itemList.get(position);
        holder.productIV.setImageResource(prod.getIconResourceId());
        holder.productTV.setText(prod.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onProductClick(mCategory, prod.getTitle(), position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
