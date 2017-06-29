package com.zwl.base_lib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by hasee on 2017/4/15.
 */

public class CommonIntentUtil {
    public void gotoRateUs(Context context) {
        if (context == null) {
            return;
        }

        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
        } catch (Exception e) {

        }
    }

    public static void gotoSend(Context context, String content) {
        if(context == null || TextUtils.isEmpty(content)){
            return;
        }

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("text/*");
        sendIntent.putExtra(Intent.EXTRA_TEXT, content);
        context.startActivity(sendIntent);
    }

}
