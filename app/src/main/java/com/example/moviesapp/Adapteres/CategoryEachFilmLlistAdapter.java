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
import java.util.List;

public class CategoryEachFilmLlistAdapter extends RecyclerView.Adapter<CategoryEachFilmLlistAdapter.ViewHolder> {

    List<String> items;
    Context context;

    public CategoryEachFilmLlistAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryEachFilmLlistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryEachFilmLlistAdapter.ViewHolder holder, int position) {
        holder.titleText.setText(items.get(position));




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
