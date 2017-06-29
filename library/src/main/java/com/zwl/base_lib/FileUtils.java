package com.zwl.base_lib;

import android.text.TextUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author velen
 * @date 2017/4/6
 */
public class FileUtils {

    public static File createFile(String dir, String fileName) {
        if (TextUtils.isEmpty(dir) || TextUtils.isEmpty(fileName)) {
            return null;
        }

        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(dir, fileName);
    }

    public static void copyFile(File from, File to) {
        if (from == null || to == null) {
            return;
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(from);
            inputStream = new BufferedInputStream(inputStream);
            outputStream = new BufferedOutputStream(new FileOutputStream(to));
            byte[] buffer = new byte[4096];
            int readCount = 0;
            while ((readCount = inputStream.read(buffer, 0, buffer.length)) > 0) {
                outputStream.write(buffer, 0, readCount);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private FileUtils() {
    }

}
