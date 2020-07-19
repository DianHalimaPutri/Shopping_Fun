package com.example.shopping_fun.LoginSignup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopping_fun.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

class SignUp3ndClass extends AppCompatActivity {
    //Variables
    ImageView backBtn;
    Button next, login;
    TextView titleView;
    ScrollView scrollView;
    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up3nd_class);

        //Hooks
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleView = findViewById(R.id.signup_title_text);

       
        countryCodePicker = findViewById(R.id.country_code_picker);
        phoneNumber = findViewById(R.id.signup_phone_number);

    }

    public void callVerifyOTPScreen (View view){}

    public void callNextSignupScreen(View view) {

        Intent intent = new Intent(getApplicationContext(),SignUp3ndClass.class);
    }

}
