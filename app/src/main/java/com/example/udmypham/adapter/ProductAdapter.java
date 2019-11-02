package com.example.udmypham.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.udmypham.R;
import com.example.udmypham.model.product;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemHolder> {
    Context context;
    ArrayList<product> arraySP;

    public ProductAdapter(Context context, ArrayList<product> arraySP) {
        this.context = context;
        this.arraySP = arraySP;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_productnew, null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        product product = arraySP.get(position);
        holder.txtViewSP.setText(product.getNamesp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtViewPrice.setText("Giá : " + decimalFormat.format(product.getPricesp())+ " Đ");
        Picasso.with(context).load(product.getImagesp())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(holder.imageViewSP);
    }

    @Override
    public int getItemCount() {return arraySP.size(); }

    public class  ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imageViewSP;
        public TextView txtViewSP, txtViewPrice;

        public ItemHolder(View itemView) {
            super(itemView);
            imageViewSP = (ImageView) itemView.findViewById(R.id.imageSP);
            txtViewSP = (TextView) itemView.findViewById(R.id.txtNameSP);
            txtViewPrice = (TextView) itemView.findViewById(R.id.txtPriceSP);
        }
    }
}
