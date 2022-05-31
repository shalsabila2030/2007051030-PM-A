package com.example.filestorage;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Helper {

    private static final String TAG = Helper.class.getName();
    static void writeToFile(Model model, Context context) {
        String filename = model.getTitle();
        String fileContents = model.getContent();
        try (FileOutputStream fos = context.openFileOutput(filename,
                Context.MODE_PRIVATE)) {
            fos.write(fileContents.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Writing file failed :", e);
        }
    }
    static Model readFromFile(Context context, String filename) {
        Model model = new Model();
        try {
            FileInputStream fis = context.openFileInput(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fis,
                    StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
            model.setTitle(filename);
            model.setContent(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found :", e);
        } catch (IOException e) {
            Log.e(TAG, "Cannot read file :", e);
        }
        return model;
    }
}

