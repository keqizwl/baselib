package com.zwl.base_lib;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;


/**
 * 保存序列化对象到本地文件或者基本数据类型到sharedPreference
 */
public class PreferenceUtils {
    private static Application context;

    public static void init(Application application) {
        context = application;
    }

    public static void saveStringToSharePrefs(String fileName, String key, String value) {
        if (context == null || TextUtils.isEmpty(fileName) || TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return;
        }

        SharedPreferences preferences = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getStringFromSharePrefs(String fileName, String key, String defaultValue) {
        if (context == null || TextUtils.isEmpty(fileName) || TextUtils.isEmpty(key)) {
            return defaultValue;
        }

        SharedPreferences preferences = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preferences.getString(key, defaultValue);
    }

    public static void saveIntToSharePrefs(String fileName, String key, int value) {
        if (context == null || TextUtils.isEmpty(fileName) || TextUtils.isEmpty(key)) {
            return;
        }

        SharedPreferences preferences = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getIntFromSharePrefs(String fileName, String key, int defaultValue) {
        if (context == null || TextUtils.isEmpty(fileName) || TextUtils.isEmpty(key)) {
            return defaultValue;
        }

        SharedPreferences preferences = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preferences.getInt(key, defaultValue);
    }

    public static long getLongFromSharePrefs(String fileName, String key, long defaultValue) {
        if (context == null || TextUtils.isEmpty(fileName) || TextUtils.isEmpty(key)) {
            return defaultValue;
        }

        SharedPreferences preferences = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preferences.getLong(key, defaultValue);
    }

    public static void saveLongToSharePrefs(String fileName, String key, long value) {
        if (context == null || TextUtils.isEmpty(fileName) || TextUtils.isEmpty(key)) {
            return;
        }

        SharedPreferences preferences = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

}
