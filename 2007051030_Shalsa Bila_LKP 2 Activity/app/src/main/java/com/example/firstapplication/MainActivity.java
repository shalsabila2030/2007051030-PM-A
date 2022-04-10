package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtBase, edtHeight;
    private Button btncalculate;
    private TextView tvresult;
    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtBase = (EditText) findViewById(R.id.edt_base);
        edtHeight = (EditText) findViewById(R.id.edt_height);
        btncalculate = (Button) findViewById(R.id.btn_calculate);
        tvresult = (TextView) findViewById(R.id.tv_result);

        btncalculate.setOnClickListener(this);

        if (savedInstanceState != null ){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvresult.setText(hasil);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String base = edtBase.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(base)) {
                isEmptyFields = true;
                edtBase.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(height)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double b = Double.parseDouble(base);
                double h = Double.parseDouble(height);
                double area =  b * h;
                tvresult.setText(String.valueOf(area));
            }

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, tvresult.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
