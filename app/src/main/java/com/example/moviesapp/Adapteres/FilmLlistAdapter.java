package com.example.moviesapp.Adapteres;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.Domain.ListFilm;
import com.example.moviesapp.R;

public class FilmLlistAdapter extends RecyclerView.Adapter<FilmLlistAdapter.ViewHolder> {

    ListFilm items;
    Context context;

    public FilmLlistAdapter(ListFilm items) {
        this.items = items;
    }

    @NonNull
    @Override
    public FilmLlistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmLlistAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.textTitle);
        }
    }
}
