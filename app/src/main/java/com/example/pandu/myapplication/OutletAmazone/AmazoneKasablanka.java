package com.example.pandu.myapplication.OutletAmazone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pandu.myapplication.Maps.MapsAmazoneGandaria;
import com.example.pandu.myapplication.Maps.MapsAmazoneKasablanka;
import com.example.pandu.myapplication.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class AmazoneKasablanka extends AppCompatActivity {

    CarouselView carouselView;

    int[] images = {R.drawable.kokas2, R.drawable.kokas3, R.drawable.kokas4, R.drawable.kokas5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazone_kasablanka);
        carouselView = (CarouselView) findViewById(R.id.carouselview);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(imageListener);

        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        };




        Button lokasi = (Button) findViewById(R.id.lokasi);
        lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AmazoneKasablanka.this, MapsAmazoneKasablanka.class);
                startActivity(i);
            }
        });

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };
}
