package com.zwl.base_lib;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 提供基础的文件路径服务，参考android官网实现
 *
 * @author velen
 * @date 2017/4/6
 */
public final class FileStorageUtils {

    /**
     * 卸载被删
     *
     * @param context
     * @return
     */
    public static final FileOutputStream openInternalPrivateFileOutputStream(Context context, String fileName) {
        try {
            return context.openFileOutput(fileName, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 卸载被删
     *
     * @param context
     * @return
     */
    public static final FileOutputStream openInternalPrivateFileAppendOutputStream(Context context, String fileName) {
        if (context == null || TextUtils.isEmpty(fileName)) {
            return null;
        }

        try {
            return context.openFileOutput(fileName, Context.MODE_APPEND);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 卸载被删
     *
     * @param context
     * @return
     */
    public static final File getInternalCacheDir(Context context) {
        if (context == null) {
            return null;
        }

        return context.getCacheDir();
    }

    /**
     * * 卸载不刪
     *
     * @param
     * @return
     */
    public static final File getExternalPublicMusicFileDir() {
        return Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_MUSIC);
    }

    /**
     * * 卸载不刪
     *
     * @param
     * @return
     */
    public static final File getExternalPublicPicturesFileDir() {
        return Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
    }

    /**
     * * 卸载不刪
     *
     * @param
     * @return
     */
    public static final File getExternalPublicRingTonesFileDir() {
        return Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_RINGTONES);
    }

    /**
     * * 卸载不刪
     *
     * @param context
     * @return
     */
    public static final Intent getExternalPublicMusicFileDirIntent(Context context) {
        if (context == null) {
            return null;
        }

        return getExternalPublicDirIntent(context, Environment.DIRECTORY_MUSIC);
    }

    /**
     * * 卸载不刪
     *
     * @param context
     * @return
     */
    public static final Intent getExternalPublicPicturesFileDirIntent(Context context) {
        return getExternalPublicDirIntent(context, Environment.DIRECTORY_PICTURES);
    }

    /**
     * * 卸载不刪
     *
     * @param context
     * @return
     */
    public static final Intent getExternalPublicRingTonesFileDirIntent(Context context) {
        return getExternalPublicDirIntent(context, Environment.DIRECTORY_RINGTONES);
    }

    @Nullable
    private static Intent getExternalPublicDirIntent(final Context context, String type) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StorageManager sm = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
            StorageVolume volume = sm.getPrimaryStorageVolume();
            Intent intent = volume.createAccessIntent(type);
            return intent;
        } else {
            return null;
        }
    }

    /**
     * 从 Android 4.4 开始，读取或写入应用私有目录中的文件不再需要 READ_EXTERNAL_STORAGE 或 WRITE_EXTERNAL_STORAGE 权限。 因此，您可以通过添加 maxSdkVersion 属性来声明，只能在较低版本的 Android 中请求该权限：
     * <p>
     * <manifest ...>
     * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"
     * android:maxSdkVersion="18" />
     * ...
     * </manifest>
     * <p>
     * 卸载被删
     *
     * @return
     */
    public static final File[] getExternalPrivateFileDir(Context context, String type) {
        if (context == null || type == null) {
            return null;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return context.getExternalFilesDirs(type);
        } else {
            return ContextCompat.getExternalFilesDirs(context, type);
        }
    }

    /**
     * * 卸载被删
     *
     * @param context
     * @param type
     * @return
     */
    public static final File[] getExternalPrivateCacheFileDir(Context context, String type) {
        if (context == null || type == null) {
            return null;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return context.getExternalCacheDirs();
        } else {
            return ContextCompat.getExternalCacheDirs(context);
        }
    }

    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }


    private FileStorageUtils() {

    }
}
