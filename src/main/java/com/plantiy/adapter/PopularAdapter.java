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
//import com.plantiy.ViewAllActivity;
//import com.plantiy.ViewAllActivity;
//import com.plantiy.fragment.PlantsFragment;
import com.plantiy.detailedPlant.PopularDetailedActivity;
import com.plantiy.model.PopularPlants;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    Context context;
    List<PopularPlants> popularPlantsList;

    public PopularAdapter(Context context, List<PopularPlants> popularPlantsList) {
        this.context = context;
        this.popularPlantsList = popularPlantsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder (
                LayoutInflater.from(context).inflate(R.layout.plant_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(popularPlantsList.get(position).getImage()).into(holder.imageView);
        holder.name.setText(popularPlantsList.get(position).getName());
        holder.family.setText(popularPlantsList.get(position).getFamily());
        holder.price.setText(popularPlantsList.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PopularDetailedActivity.class);
                intent.putExtra("detail", popularPlantsList.get(position));
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return popularPlantsList.size();
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

