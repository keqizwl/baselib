/*
 * *
 *  Copyright (c) 2015. Dingtone, inc. All rights reserved.
 * /
 */

package com.zwl.base_lib.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.Selection;
import android.text.Spannable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.zwl.base_lib.view.recyclerview.itemdecoration.HorizontalDividerItemDecoration;
import com.zwl.base_lib.view.recyclerview.itemdecoration.VerticalDividerItemDecoration;

/**
 * @author velen
 * @date 2016/8/11
 */
public class ViewUtils {

    public static final void setEditTextSelection(EditText edittext, int postion) {
        if (edittext == null || edittext.getText().length() <= postion) {
            return;
        }

        CharSequence text = edittext.getText();
        if (text instanceof Spannable) {
            Spannable spanText = (Spannable) text;
            Selection.setSelection(spanText, text.length());
        }
    }

    public static void hideInput(Activity activity) {
        if (activity == null || activity.getCurrentFocus() == null) {
            return;
        }

        ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static void showInput(View view, Activity activity) {
        view.requestFocus();
        ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static final void addHorizonDecorationToRecyclerView(RecyclerView recyclerView, int color, int width) {
        if (recyclerView == null) {
            return;
        }

        Paint paint = new Paint();
        paint.setStrokeWidth(width);
        paint.setColor(color);
        paint.setAntiAlias(true);
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(recyclerView.getContext())
                .paint(paint)
                .build());
    }

    public static final void addVerticalDecorationToRecyclerView(RecyclerView recyclerView, int color, int width) {
        if (recyclerView == null) {
            return;
        }

        Paint paint = new Paint();
        paint.setStrokeWidth(width);
        paint.setColor(color);
        paint.setAntiAlias(true);
        recyclerView.addItemDecoration(new VerticalDividerItemDecoration.Builder(recyclerView.getContext())
                .paint(paint)
                .build());
    }
}
