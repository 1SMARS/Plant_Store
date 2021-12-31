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
import com.plantiy.detailedPlant.IndoorDetailedActivity;
import com.plantiy.model.IndoorPlants;

import java.util.List;

public class IndoorAdapter extends RecyclerView.Adapter<IndoorAdapter.ViewHolder> {

    Context context;
    List<IndoorPlants> indoorPlantsList;

    public IndoorAdapter(Context context, List<IndoorPlants> indoorPlantsList) {
        this.context = context;
        this.indoorPlantsList = indoorPlantsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder (
                LayoutInflater.from(context).inflate(R.layout.plant_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(indoorPlantsList.get(position).getImage()).into(holder.imageView);
        holder.name.setText(indoorPlantsList.get(position).getName());
        holder.family.setText(indoorPlantsList.get(position).getFamily());
        holder.price.setText(indoorPlantsList.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, IndoorDetailedActivity.class);
                intent.putExtra("detail", indoorPlantsList.get(position));
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return indoorPlantsList.size();
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


