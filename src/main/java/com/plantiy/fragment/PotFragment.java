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
import com.plantiy.adapter.PopularAdapter;
import com.plantiy.adapter.PotsAdapter;
import com.plantiy.model.PopularPlants;
import com.plantiy.model.Pots;

import java.util.ArrayList;
import java.util.List;


public class PotFragment extends Fragment {

    RecyclerView recyclerView;
    FirebaseFirestore db;

    //category
    PotsAdapter potsAdapter;
    List<Pots> potsList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pot, container, false);

        db = FirebaseFirestore.getInstance();
        recyclerView = root.findViewById(R.id.potsRecycler);

        //category items
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        potsList = new ArrayList<>();
        potsAdapter = new PotsAdapter(getActivity(), potsList);
        recyclerView.setAdapter(potsAdapter);

        loadCategoryFromFirestore();
        return root;
    }

    private void loadCategoryFromFirestore() {
        db.collection("Pots")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            Log.e("Firestore error", error.getMessage());
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                potsList.add(dc.getDocument().toObject(Pots.class));
                            }
                            potsAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}