package com.example.pandu.myapplication;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfilUser extends AppCompatActivity {


    private TextView userEmail, username;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabasee;
    private FirebaseUser firebaseUser;
    //private String userID;
    //private DatabaseReference mDatabase;


    /**firebaseUser = firebaseAuth.getCurrentUser() berguna untuk mengambil data (email) dari
    Firebase ke aplikasi kita sehingga bisa kita tampilkan email pengguna dengan
    userEmail.setText(firebaseUser.getEmail())**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_user);

        userEmail = findViewById(R.id.tvEmail);
        username = findViewById(R.id.tvName);


        firebaseAuth =firebaseAuth.getInstance();
        firebaseDatabasee = FirebaseDatabase.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        //userID = firebaseUser.getUid();

        //mAuth = FirebaseAuth.getInstance();
        //mFire = FirebaseDatabase.getInstance();
        //user = mAuth.getCurrentUser();
        //userID = user.getUid();
        //mDatabase = firebaseDatabase.getReference("Data Pengguna");

        /**firebaseUser = firebaseAuth.getCurrentUser();
        userEmail.setText(firebaseUser.getEmail());
        username.setText(firebaseUser.getDisplayName());**/

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Data Pengguna");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Admin admin = dataSnapshot.getValue(Admin.class);
                userEmail.setText(admin.getEmail());
                username.setText(admin.getUsername());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProfilUser.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}





