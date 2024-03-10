package com.example.moviesapp.Adapteres;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviesapp.Activities.DatailActivity;
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
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_film, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmLlistAdapter.ViewHolder holder, int position) {
        holder.titleText.setText(items.getData().get(position).getTitle());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transform(new CenterCrop(), new RoundedCorners(30));

        Glide.with(context)
                .load(items.getData().get(position).getPoster())
                .apply(requestOptions)
                .into(holder.pic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DatailActivity.class);
                intent.putExtra("id", items.getData().get(position).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return  items.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.textTitle);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
