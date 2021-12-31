package com.plantiy.detailedPlant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.plantiy.R;
import com.plantiy.model.IndoorPlants;
import com.plantiy.model.Pots;

public class PotDetailedActivity extends AppCompatActivity {

    ImageView plantImg;
    TextView plantPrice, plantName, plantDescription;
    Button addToCart;

    Pots pots = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detailed);

        final Object object = getIntent().getSerializableExtra("detail");
        if(object instanceof Pots) {
            pots = (Pots) object;
        }

        plantImg = findViewById(R.id.plantImg);
        plantPrice = findViewById(R.id.plantPrice);
        plantName = findViewById(R.id.plantName);
        plantDescription = findViewById(R.id.plantDescription);

        if(pots != null) {
            Glide.with(getApplicationContext()).load(pots.getImage()).into(plantImg);
            plantPrice.setText(pots.getPrice());
            plantDescription.setText(pots.getDescription());
            plantName.setText(pots.getName());
            plantPrice.setText(pots.getPrice());
        }

        addToCart = findViewById(R.id.addToCart);
    }
}