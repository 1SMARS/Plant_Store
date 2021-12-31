package com.plantiy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.plantiy.CartActivity;
import com.plantiy.R;
import com.plantiy.model.CartModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    Context context;
    List<CartModel> cartModelList;

    public CartAdapter(Context context, List<CartModel> cartModelList) {
        this.context = context;
        this.cartModelList = cartModelList;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(cartModelList.get(position).getPlantImage()).into(holder.imageView);
        holder.plantName.setText(cartModelList.get(position).getPlantName());
        holder.plantPrice.setText(cartModelList.get(position).getPlantPrice());
        holder.totalPrice.setText(String.valueOf(cartModelList.get(position).getTotalPrice()));

        holder.totalQuantity.setText(cartModelList.get(position).getTotalQuantity());
    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView plantName, plantPrice, totalQuantity, totalPrice;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            plantName = itemView.findViewById(R.id.cartName);
            plantPrice = itemView.findViewById(R.id.cartPrice);
            totalQuantity = itemView.findViewById(R.id.quantityCart);
            imageView = itemView.findViewById(R.id.cartImg);
            totalPrice = itemView.findViewById(R.id.totalPrice);
        }
    }
}
