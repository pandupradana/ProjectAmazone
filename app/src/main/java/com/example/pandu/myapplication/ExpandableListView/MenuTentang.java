package com.example.pandu.myapplication.ExpandableListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.pandu.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuTentang extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tentang);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Tentang");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        listView = (ExpandableListView)findViewById(R.id.expanded_menu);
        initData();
        listAdapter = new ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Pengembang Aplikasi");
        listDataHeader.add("Pembuatan");
        listDataHeader.add("Credits");

        List<String> penulis = new ArrayList<>();
        penulis.add("Aplikasi ini dibuat oleh:\nPandu Pradana Putra\n4KA31\n15115303");

        List<String> pembuatan = new ArrayList<>();
        pembuatan.add("Dalam pembuatan aplikasi ini menggunakan Android Studio versi 3.4 dan Firebase");

        List<String> credits = new ArrayList<>();
        credits.add("Icon yang digunakan dalam aplikasi ini diperoleh dari www.flaticon.com karya freepik");


        listHash.put(listDataHeader.get(0),penulis);
        listHash.put(listDataHeader.get(1),pembuatan);
        listHash.put(listDataHeader.get(2),credits);

    }
}
