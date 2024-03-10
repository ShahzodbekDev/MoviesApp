package com.example.moviesapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.moviesapp.Adapteres.ActorsListAdapter;
import com.example.moviesapp.Adapteres.CategoryEachFilmLlistAdapter;
import com.example.moviesapp.Domain.FilmItem;
import com.example.moviesapp.R;
import com.google.gson.Gson;

public class DatailActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private ProgressBar progressBar;
    private TextView titleText, movieRateTxt, movieTimeTxt, movieSummryInfo, movieActorsInfo;
    private int idFilm;
    private ImageView pic2, backImg;
    private RecyclerView.Adapter adapterActorList, adapterCategory;
    private RecyclerView recyclerViewActor, recyclerViewCategory;
    private NestedScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datail);

        idFilm = getIntent().getIntExtra("id", 0);
        initView();
        sendRequest();


    }

    private void sendRequest() {
        mRequestQueue = Volley.newRequestQueue(this);
        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
        mStringRequest = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies/" + idFilm, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                progressBar.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);

                FilmItem item = gson.fromJson(response, FilmItem.class);
                Glide.with(DatailActivity.this)
                        .load(item.getPoster())
                        .into(pic2);

                titleText.setText(item.getTitle());
                movieRateTxt.setText(item.getImdbRating());
                movieTimeTxt.setText(item.getRuntime());
                movieSummryInfo.setText(item.getPlot());
                movieActorsInfo.setText(item.getActors());

                if (item.getImages() != null) {
                    adapterActorList = new ActorsListAdapter(item.getImages());
                    recyclerViewActor.setAdapter(adapterActorList);

                }
                if (item.getGenres() != null) {
                    adapterCategory = new CategoryEachFilmLlistAdapter(item.getGenres());
                    recyclerViewCategory.setAdapter(adapterCategory);
                }


            }
        }, volleyError -> progressBar.setVisibility(View.GONE));
        mRequestQueue.add(mStringRequest);
    }

    private void initView() {
        titleText = findViewById(R.id.movieNameTxt);
        progressBar = findViewById(R.id.progressBarDatail);
        scrollView = findViewById(R.id.scrollView2);
        movieRateTxt = findViewById(R.id.movieStar);
        movieTimeTxt = findViewById(R.id.movieTime);
        movieSummryInfo = findViewById(R.id.movieSummary);
        movieActorsInfo = findViewById(R.id.movieActorInfo);
        pic2 = findViewById(R.id.picDatail);
        backImg = findViewById(R.id.backImg);
        recyclerViewActor = findViewById(R.id.imageRecycler);
        recyclerViewCategory = findViewById(R.id.genreView);

        backImg.setOnClickListener(v -> finish());


        recyclerViewActor.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}