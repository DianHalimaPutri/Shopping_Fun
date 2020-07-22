package com.example.shopping_fun;

public class Baju {

    private String Title;
    private String Description;
    private int Thumbanail;


    public Baju (){


    }


    public Baju(String title, String description, int thumbanail) {
        Title = title;
        Description = description;
        Thumbanail = thumbanail;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbanail() {
        return Thumbanail;
    }
}
