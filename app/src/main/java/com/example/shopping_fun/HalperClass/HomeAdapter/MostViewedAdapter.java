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

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedHolder> {

    ArrayList<MostViewedHelperClass> mostViewedlocations;

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewedlocations) {
        this.mostViewedlocations = mostViewedlocations;
    }

    @NonNull
    @Override
    public MostViewedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
        MostViewedHolder mostViewedHolder = new MostViewedHolder(view);
        return mostViewedHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedHolder holder, int position) {
        MostViewedHelperClass mostViewedHelperClass = mostViewedlocations.get(position);

        holder.image.setImageResource(mostViewedHelperClass.getImage());
        holder.title.setText(mostViewedHelperClass.getTitle());
        holder.desc.setText(mostViewedHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return mostViewedlocations.size();
    }

    public static class MostViewedHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public MostViewedHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.eminaliptin);
            title = itemView.findViewById(R.id.emina_title);
            desc = itemView.findViewById(R.id.emina_desc);
        }
    }


}
