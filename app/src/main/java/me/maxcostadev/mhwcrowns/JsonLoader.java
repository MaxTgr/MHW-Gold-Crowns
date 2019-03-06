package me.maxcostadev.mhwcrowns;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import me.maxcostadev.mhwcrowns.model.Monster;

public class JsonLoader {

    private static final String MAIN_JSON = "monsters.json";

    public static ArrayList<Monster> getMonsters(Context context) {
        Gson gson = new Gson();

        Monster[] arr = gson.fromJson(loadJSONFromAsset(context), Monster[].class);

        return new ArrayList<>(Arrays.asList(arr));
    }

    private static String loadJSONFromAsset(Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(MAIN_JSON);
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
