package com.example.greencity.ui.Recycling;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
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

    public RecyclingFragment(RecyclingViewModel recyclingViewModel, int contentLayoutId, Button papier, Button verre, Button plastique, Button aluminium, Button menager, Button organique) {
        super(contentLayoutId);
        this.recyclingViewModel = recyclingViewModel;
        Papier = papier;
        Verre = verre;
        Plastique = plastique;
        Aluminium = aluminium;
        Menager = menager;
        Organique = organique;
    }

    public RecyclingFragment(Button papier, Button verre, Button plastique, Button aluminium, Button menager, Button organique, RecyclingViewModel recyclingViewModel) {
        Papier = papier;
        Verre = verre;
        Plastique = plastique;
        Aluminium = aluminium;
        Menager = menager;
        Organique = organique;
        this.recyclingViewModel = recyclingViewModel;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recyclingViewModel = new ViewModelProvider(this).get(RecyclingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recycling, container, false);
        final TextView textView = container.findViewById(R.id.navigation_recycling);
        recyclingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
       
        Papier = root.findViewById(R.id.Papier);
        Papier.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View root){
                Intent intent = new Intent(getActivity(), PaperWasteActivity.class);
                startActivity(intent);
            }
        });
        return root;

        Verre = root.findViewById(R.id.Verre);
        Verre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                final Intent intent = new Intent(getActivity(), GlassWasteActivity.class);
                startActivity(intent);
            }
        });
        Plastique = root.findViewById(R.id.Plastique);
        Plastique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                final Intent intent = new Intent(getActivity(), PlasticWasteActivity.class);
                startActivity(intent);
            }
        });
        Aluminium = root.findViewById(R.id.Aluminium);
        Aluminium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                final Intent intent = new Intent(getActivity(), AluminiumWasteActivity.class);
                startActivity(intent);
            }
        });
        Menager = root.findViewById(R.id.Menager);
        Menager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                final Intent intent = new Intent(getActivity(), HouseholdWasteActivity.class);
                startActivity(intent);
            }
        });
        Organique = root.findViewById(R.id.Organique);
        Organique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View  root) {
                final Intent intent = new Intent(getActivity(), OrganicsWasteActivity.class);
                startActivity(intent);
            }
        });
    }

        
       //autres buttons 
    }
}
