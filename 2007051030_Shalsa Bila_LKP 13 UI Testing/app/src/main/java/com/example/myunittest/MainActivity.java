package com.example.myunittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.myunittest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        mainViewModel = new MainViewModel(new TabungModel());

        activityMainBinding.btnSave.setOnClickListener(this);
        activityMainBinding.btnCalculateSurfaceArea.setOnClickListener(this);
        activityMainBinding.btnCalculateCircumference.setOnClickListener(this);
        activityMainBinding.btnCalculateVolume.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String length = activityMainBinding.edtLength.getText().toString().trim();
        String height = activityMainBinding.edtHeight.getText().toString().trim();
        if (TextUtils.isEmpty(length)) {
            activityMainBinding.edtLength.setError("Field ini tidak boleh kosong");
        } else if (TextUtils.isEmpty(height)) {
            activityMainBinding.edtHeight.setError("Field ini tidak boleh kosong");
        } else {
            double valueLength = Double.parseDouble(length);
            double valueHeight = Double.parseDouble(height);
            if (v.getId() == R.id.btn_save) {
                mainViewModel.hitung(valueLength, valueHeight);
                visible();
            } else if (v.getId() == R.id.btn_calculate_circumference) {
                activityMainBinding.tvResult.setText(String.valueOf(mainViewModel.luasSelimut()));
                gone();
            } else if (v.getId() == R.id.btn_calculate_surface_area) {
                activityMainBinding.tvResult.setText(String.valueOf(mainViewModel.luasTabung()));
                gone();
            } else if (v.getId() == R.id.btn_calculate_volume) {
                activityMainBinding.tvResult.setText(String.valueOf(mainViewModel.volume()));
                gone();
            }
        }
    }
    private void visible() {
        activityMainBinding.btnCalculateVolume.setVisibility(View.VISIBLE);
        activityMainBinding.btnCalculateCircumference.setVisibility(View.VISIBLE);
        activityMainBinding.btnCalculateSurfaceArea.setVisibility(View.VISIBLE);
        activityMainBinding.btnSave.setVisibility(View.GONE);
    }
    private void gone() {
        activityMainBinding.btnCalculateVolume.setVisibility(View.GONE);
        activityMainBinding.btnCalculateCircumference.setVisibility(View.GONE);
        activityMainBinding.btnCalculateSurfaceArea.setVisibility(View.GONE);
        activityMainBinding.btnSave.setVisibility(View.VISIBLE);
    }
}

