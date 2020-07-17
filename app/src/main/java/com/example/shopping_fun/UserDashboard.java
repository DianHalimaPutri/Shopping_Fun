package com.example.shopping_fun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.ArrayLinkedVariables;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.shopping_fun.HalperClass.HomeAdapter.FeaturedAdapter;
import com.example.shopping_fun.HalperClass.HomeAdapter.FeaturedHelperClass;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menu_Icon;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        menu_Icon = findViewById(R.id.menu_icon);


        //Functions will be executed automatically when this activity will be created
        featuredRecycler();


        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        navigationDrawer();


    }

    //Navigation Drawer Functions
    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menu_Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //scale the view based on current
                final float diffScledOffset = slideOffset * (1  -  END_SCALE);
                final float offsetScale = diffScledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }


    //Recycler Views Functions
    private void categoriesRecycle() {

        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});

        ArrayList<CategoriesHalperClass> categoriesHalperClasses = new ArrayList<>();
        categoriesHalperClasses.add(new CategoriesHalperClass(gradient1, R.drawable.damelia, "Damelia"));
        categoriesHalperClasses.add(new CategoriesHalperClass(gradient2, R.drawable.diamore_grosir_asli_, "Diamore"));
        categoriesHalperClasses.add(new CategoriesHalperClass(gradient3, R.drawable.miniso, "Minisp"));
        categoriesHalperClasses.add(new CategoriesHalperClass(gradient4, R.drawable.emina, "Emina"));


    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.emina, "Emina", "Emina Glossy Stain adalah lip tint dengan gloss finish yang nyaman digunakan sehari-hari"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.damelia, "Damelia", "andmade sepatu, tas, dompet dan baju yang bergaransi 30-60 hari, untuk kualitas dan kenyamanannya sudah terjamin."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.diamore_grosir_asli_, "Diamore", ""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.miniso, "Miniso", "menyediakan konsumen dengan produk-produk yang simple, natural, basic, high quality dan dengan harga yang terjangkau."));


        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


        GradientDrawable gradient = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});


    }

}