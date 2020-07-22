package com.example.shopping_fun;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class UserDashboard extends AppCompatActivity implements View.OnClickListener {

        private CardView clothesCard, shoesCard, bagsCard, makeupCard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        //defining card
        clothesCard = (CardView) findViewById(R.id.clothing_card);
        shoesCard = (CardView) findViewById(R.id.shoes_card);
        bagsCard = (CardView) findViewById(R.id.bags_card);
        makeupCard = (CardView) findViewById(R.id.makeup_card);

        //Add Click Listener to the card
        clothesCard.setOnClickListener(this);
        shoesCard.setOnClickListener(this);
        bagsCard.setOnClickListener(this);
        makeupCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i ;

        switch (v.getId()) {
            case R.id.clothing_card : i = new Intent(this, Clothing.class);startActivity(i);break;
            case R.id.shoes_card : i = new Intent(this, Shoes.class);startActivity(i);break;
            case R.id.bags_card : i = new Intent(this, Bags.class);startActivity(i);break;
            case R.id.makeup_card : i = new Intent(this, Makeup.class);startActivity(i);break;
            default:break;
        }
    }
}