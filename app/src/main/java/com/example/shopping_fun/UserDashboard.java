package com.example.shopping_fun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.shopping_fun.HalperClass.HomeAdapter.FeaturedAdapter;
import com.example.shopping_fun.HalperClass.HomeAdapter.FeaturedHelperClass;
import com.example.shopping_fun.LoginSignup.ReatailStartUpScreen;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Variable
    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menu_Icon;
    LinearLayout contentView;

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
        contentView = findViewById(R.id.content);


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
                final float offsetScale = 1 - diffScledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                //Translate  the view , accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetdiff = contentView.getWidth() * diffScledOffset / 2;
                final float xTranslation = xOffset - xOffsetdiff;
                contentView.setTranslationX(xTranslation);

            }

        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }


    //Recycler Views Functions
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

    //normal function

    public void  callRetailSCreen(View view){

        startActivity(new Intent(getApplicationContext(), ReatailStartUpScreen.class));

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }

}