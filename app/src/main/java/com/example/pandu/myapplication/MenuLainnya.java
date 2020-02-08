package com.example.pandu.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pandu.myapplication.ExpandableListView.MenuTentang;
import com.example.pandu.myapplication.TopUp.DetailPembayaran;
import com.google.firebase.auth.FirebaseAuth;

public class MenuLainnya extends AppCompatActivity {

   private Button buttonlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lainnya);

        buttonlogout = (Button) findViewById(R.id.buttonlain2);
        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Lainnya");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btn1 = (Button) findViewById(R.id.buttonlain1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuLainnya.this, MenuTentang.class);
                startActivity(i);
            }
        });

        Button btn = (Button) findViewById(R.id.buttonlain);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuLainnya.this, DetailPembayaran.class);
                startActivity(i);
            }
        });

        TextView versionName = findViewById(R.id.version);
        versionName.setText("v" + BuildConfig.VERSION_NAME);
    }

    private void showDialog() {

        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
            builder.setMessage("Apakah yakin anda ingin keluar?");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //i.putExtra("finish", true);
                    //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
                    //startActivity(i);
                    //FirebaseAuth.getInstance().signOut();
                    logout();
                    finish();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alert1 = builder.create();
            alert1.show();
        }
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MenuLainnya.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK //agar tidak kembali ke menu activity
                | Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
