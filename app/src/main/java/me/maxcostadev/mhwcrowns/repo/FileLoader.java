package me.maxcostadev.mhwcrowns.repo;

import android.content.Context;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import me.maxcostadev.mhwcrowns.model.Monster;

public class FileLoader {

    private static final String MAIN_JSON = "monsters.json";

    public static ArrayList<Monster> getFileData() {
        Gson gson = new Gson();

        Monster[] arr = gson.fromJson(loadJSONFromFile(), Monster[].class);

        return new ArrayList<>(Arrays.asList(arr));
    }

    private static String loadJSONFromFile() {
        String json;

        try {
            String currentDir = new File("").getAbsolutePath();
            InputStream is = new FileInputStream(currentDir + "/src/main/assets/" + MAIN_JSON);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }

}
