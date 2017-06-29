/*
 * Copyright 2012 GitHub Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zwl.base_lib;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Utilities for displaying toast notifications
 */
public class ToastUtils {

    public static void show(Context context, int resId, int duration) {
        show(context, context.getString(resId), duration);
    }

    public static void show(Context context, String message) {
        show(context, message, Toast.LENGTH_SHORT);
    }

    public static void show(Context context, int resId) {
        show(context, context.getString(resId));
    }


    private static void show(Context context, String message, int duration) {
        if (message == null) {
            return;
        }

        if (context == null) {
            return;
        }

        String beforeMsg = "";
        long beforeTime = 0;
        if (message.equals(beforeMsg) && (System.currentTimeMillis() - beforeTime) < 2000) {
            return;
        }


        Toast toast = Toast.makeText(context, null, duration);
        toast.setView(getTextView(context, message));
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private static TextView getTextView(Context context, String str) {
        TextView textView = new TextView(context);
        int padding = DisplayUtil.dp2px(context, 10);
        textView.setPadding(padding, padding, padding, padding);
        textView.setTextColor(Color.WHITE);
//        textView.setBackgroundResource(R.drawable.shape_toast_bg);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        textView.setText(str);
        textView.setGravity(Gravity.CENTER);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(params);
        return textView;
    }
}
