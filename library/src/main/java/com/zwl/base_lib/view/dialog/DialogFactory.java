package com.zwl.base_lib.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.zwl.base_lib.R;


/**
 * Created by hasee on 2016/11/3.
 */

public class DialogFactory {
    public static Dialog createBottomDialog(Context context, View contentView) {
        Dialog dialog = new Dialog(context, R.style.BottomDialog);
        dialog.setContentView(contentView);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        lp.width = dm.widthPixels;//让dialog的宽占满屏幕的宽
        lp.gravity = Gravity.BOTTOM;//出现在底部
        window.setAttributes(lp);

        return dialog;
    }

    public static Dialog createCenterDialog(Context context, View contentView) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(contentView);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        lp.width = dm.widthPixels;//让dialog的宽占满屏幕的宽
        lp.gravity = Gravity.CENTER;//出现在底部
        window.setAttributes(lp);
        return dialog;
    }

    private DialogFactory() {

    }
}
