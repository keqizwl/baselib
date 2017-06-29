/* 
 *
 * @FileName CLog.java
 * @Description 这里对文件进行描述
 *
 * @author wlf
 * @data 2014-11-20
 * 
 * @note 这里写本文件的详细功能描述和注释
 * @note 历史记录
 * 
 * @warning 这里写本文件的相关警告
 */
package com.zwl.base_lib;

import android.util.Log;

/**
 * 打印信息封装
 *
 * @author weilinfeng
 * @Data 2013-7-18
 */
public final class LLog {
    public static final String LOG_TAG = "kiddub";
    private static final boolean DEBUG = BuildConfig.DEBUG;//开发时候true，其他false

    private LLog() {
    }

    public static void d(String tag, String desc) {
        if (DEBUG) {
            Log.d(tag, desc);
        }
    }

    public static void v(String tag, String desc) {
        if (DEBUG) {
            Log.v(tag, desc);
        }
    }

    public static void w(String tag, String desc) {
        if (DEBUG) {
            Log.w(tag, desc);
        }
    }

    public static void i(String tag, String desc) {
        if (DEBUG) {
            Log.i(tag, desc);
        }
    }

    public static void e(String tag, String desc) {
        if (DEBUG) {
            Log.e(tag, desc);
        }
    }

    public static void e(String tag, String desc, Throwable e) {
        if (DEBUG) {
            Log.e(tag, desc, e);
        }
    }
}
