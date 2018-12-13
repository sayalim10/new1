package com.devn.delivery.controller.menu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devn.delivery.R;


/**
 * Created by Nitin.Kalokhe on 21-06-2017.
 */

public class ProductViewHolder extends RecyclerView.ViewHolder {

    public ImageView productIV;
    public TextView productTV;

    public ProductViewHolder(View productView) {
        super(productView);
        productIV = (ImageView) productView.findViewById(R.id.id_my_product_iv);
        productTV = (TextView) productView.findViewById(R.id.id_my_product_tv);
    }


}
