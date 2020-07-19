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

import com.example.shopping_fun.HalperClass.HomeAdapter.CategoriesAdapter;
import com.example.shopping_fun.HalperClass.HomeAdapter.CategoriesHelperClass;
import com.example.shopping_fun.HalperClass.HomeAdapter.FeaturedAdapter;
import com.example.shopping_fun.HalperClass.HomeAdapter.FeaturedHelperClass;
import com.example.shopping_fun.HalperClass.HomeAdapter.MostViewedAdapter;
import com.example.shopping_fun.HalperClass.HomeAdapter.MostViewedHelperClass;
import com.example.shopping_fun.LoginSignup.ReatailStartUpScreen;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Variable
    static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler , mostViwedRecycler , categoriesRecycler;
    RecyclerView.Adapter  adapter;
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
        mostViwedRecycler = findViewById(R.id.most_recycler);
        categoriesRecycler = findViewById(R.id.categories_recyler);
        menu_Icon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);


        //Functions will be executed automatically when this activity will be created
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();;


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

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.emina, "Emina", "Emina Glossy Stain adalah lip tint dengan gloss finish yang nyaman digunakan sehari-hari"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.damelia, "Damelia", "andmade sepatu, tas, dompet dan baju yang bergaransi 30-60 hari, untuk kualitas dan kenyamanannya sudah terjamin."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.diamore_grosir_asli_, "Diamore", ""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.miniso, "Miniso", "menyediakan konsumen dengan produk-produk yang simple, natural, basic, high quality dan dengan harga yang terjangkau."));

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }

    private void mostViewedRecycler() {


        mostViwedRecycler.setHasFixedSize(true);
        mostViwedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();



        adapter = new MostViewedAdapter(mostViewedLocations);
        mostViwedRecycler.setAdapter(adapter);
    }

    private void categoriesRecycler(){

        //AllGradient

        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});

        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses(new CategoriesHelperClass(gradient2, R.drawable.damelia,"sepatu, tas, dompet dan baju yang bergaransi 30-60 hari, untuk kualitas dan kenyamanannya sudah terjamin."));
        categoriesHelperClasses(new CategoriesHelperClass(gradient1, R.drawable.diamore_grosir_asli_,""));
        categoriesHelperClasses(new CategoriesHelperClass(gradient3, R.drawable.miniso," produk-produk yang simple, natural, basic, high quality dan dengan harga yang terjangkau."));
        categoriesHelperClasses(new CategoriesHelperClass(gradient4, R.drawable.emina,""));

        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setAdapter(adapter);

    }

    private void categoriesHelperClasses(CategoriesHelperClass categoriesHelperClass) {
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