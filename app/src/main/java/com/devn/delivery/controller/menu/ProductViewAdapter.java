package com.devn.delivery.controller.menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devn.delivery.R;
import com.devn.delivery.controller.menu.IProductListener;
import com.devn.delivery.controller.menu.MyProducts;
import com.devn.delivery.controller.menu.ProductViewHolder;

import java.util.List;

/**
 * Created by Nitin.Kalokhe on 21-06-2017.
 */

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private Context mContext;
    private String mCategory;
    private List<com.devn.delivery.controller.menu.MyProducts> itemList;
    private com.devn.delivery.controller.menu.IProductListener mListener;

    public ProductViewAdapter(Context context, String category, List<com.devn.delivery.controller.menu.MyProducts> itemLst, IProductListener listener) {
        this.mContext = context;
        this.mCategory = category;
        this.itemList = itemLst;
        this.mListener = listener;
    }

    public List<com.devn.delivery.controller.menu.MyProducts> getProducts() {
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
