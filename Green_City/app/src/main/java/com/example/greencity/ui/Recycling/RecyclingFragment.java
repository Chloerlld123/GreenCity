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

import com.example.greencity.AluminiumWasteActivity;
import com.example.greencity.GlassWasteActivity;
import com.example.greencity.HouseholdWasteActivity;
import com.example.greencity.OrganicsWasteActivity;
import com.example.greencity.PaperWasteActivity;
import com.example.greencity.PlasticWasteActivity;
import com.example.greencity.R;

public class RecyclingFragment extends Fragment {
    
    private Button Papier;
    private Button Verre;
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
        final TextView textView = container.findViewById(R.id.navigation_recycling);
        recyclingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
        Papier = (Button) container.findViewById(R.id.Papier);
        Papier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final Intent intent = new Intent(this, PaperWasteActivity.class);
                startActivity(intent);
            }
        });
        Verre = (Button) container.findViewById(R.id.Verre);
        Verre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(this, GlassWasteActivity.class);
                startActivity(intent);
            }
        });
        Plastique = (Button) container.findViewById(R.id.Plastique);
        Plastique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final Intent intent = new Intent(this, PlasticWasteActivity.class);
                startActivity(intent);
            }
        });
        Aluminium = (Button) container.findViewById(R.id.Aluminium);
        Aluminium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(this, AluminiumWasteActivity.class);
                startActivity(intent);
            }
        });
        Menager = (Button) container.findViewById(R.id.Menager);
        Menager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(this, HouseholdWasteActivity.class);
                startActivity(intent);
            }
        });
        Organique = (Button) container.findViewById(R.id.Organique);
        Organique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(this, OrganicsWasteActivity.class);
                startActivity(intent);
            }
        });
        
        
    }
}
