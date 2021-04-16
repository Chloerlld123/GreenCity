package com.example.greencity.ui.Recycling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.greencity.R;

public class RecyclingFragment extends Fragment {

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
    }
}