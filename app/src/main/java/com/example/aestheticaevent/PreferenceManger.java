package com.example.aestheticaevent;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManger {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    public PreferenceManger(Context context) {
        sharedPreferences = context.getSharedPreferences(VariableBag.KEY_ref,MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public  Boolean getLogInSession(String key, boolean b) {
        return sharedPreferences.getBoolean(key,b);
    }

}

