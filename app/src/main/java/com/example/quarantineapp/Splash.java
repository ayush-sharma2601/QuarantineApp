package com.example.quarantineapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    ImageView splashTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        splashTv=findViewById(R.id.splashiv);
//        splashTv.setImageResource(R.mipmap.qqqa);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },2000);
    }
}
