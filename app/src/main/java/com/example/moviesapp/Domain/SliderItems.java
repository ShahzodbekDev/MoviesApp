package com.example.moviesapp.Domain;

import androidx.annotation.NonNull;

public class SliderItems {
    public SliderItems(int image) {
        this.image = image;
    }

    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
