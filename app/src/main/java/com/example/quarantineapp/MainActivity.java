package com.example.quarantineapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    TextView itemButton, storeButton;
    ImageView searchBtn;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new MarketFragment());

        frameLayout=findViewById(R.id.frame_layout);
        itemButton=findViewById(R.id.item_button);
        storeButton=findViewById(R.id.store_button);
        bottomNavigationView=findViewById(R.id.bottom_nav);
        searchBtn = findViewById(R.id.search_button);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.store:loadFragment(new MarketFragment());
                        return true;
                    case R.id.hospital:loadFragment(new HospitalFragment());
                        return true;
                    case R.id.donation:loadFragment(new DonationFragment());
                        return true;
                    case R.id.leaderboard:loadFragment(new LeaderboardFragment());
                        return true;
                }
                return false;
            }
        });

        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new ItemFragment());
            }
        });

        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new MarketFragment());
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SearchFragment());
            }
        });

    }

    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
