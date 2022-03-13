package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{

    private EditText bilA, bilB;
    private ImageButton tambah, kurang, kali, bagi;
    private TextView hasil;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bilA = (EditText) findViewById(R.id.bilanganA);
        bilB = (EditText) findViewById(R.id.bilanganB);
        tambah = (ImageButton) findViewById(R.id.btn_plus);
        kurang = (ImageButton) findViewById(R.id.btn_min);
        kali = (ImageButton) findViewById(R.id.btn_mul);
        bagi = (ImageButton) findViewById(R.id.btn_div);
        hasil = (TextView) findViewById(R.id.hasil);
        search = (Button) findViewById(R.id.btn_search);

        bilA.setOnClickListener(this);
        bilB.setOnClickListener(this);
        tambah.setOnClickListener(this);
        kurang.setOnClickListener(this);
        kali.setOnClickListener(this);
        bagi.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.btn_plus) {
            String bilanganA = bilA.getText().toString().trim();
            String bilanganB = bilB.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(bilanganA)) {
                isEmptyFields = true;
                bilA.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(bilanganB)) {
                isEmptyFields = true;
                bilB.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                Integer a = Integer.parseInt(bilanganA);
                Integer b = Integer.parseInt(bilanganB);
                Integer c = a + b;
                hasil.setText(String.valueOf(c));
                i = new Intent(this, MoveForResultActivity.class);
                i.putExtra("hasil", hasil.getText().toString());
                i.putExtra("ket", "HASIL PENJUMLAHAN");
                startActivity(i);
            }
        } else if (view.getId() == R.id.btn_min) {
            String bilanganA = bilA.getText().toString().trim();
            String bilanganB = bilB.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(bilanganA)) {
                isEmptyFields = true;
                bilA.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(bilanganB)) {
                isEmptyFields = true;
                bilB.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields){
                Integer a = Integer.parseInt(bilanganA);
                Integer b = Integer.parseInt(bilanganB);
                Integer c = a-b;
                hasil.setText(String.valueOf(c));
                i = new Intent(this, MoveForResultActivity.class);
                i.putExtra("hasil", hasil.getText().toString());
                i.putExtra("ket", "HASIL PENGURANGAN");
                startActivity(i);
            }
        }
        else if (view.getId() == R.id.btn_mul){
            String bilanganA = bilA.getText().toString().trim();
            String bilanganB = bilB.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(bilanganA)){
                isEmptyFields = true;
                bilA.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(bilanganB)) {
                isEmptyFields = true;
                bilB.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields){
                Integer a = Integer.parseInt(bilanganA);
                Integer b = Integer.parseInt(bilanganB);
                Integer c = a*b;
                hasil.setText(String.valueOf(c));
                i = new Intent(this, MoveForResultActivity.class);
                i.putExtra("hasil", hasil.getText().toString());
                i.putExtra("ket", "HASIL PERKALIAN");
                startActivity(i);
            }
        }
        else if (view.getId() == R.id.btn_div){
            String bilanganA = bilA.getText().toString().trim();
            String bilanganB = bilB.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(bilanganA)){
                isEmptyFields = true;
                bilA.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(bilanganB)) {
                isEmptyFields = true;
                bilB.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields){
                Double a = Double.parseDouble(bilanganA);
                Double b = Double.parseDouble(bilanganB);
                Double c = a/b;
                hasil.setText(String.valueOf(c));
                i = new Intent(this, MoveForResultActivity.class);
                i.putExtra("hasil", hasil.getText().toString());
                i.putExtra("ket", "HASIL PEMBAGIAN");
                startActivity(i);
            }
        }

        else {
            i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
            startActivity(i);
        }
    }



}

