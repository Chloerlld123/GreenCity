package com.example.greencity.ui.Recycling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.greencity.R;

public class RecyclingFragment extends Fragment {
    
    private Button Papier;
    private Button Verres;
    private Button Plastique;
    private Button Aluminium;
    private Button Menager;
    private Button Organique;

    private RecyclingViewModel recyclingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recyclingViewModel =
                new ViewModelProvider(this).get(RecyclingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recycling, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        recyclingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
        Papier = (Button) findViewById(R.id.Papier);
        Papier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclingFragment.this, PaperWasteActivity.class);
                startActivity(intent);
            }
        });
        Verres = (Button) findViewById(R.id.Verre);
        Verres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclingFragment.this, GlassWasteActivity.class);
                startActivity(intent);
            }
        });
        Plastique = (Button) findViewById(R.id.Plastique);
        Plastique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclingFragment.this, PlasticWasteActivity.class);
                startActivity(intent);
            }
        });
        Aluminium = (Button) findViewById(R.id.Aluminium);
        Aluminium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclingFragment.this, AluminiumWasteActivity.class);
                startActivity(intent);
            }
        });
        Menager = (Button) findViewById(R.id.Menager);
        Menager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclingFragment.this, HouseholdWasteActivity.class);
                startActivity(intent);
            }
        });
        Organique = (Button) findViewById(R.id.Organique);
        Organique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclingFragment.this, OrganicsWasteActivity.class);
                startActivity(intent);
            }
        });
        
        
    }
}
