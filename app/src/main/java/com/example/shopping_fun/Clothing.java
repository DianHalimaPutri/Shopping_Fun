package com.example.shopping_fun;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Clothing extends AppCompatActivity {

    List<Baju> bajuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);

        bajuList = new ArrayList<>();
        bajuList.add(new Baju("Diamore Grosir (Asli)", "https://shopee.co.id/diamore.grosir1", R.drawable.diamore_grosir_asli_));
        bajuList.add(new Baju("Mayoutfit Official Shop", "https://shopee.co.id/mayoutfitofficial", R.drawable.mayoutfit));
        bajuList.add(new Baju("Neda.official", "https://shopee.co.id/neda.official", R.drawable.nedaofficial));
        bajuList.add(new Baju("Zalfa Outfit", "https://shopee.co.id/galleryzalfa", R.drawable.zalfaoutfit));
        bajuList.add(new Baju("Batik Premium Solo", "https://shopee.co.id/batikpremiumsolo", R.drawable.batikpremiumsolo));

        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, bajuList);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);



    }
}