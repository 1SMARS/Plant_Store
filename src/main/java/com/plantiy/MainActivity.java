package com.plantiy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.plantiy.fragment.IndoorFragment;
import com.plantiy.fragment.PopFragment;
import com.plantiy.fragment.PotFragment;
import com.plantiy.fragment.SucculentFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView popular, indoor, succulent, pot;
        ImageView cart;

        cart = findViewById(R.id.cart);
        popular = findViewById(R.id.navPop);
        indoor = findViewById(R.id.navIndoor);
        succulent = findViewById(R.id.navSucculent);
        pot = findViewById(R.id.navPot);

        replaceFragment(new PopFragment());
        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PopFragment());
            }
        });

        indoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new IndoorFragment());
            }
        });

        succulent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SucculentFragment());
            }
        });

        pot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PotFragment());
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.fragment, fragment);
        tx.commit();
    }
}