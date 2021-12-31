package com.plantiy.detailedPlant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.plantiy.R;
import com.plantiy.model.Pots;
import com.plantiy.model.SucculentPlants;

public class SucculentDetailedActivity extends AppCompatActivity {

    ImageView plantImg;
    TextView plantPrice, plantName, plantDescription;
    Button addToCart;

    SucculentPlants succulentPlants = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detailed);

        final Object object = getIntent().getSerializableExtra("detail");
        if(object instanceof SucculentPlants) {
            succulentPlants = (SucculentPlants) object;
        }

        plantImg = findViewById(R.id.plantImg);
        plantPrice = findViewById(R.id.plantPrice);
        plantName = findViewById(R.id.plantName);
        plantDescription = findViewById(R.id.plantDescription);

        if(succulentPlants != null) {
            Glide.with(getApplicationContext()).load(succulentPlants.getImage()).into(plantImg);
            plantPrice.setText(succulentPlants.getPrice());
            plantDescription.setText(succulentPlants.getDescription());
            plantName.setText(succulentPlants.getName());
            plantPrice.setText(succulentPlants.getPrice());
        }

        addToCart = findViewById(R.id.addToCart);
    }
}