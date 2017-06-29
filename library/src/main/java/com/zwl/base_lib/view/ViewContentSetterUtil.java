package com.zwl.base_lib.view;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.TextView;

/**
 * Created by hasee on 2017/5/9.
 */

public class ViewContentSetterUtil {

    public static final void setText(View v, String text){
        if(v == null){
            return ;
        }

        if(v instanceof TextView){
            ((TextView) v).setText(text);
        }
    }

    public static final void setText(View rootView, @IdRes int resId, String text){
        if(rootView == null){
            return ;
        }

       setText(rootView.findViewById(resId), text);
    }
}
