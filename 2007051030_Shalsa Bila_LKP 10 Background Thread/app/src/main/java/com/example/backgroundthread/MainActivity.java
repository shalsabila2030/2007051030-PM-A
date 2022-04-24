package com.example.backgroundthread;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler objHandler = new Handler() {
        @SuppressLint("HandlerLeak")
        public void handleMesssage(Message msg){
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonclicked(View view) {

        Runnable objRunnable = new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(10000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                objHandler.sendEmptyMessage(0);

            }
        };

        Thread objBgThread = new Thread(objRunnable);
        objBgThread.start();


        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("2007051030 Kelas A!");
    }
}