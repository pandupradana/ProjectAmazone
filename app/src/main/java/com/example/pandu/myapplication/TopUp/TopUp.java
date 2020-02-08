package com.example.pandu.myapplication.TopUp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pandu.myapplication.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.util.Random;

public class TopUp extends AppCompatActivity {

    private int waktu_loading=4000;

    //view objects
    EditText editTextName, editTextIdKartu;
    TextView textViewcode;
    RadioGroup transferbank;
    Spinner spinnerOutlet,spinnerTopup;
    Button buttonAddArtist, detailpembayaran;
    ListView listViewArtists;
    Toolbar mToolbar;

   RadioButton radioTransferButton;
    //a list to store all the artist from firebase database
    List<TopUpModel> topUpModels;

    //our database reference object
    DatabaseReference databaseTopup;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Top Up");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //getting the reference of artists node
        databaseTopup = FirebaseDatabase.getInstance().getReference("Data Top Up");

        //getting views
        editTextName = (EditText) findViewById(R.id.editTextName);
        textViewcode = (TextView) findViewById(R.id.textviewcode);
        editTextIdKartu = (EditText) findViewById(R.id.editTextIdKartu);

        progressBar = (ProgressBar) findViewById(R.id.spinkit);

        spinnerTopup = (Spinner) findViewById(R.id.spinnerTopup);
        spinnerOutlet = (Spinner) findViewById(R.id.spinnerOutlet);

        transferbank = (RadioGroup) findViewById(R.id.radiogrup1);

        buttonAddArtist = (Button) findViewById(R.id.buttonAddTrack);
        detailpembayaran = (Button) findViewById(R.id.buttonDetailPembayaran);

        editTextName.addTextChangedListener(loginTextWatcher);
        editTextIdKartu.addTextChangedListener(loginTextWatcher);

        //list to store artists
        topUpModels = new ArrayList<>();

        detailpembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TopUp.this, DetailPembayaran.class);
                startActivity(i);
            }
        });

        //adding an onclicklistener to button
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                            //setelah loading maka akan langsung berpindah ke home activity
                            Intent i = new Intent(TopUp.this, DetailPembayaran.class);
                            startActivity(i);
                            finish();
                    }
                },waktu_loading);

                progressBar.setVisibility(View.VISIBLE);
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                textViewcode.setText(generateString(6));
                addTopUp();
            }
        });

        /**-----------------------------------------------------------------
         * MEMBUAT NOMOR CODE
         *
         * button=(Button) findViewById(R.id.button11);
        textView=(TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //generate string 6 symbl
                //textView.setText(generateString(6));
            }
        });
         ----------------------------------------------------------------**/
    }


    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String name = editTextName.getText().toString().trim();
            String idkartu = editTextIdKartu.getText().toString().trim();
            buttonAddArtist.setEnabled(!name.isEmpty() && !idkartu.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

    /*
     * This method is saving a new artist to the
     * Firebase Realtime Database
     * */
    private void addTopUp() {
        //getting the values to save
        String name = editTextName.getText().toString().trim();
        String code = textViewcode.getText().toString().trim();
        String idkartu = editTextIdKartu.getText().toString().trim();
        String outlet = spinnerOutlet.getSelectedItem().toString();
        String topup = spinnerTopup.getSelectedItem().toString().trim();

        int selectedId = transferbank.getCheckedRadioButtonId();
        // mencari id radio button
        radioTransferButton = (RadioButton) findViewById(selectedId);
        String bank = radioTransferButton.getText().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = FirebaseAuth.getInstance().getCurrentUser().getUid();

            //creating an Topup Object
            TopUpModel Topup = new TopUpModel(id, name, topup, code, idkartu, outlet, bank);

            //Saving the Topup
            databaseTopup.child(id).setValue(Topup);

            //setting edittext to blank again
            editTextName.setText("");

            //setting edittext to blank again
            textViewcode.setText("");

            //setting edittext to blank again
            editTextIdKartu.setText("");

            //displaying a success toast
            //Toast.makeText(this, "Pembayaran berhasil", Toast.LENGTH_LONG).show();
            //} else {
            //if the value is not given displaying a toast
            //Toast.makeText(this, "Masukkan nama anda", Toast.LENGTH_LONG).show();
        }

    }

    private String generateString(int lenght){
        char[] chars = "1234567890".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < lenght; i++){
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /** ---------------------------------------------------------------------------------------------------------
     * MEMBUAT NOMOR CODE
     *
     * private String generateString(int lenght){
         char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
         StringBuilder stringBuilder = new StringBuilder();
         Random random = new Random();
         for(int i = 0; i < lenght; i++){
             char c = chars[random.nextInt(chars.length)];
             stringBuilder.append(c);
         }
         return stringBuilder.toString();
     }
     ------------------------------------------------------------------------------------------------------------- **/
}
