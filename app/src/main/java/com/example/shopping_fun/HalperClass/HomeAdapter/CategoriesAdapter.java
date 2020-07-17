package com.example.shopping_fun.HalperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_fun.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    ArrayList<CategoriesHelperClass> categoriesLocations;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categoriesLocations) {
        this.categoriesLocations = categoriesLocations;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        CategoriesHelperClass categoriesHelperClass = categoriesLocations.get(position);

        holder.image.setImageResource(categoriesHelperClass.getImage());
        holder.title.setText(categoriesHelperClass.getTitle());
        holder.desc.setText(categoriesHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {

        return categoriesLocations.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, desc;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.eminaliptin);
            title = itemView.findViewById(R.id.emina_title);
            desc = itemView.findViewById(R.id.emina_desc);
        }
    }




}
