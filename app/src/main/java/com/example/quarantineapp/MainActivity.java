package com.example.quarantineapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    TextView itemButton, storeButton,heading;
    ImageView searchBtn,menuBtn;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new MarketFragment());
        attachID();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.store:{
                        loadFragment(new MarketFragment());
                        heading.setText("Store");
                    }
                        return true;
                    case R.id.hospital:{
                        loadFragment(new HospitalFragment());
                        heading.setText("Hospital");
                    }
                        return true;
                    case R.id.donation:{
                        loadFragment(new DonationFragment());
                        heading.setText("Donate");
                    }
                        return true;
                    case R.id.covid19update: {
                        loadFragment(new CovidFragment());
                        heading.setText("Covid-19 Live");
                    }
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

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

    }

    private void attachID() {
        frameLayout=findViewById(R.id.frame_layout);
        itemButton=findViewById(R.id.item_button);
        storeButton=findViewById(R.id.store_button);
        bottomNavigationView=findViewById(R.id.bottom_nav);
        searchBtn = findViewById(R.id.search_button);
        drawerLayout = findViewById(R.id.drawer);
        menuBtn = findViewById(R.id.menu_button);
        heading = findViewById(R.id.Home);
    }


    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void DrawerClose(MenuItem item) {
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void ShopLogin(MenuItem item) {
        Intent goShop = new Intent(MainActivity.this,Login.class);
    }

    public void HospLogin(MenuItem item) {
    }
}
