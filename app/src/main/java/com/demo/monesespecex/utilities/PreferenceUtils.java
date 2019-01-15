package com.demo.monesespecex.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.demo.monesespecex.App;
import com.google.gson.Gson;

public class PreferenceUtils {

    public static final String PREF_NAME = "app_data";
    public final static String PREF_KEYS_ROCKET_RESPONSE = "RocketResponse";

    public static synchronized final void insertString(String key, String value) {
        getPreferences().edit().putString(key, value).commit();
    }

    public synchronized static final void remove(String key) {
        getPreferences().edit().remove(key).commit();
    }

    public synchronized static final String getString(String key) {
        return getPreferences().getString(key, null);
    }

    public static synchronized final void insertBoolean(String key, boolean value) {
        getPreferences().edit().putBoolean(key, value).commit();
    }

    public synchronized static final boolean getBoolean(String key) {
        return getPreferences().getBoolean(key, false);
    }

    public static synchronized final void insertInteger(String key, Integer value) {
        getPreferences().edit().putInt(key, value).commit();
    }

    public synchronized static final Integer getInteger(String key) {
        return getPreferences().getInt(key, 0);
    }

    public synchronized static final boolean contains(String key) {
        return getPreferences().contains(key);
    }

    public synchronized static final SharedPreferences getPreferences() {
        return App.getInstance().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized final void insertObject(String key, Object model) {
        getPreferences().edit().putString(key, new Gson().toJson(model))
                .commit();
    }

    public static synchronized final Object getObject(String key, Class<?> modelClass) {
        return new Gson().fromJson(getPreferences().getString(key, null),
                modelClass);
    }

}
