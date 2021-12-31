package com.plantiy.detailedPlant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.plantiy.R;
import com.plantiy.model.IndoorPlants;

import java.util.HashMap;

public class IndoorDetailedActivity extends AppCompatActivity {

    ImageView plantImg, addItem, removeItem;
    TextView plantPrice, plantName, plantDescription, quantity;
    Button addToCart;

    int totalQuantity = 1;
    int totalPrice = 0;

    FirebaseFirestore firestore;

    IndoorPlants indoorPlants = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detailed);

        firestore = FirebaseFirestore.getInstance();

        final Object object = getIntent().getSerializableExtra("detail");
        if (object instanceof IndoorPlants) {
            indoorPlants = (IndoorPlants) object;
        }

        addItem = findViewById(R.id.addItem);
        removeItem = findViewById(R.id.removeItem);
        quantity = findViewById(R.id.quantity);

        plantImg = findViewById(R.id.plantImg);
        plantPrice = findViewById(R.id.plantPrice);
        plantName = findViewById(R.id.plantName);
        plantDescription = findViewById(R.id.plantDescription);

        if (indoorPlants != null) {
            Glide.with(getApplicationContext()).load(indoorPlants.getImage()).into(plantImg);
            plantPrice.setText(indoorPlants.getPrice());
            plantDescription.setText(indoorPlants.getDescription());
            plantName.setText(indoorPlants.getName());
            plantPrice.setText(indoorPlants.getPrice());
            int quantity = Integer.parseInt(indoorPlants.getPrice());
            totalPrice = Integer.parseInt(String.valueOf(quantity * totalQuantity));
        }

        addToCart = findViewById(R.id.addToCart);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addedToCart();
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totalQuantity < 10) {
                    totalQuantity++;
                    quantity.setText(String.valueOf(totalQuantity));
                    int quantity = Integer.parseInt(indoorPlants.getPrice());
                    totalPrice = Integer.parseInt(String.valueOf(quantity * totalQuantity));
                }
            }
        });

        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totalQuantity > 1) {
                    totalQuantity--;
                    quantity.setText(String.valueOf(totalQuantity));
                    int quantity = Integer.parseInt(indoorPlants.getPrice());
                    totalPrice = Integer.parseInt(String.valueOf(quantity * totalQuantity));
                }
            }
        });
    }

    private void addedToCart() {
        final HashMap<String, Object> cartMap = new HashMap<>();

        cartMap.put("plantName", indoorPlants.getName());
        cartMap.put("plantPrice", indoorPlants.getPrice());
        cartMap.put("plantImage", indoorPlants.getImage());
        cartMap.put("totalPrice", totalPrice);
        cartMap.put("totalQuantity", quantity.getText().toString());

        firestore.collection("Cart")
                .add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(IndoorDetailedActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}