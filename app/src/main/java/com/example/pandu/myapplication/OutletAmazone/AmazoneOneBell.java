package com.example.pandu.myapplication.OutletAmazone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pandu.myapplication.Maps.MapsAmazoneLotte;
import com.example.pandu.myapplication.Maps.MapsAmazoneOneBell;
import com.example.pandu.myapplication.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class AmazoneOneBell extends AppCompatActivity {

    CarouselView carouselView;

    int[] images = {R.drawable.onebel2, R.drawable.onebel3, R.drawable.onebel4, R.drawable.onebel5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazone_one_bell);

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
                Intent i = new Intent(AmazoneOneBell.this, MapsAmazoneOneBell.class);
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
