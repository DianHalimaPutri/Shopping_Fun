package com.example.shopping_fun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.ArrayLinkedVariables;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.shopping_fun.HalperClass.HomeAdapter.FeaturedAdapter;
import com.example.shopping_fun.HalperClass.HomeAdapter.FeaturedHelperClass;

import java.util.ArrayList;


public class UserDashboard extends AppCompatActivity {

    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);

        featuredRecycler();

    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList <FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.emina, "Emina","Emina Glossy Stain adalah lip tint dengan gloss finish yang nyaman digunakan sehari-hari"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.damelia, "Damelia","andmade sepatu, tas, dompet dan baju yang bergaransi 30-60 hari, untuk kualitas dan kenyamanannya sudah terjamin."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.diamore_grosir_asli_, "Diamore",""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.miniso, "Miniso","menyediakan konsumen dengan produk-produk yang simple, natural, basic, high quality dan dengan harga yang terjangkau."));


        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


        GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});



    }

}