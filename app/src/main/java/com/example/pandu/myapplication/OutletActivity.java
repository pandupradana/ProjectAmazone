package com.example.pandu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.pandu.myapplication.OutletAmazone.AmazoneBassura;
import com.example.pandu.myapplication.OutletAmazone.AmazoneBlokM;
import com.example.pandu.myapplication.OutletAmazone.AmazoneGandaria;
import com.example.pandu.myapplication.OutletAmazone.AmazoneKasablanka;
import com.example.pandu.myapplication.OutletAmazone.AmazoneLotte;
import com.example.pandu.myapplication.OutletAmazone.AmazoneOneBell;
import com.example.pandu.myapplication.OutletAmazone.AmazoneParagon;
import com.example.pandu.myapplication.OutletAmazone.AmazonePermataHijau;
import com.example.pandu.myapplication.OutletAmazone.AmazonePluitVillage;
import com.example.pandu.myapplication.OutletAmazone.AmazoneWildCongo;

public class OutletActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlet);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Outlet");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        CardView amz1 = (CardView) findViewById(R.id.cardviewAmz1);
        amz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazonePluitVillage.class);
                startActivity(i);
            }
        });

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazonePluitVillage.class);
                startActivity(i);
            }
        });

        CardView amz2 = (CardView) findViewById(R.id.cardviewAmz2);
        amz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneWildCongo.class);
                startActivity(i);
            }
        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneWildCongo.class);
                startActivity(i);
            }
        });


        CardView amz4 = (CardView) findViewById(R.id.cardviewAmz4);
        amz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneBassura.class);
                startActivity(i);
            }
        });

        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneBassura.class);
                startActivity(i);
            }
        });

        CardView amz5 = (CardView) findViewById(R.id.cardviewAmz5);
        amz5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneLotte.class);
                startActivity(i);
            }
        });

        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneLotte.class);
                startActivity(i);
            }
        });

        CardView amz6 = (CardView) findViewById(R.id.cardviewAmz6);
        amz6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazonePermataHijau.class);
                startActivity(i);
            }
        });

        Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazonePermataHijau.class);
                startActivity(i);
            }
        });

        CardView amz7 = (CardView) findViewById(R.id.cardviewAmz7);
        amz7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneGandaria.class);
                startActivity(i);
            }
        });

        Button btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneGandaria.class);
                startActivity(i);
            }
        });

        CardView amz8 = (CardView) findViewById(R.id.cardviewAmz8);
        amz8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneBlokM.class);
                startActivity(i);
            }
        });

        Button btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneBlokM.class);
                startActivity(i);
            }
        });

        CardView amz9 = (CardView) findViewById(R.id.cardviewAmz9);
        amz9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneOneBell.class);
                startActivity(i);
            }
        });

        Button btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneOneBell.class);
                startActivity(i);
            }
        });

        CardView amz10 = (CardView) findViewById(R.id.cardviewAmz10);
        amz10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneParagon.class);
                startActivity(i);
            }
        });

        Button btn10 = (Button) findViewById(R.id.button10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneParagon.class);
                startActivity(i);
            }
        });

        CardView amz11 = (CardView) findViewById(R.id.cardviewAmz11);
        amz11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneKasablanka.class);
                startActivity(i);
            }
        });

        Button btn11 = (Button) findViewById(R.id.button11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OutletActivity.this, AmazoneKasablanka.class);
                startActivity(i);
            }
        });

    }
}
