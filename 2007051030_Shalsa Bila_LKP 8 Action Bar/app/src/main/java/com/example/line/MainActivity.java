package com.example.line;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.account){
            startActivity(new Intent(this, AccountActivity.class));
        } else if(item.getItemId()==R.id.theme){
            startActivity(new Intent(this, ThemeActivity.class));
        } else if(item.getItemId()==R.id.language){
            startActivity(new Intent(this, LanguageActivity.class));
        }
        return true;
    }
}