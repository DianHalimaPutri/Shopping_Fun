package com.example.shopping_fun.HalperClass.HomeAdapter;

import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {

    int image;
    String title, description;

    public CategoriesHelperClass (int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public CategoriesHelperClass(GradientDrawable gradient4, int emina, String description) {
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
