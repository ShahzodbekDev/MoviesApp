package com.example.moviesapp.Adapteres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.Domain.GenresItem;
import com.example.moviesapp.R;

import java.util.ArrayList;

public class CategoryLlistAdapter extends RecyclerView.Adapter<CategoryLlistAdapter.ViewHolder> {

    ArrayList<GenresItem> items;
    Context context;

    public CategoryLlistAdapter(ArrayList<GenresItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryLlistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryLlistAdapter.ViewHolder holder, int position) {
        holder.titleText.setText(items.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return  items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.TitleTxt);

        }
    }
}
