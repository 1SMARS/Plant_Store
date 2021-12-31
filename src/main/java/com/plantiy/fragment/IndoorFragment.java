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
import com.plantiy.adapter.IndoorAdapter;
import com.plantiy.adapter.PopularAdapter;
import com.plantiy.model.IndoorPlants;
import com.plantiy.model.PopularPlants;

import java.util.ArrayList;
import java.util.List;

public class IndoorFragment extends Fragment {

    RecyclerView recyclerView;
    FirebaseFirestore db;

    //category
    IndoorAdapter indoorAdapter;
    List<IndoorPlants> indoorPlantsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_indoor, container, false);
        db = FirebaseFirestore.getInstance();
        recyclerView = root.findViewById(R.id.indoorRecycler);

        //category items
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        indoorPlantsList = new ArrayList<>();
        indoorAdapter = new IndoorAdapter(getActivity(), indoorPlantsList);
        recyclerView.setAdapter(indoorAdapter);

        loadPlantsFromFirestore();
        return root;
    }

    private void loadPlantsFromFirestore() {
        db.collection("IndoorPlants")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("Firestore error", error.getMessage());
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                indoorPlantsList.add(dc.getDocument().toObject(IndoorPlants.class));
                            }
                            indoorAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}