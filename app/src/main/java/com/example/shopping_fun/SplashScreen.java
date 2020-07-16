package com.example.shopping_fun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
        private int waktu_loading = 4000;

        //4000 = 4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Intent intent = new Intent(SplashScreen.this, UserDashboard.class) ;
        startActivity(intent);
        finish();
    }
}