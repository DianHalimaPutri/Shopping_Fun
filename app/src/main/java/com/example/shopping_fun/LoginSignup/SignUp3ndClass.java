package com.example.shopping_fun.LoginSignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopping_fun.R;

class SignUp3ndClass extends AppCompatActivity {
    //Variables
    ImageView backBtn;
    Button next, login;
    TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3nd_class);

        //Hooks
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleView = findViewById(R.id.signup_title_text);
    }
    public void callNextSignupScreen(View view) {

        Intent intent = new Intent(getApplicationContext(),SignUp3ndClass.class);
    }

}
