package com.example.pandu.myapplication.TopUp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pandu.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailPembayaran extends AppCompatActivity {

    TextView tampilkoderefrensi, tampilidkartu, tampilnama, tampiljumlahtopup, tampiloutlet, tampilrekeningbank;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabasee;
    private FirebaseUser firebaseUser;
    private String userID;
    private DatabaseReference mDatabase;

    Button konfirmasi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pembayaran);

        tampilidkartu = (TextView) findViewById(R.id.Tampilidkartu);
        tampiljumlahtopup = (TextView) findViewById(R.id.Tampiljumlahtopup);
        tampilkoderefrensi = (TextView) findViewById(R.id.Tampilkoderefrensi);
        tampilnama = (TextView) findViewById(R.id.Tampilnama);
        tampiloutlet = (TextView) findViewById(R.id.Tampiloutlet);
        tampilrekeningbank = (TextView) findViewById(R.id.Tampilrekeningbank);

        konfirmasi = (Button) findViewById(R.id.buttonkonfirmasi);
        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builer = new AlertDialog.Builder(DetailPembayaran.this, R.style.AppCompatAlertDialogStyle);
                builer.setMessage("Konfirmasi pembayaran anda dengan membawa bukti transfer ke kasir Amazone. \n\nTerima Kasih")
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //do it
                            }
                        });
                AlertDialog alert = builer.create();
                alert.show();
            }
        });


        firebaseAuth =firebaseAuth.getInstance();
        firebaseDatabasee = FirebaseDatabase.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference uidRef = rootRef.child("Data Top Up").child(uid);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String idkartu = dataSnapshot.child("idkartu").getValue(String.class);
                String topup = dataSnapshot.child("topup").getValue(String.class);
                String code = dataSnapshot.child("code").getValue(String.class);
                String name = dataSnapshot.child("name").getValue(String.class);
                String outlet = dataSnapshot.child("outlet").getValue(String.class);
                String bank = dataSnapshot.child("bank").getValue(String.class);

                tampilidkartu.setText(idkartu);
                tampiljumlahtopup.setText("Rp."+topup);
                tampilkoderefrensi.setText(code);
                tampilnama.setText(name);
                tampiloutlet.setText(outlet);
                tampilrekeningbank.setText(bank);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        uidRef.addListenerForSingleValueEvent(eventListener);
    }
}
