package com.example.quarantineapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class DonationFragment extends Fragment {
    public DonationFragment() {
    }
    View view;//change names of views in different fragment classes if needed for clarity
    CardView donateBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.donation_fragment,container,false);
        donateBtn = view.findViewById(R.id.donate_btn);
        donateBtn.setOnClickListener(v -> {
            //open site to donate to some organization
            Intent donate = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.akshayapatra.org/covid-relief-services"));
            startActivity(donate);
        });
        return view;

    }
}
