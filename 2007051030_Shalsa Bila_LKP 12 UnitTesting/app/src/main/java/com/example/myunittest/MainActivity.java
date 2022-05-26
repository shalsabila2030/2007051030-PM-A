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
        mainViewModel = new MainViewModel(new CuboidModel());
        activityMainBinding.btnSave.setOnClickListener(this);
        activityMainBinding.btnCalculateEm.setOnClickListener(this);
        activityMainBinding.btnCalculateEk.setOnClickListener(this);
        activityMainBinding.btnCalculateEp.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        String massa = activityMainBinding.edtMassa.getText().toString().trim();
        String percepatan = activityMainBinding.edtPercepatan.getText().toString().trim();
        String tinggi = activityMainBinding.edtTinggi.getText().toString().trim();
        String kecepatan = activityMainBinding.edtKecepatan.getText().toString().trim();
        if (TextUtils.isEmpty(massa)) {
            activityMainBinding.edtMassa.setError("Field ini tidak boleh kosong");
            } else if (TextUtils.isEmpty(percepatan)) {
            activityMainBinding.edtPercepatan.setError("Field ini tidak boleh kosong");
            } else if (TextUtils.isEmpty(kecepatan)) {
            activityMainBinding.edtTinggi.setError("Field ini tidak boleh kosong");
            } else if (TextUtils.isEmpty(kecepatan)) {
            activityMainBinding.edtKecepatan.setError("Field ini tidak boleh kosong");
            } else {
            double valueMassa = Double.parseDouble(massa);
            double valuePercepatan = Double.parseDouble(percepatan);
            double valueTinggi = Double.parseDouble(tinggi);
            double valueKecepatan = Double.parseDouble(kecepatan);
            if (v.getId() == R.id.btn_save) {
                mainViewModel.save(valueMassa, valuePercepatan, valueTinggi, valueKecepatan);
                visible();
                } else if (v.getId() == R.id.btn_calculate_ek) {
                activityMainBinding.tvResult.setText(String.valueOf(mainViewModel.getEP()));
                gone();
                } else if (v.getId() == R.id.btn_calculate_em) {
                activityMainBinding.tvResult.setText(String.valueOf(mainViewModel.getEM()));
                gone();
                } else if (v.getId() == R.id.btn_calculate_ep) {
                activityMainBinding.tvResult.setText(String.valueOf(mainViewModel.getEK()));
                gone();
                }
            }
        }
        private void visible() {
        activityMainBinding.btnCalculateEk.setVisibility(View.VISIBLE);
        activityMainBinding.btnCalculateEp.setVisibility(View.VISIBLE);
        activityMainBinding.btnCalculateEm.setVisibility(View.VISIBLE);
        activityMainBinding.btnSave.setVisibility(View.GONE);
        }
        private void gone() {
        activityMainBinding.btnCalculateEk.setVisibility(View.GONE);
        activityMainBinding.btnCalculateEp.setVisibility(View.GONE);
        activityMainBinding.btnCalculateEm.setVisibility(View.GONE);
        activityMainBinding.btnSave.setVisibility(View.VISIBLE);
        }
}
