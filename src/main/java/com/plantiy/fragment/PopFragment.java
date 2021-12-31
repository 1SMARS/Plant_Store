package com.plantiy.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.plantiy.R;
//import com.plantiy.ViewAllActivity;
import com.plantiy.adapter.PopularAdapter;
//import com.plantiy.adapter.PopularAdapter;
import com.plantiy.model.PopularPlants;

import java.util.ArrayList;
import java.util.List;

public class PopFragment extends Fragment {

    RecyclerView  main_categoryRecycler;
    FirebaseFirestore db;

    //category
    PopularAdapter popularAdapter;
    List<PopularPlants> popularPlantsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_popular, container, false);


        db = FirebaseFirestore.getInstance();
        main_categoryRecycler = root.findViewById(R.id.main_categoryRecycler);

        //category items
        main_categoryRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        popularPlantsList = new ArrayList<>();
        popularAdapter = new PopularAdapter(getActivity(), popularPlantsList);
        main_categoryRecycler.setAdapter(popularAdapter);

        loadCategoryFromFirestore();
        return root;
    }

    private void loadCategoryFromFirestore() {
        db.collection("PopularPlants")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("Firestore error", error.getMessage());
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                popularPlantsList.add(dc.getDocument().toObject(PopularPlants.class));
                            }
                            popularAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}

