package me.maxcostadev.mhwcrowns;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class CrownLoader {

    private static final String PREFS_NAME = "Crowns";

    public static Boolean getCrown(Context ctx, String name, String type) {
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return prefs.getBoolean(name + type, false);
    }

    public static Boolean toggleCrown(Context ctx, String name, String type) {
        SharedPreferences.Editor editor = ctx.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Boolean ret;
        if (!prefs.getBoolean(name + type, false)) {
            editor.putBoolean(name + type, true);
            ret = true;
        } else {
            editor.putBoolean(name + type, false);
            ret = false;
        }
        editor.apply();
        return ret;
    }
}
