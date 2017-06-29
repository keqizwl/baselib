package com.zwl.base_lib.view;

import android.view.View;
import android.widget.TextView;

/**
 * Created by hasee on 2017/5/9.
 */

public class ViewContentGetterUtil {

    public static final String getText(View v){
        if(v == null){
            return "";
        }

        if(v instanceof TextView){
           if( ((TextView) v).getText() != null){
               return ((TextView) v).getText().toString();
           }
        }

        return "";
    }
}
