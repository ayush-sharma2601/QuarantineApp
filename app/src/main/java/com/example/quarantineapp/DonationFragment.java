package com.example.quarantineapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DonationFragment extends Fragment {
    public DonationFragment() {
    }
    View view;//change names of views in different fragment classes if needed for clarity
    TextView donateBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.donation_fragment,container,false);
        donateBtn = view.findViewById(R.id.donate_btn);
        donateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open site to donate to some organization
            }
        });
        return view;

    }
}
