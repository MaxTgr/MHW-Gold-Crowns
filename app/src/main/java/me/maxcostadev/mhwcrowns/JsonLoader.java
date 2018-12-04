package me.maxcostadev.mhwcrowns;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import me.maxcostadev.mhwcrowns.model.Monster;

public class JsonLoader {

    public static Monster[] getMonsters(Context context){
        Gson gson = new Gson();
        return gson.fromJson(loadJSONFromAsset(context), Monster[].class);
    }

    private static String loadJSONFromAsset(Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open("monsters.json");
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
