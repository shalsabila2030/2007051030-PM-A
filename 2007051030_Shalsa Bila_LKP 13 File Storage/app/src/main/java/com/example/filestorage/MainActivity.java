package com.example.filestorage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editContent, editTitle;
    private Button btnClear, btnOpen, btnSave;

    File myExternalFile;
    String myData=" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClear = findViewById(R.id.btn_clear);
        btnOpen = findViewById(R.id.btn_open);
        btnSave = findViewById(R.id.btn_save);

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            btnSave.setEnabled(false);
        } else {
            String filename = "PenyimpananLKPStorage.txt";
            String filepath = "Penyimpanan_Aplikasi";
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }

        editTitle = findViewById(R.id.edit_title);
        editContent = findViewById(R.id.edit_content);
        btnClear.setOnClickListener(this);
        btnOpen.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }
    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState);
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(extStorageState);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_clear) {
            newFile();
        } else if (id == R.id.btn_open) {
            openFile();
        } else if (id == R.id.btn_save) {
            saveFile();
        }
    }

    private void saveFile() {
// buat kondisi ketika field editTitle dan editContent kosong akan memberi peringatan
        if (editTitle.getText().toString().isEmpty()) {
            editTitle.setError("Title is required");
            Toast.makeText(this, "Title is required",
                    Toast.LENGTH_SHORT).show();
        } else if (editContent.getText().toString().isEmpty()) {
            editContent.setError("Content is required");
            Toast.makeText(this, "Content is required",
                    Toast.LENGTH_SHORT).show();
        } else {
            String title = editTitle.getText().toString();
            String text = editContent.getText().toString();
            Model model = new Model();
            model.setTitle(title);
            model.setContent(text);
            Helper.writeToFile(model, this);
            Toast.makeText(this, "Saving file",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void openFile() {
        final CharSequence[] items = fileList();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose file");
        builder.setItems(items, (dialog, item) ->
                loadData(items[item].toString()));
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void loadData(String title) {
        Model model = Helper.readFromFile(this, title);
        editTitle.setText(model.getTitle());
        editContent.setText(model.getContent());
        Toast.makeText(this, "Loading file", Toast.LENGTH_SHORT).show();
    }

    private void newFile() {
        editTitle.setText("");
        editContent.setText("");
        Toast.makeText(this, "Clearing file", Toast.LENGTH_SHORT).show();

    }
}

