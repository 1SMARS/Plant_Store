package com.plantiy.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.plantiy.R;
import com.plantiy.detailedPlant.PotDetailedActivity;
import com.plantiy.detailedPlant.SucculentDetailedActivity;
import com.plantiy.model.SucculentPlants;

import java.util.List;

public class SucculentAdapter extends RecyclerView.Adapter<SucculentAdapter.ViewHolder> {

    Context context;
    List<SucculentPlants> succulentPlantsList;

    public SucculentAdapter(Context context, List<SucculentPlants> succulentPlantsList) {
        this.context = context;
        this.succulentPlantsList = succulentPlantsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder (
                LayoutInflater.from(context).inflate(R.layout.plant_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(succulentPlantsList.get(position).getImage()).into(holder.imageView);
        holder.name.setText(succulentPlantsList.get(position).getName());
        holder.family.setText(succulentPlantsList.get(position).getFamily());
        holder.price.setText(succulentPlantsList.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SucculentDetailedActivity.class);
                intent.putExtra("detail", succulentPlantsList.get(position));
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return succulentPlantsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, price, family;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.plantImg);
            price = itemView.findViewById(R.id.plantPrice);
            family = itemView.findViewById(R.id.plantFamily);
            name = itemView.findViewById(R.id.plantName);
        }
    }
}
