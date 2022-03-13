package com.example.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.accountfragment.CallbackFragment;


public class AccountFragment extends Fragment {
    EditText edtUsername, edtPassword;
    Button  btnRegister;
    CallbackFragment callbackFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        edtUsername = view.findViewById(R.id.edt_username);
        edtPassword = view.findViewById(R.id.edt_password);
        btnRegister = view.findViewById(R.id.btn_register);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    public void setCallbackFragment (CallbackFragment callbackFragment){
        this.callbackFragment = callbackFragment ;
    }
}
