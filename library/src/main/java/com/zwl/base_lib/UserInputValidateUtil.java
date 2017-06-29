package com.zwl.base_lib;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by hasee on 2017/5/9.
 */

public class UserInputValidateUtil {
    String passwordReg = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";

    public boolean isEmail(String input){
        if(TextUtils.isEmpty(input)){
            return false;
        }

        return Patterns.EMAIL_ADDRESS.matcher(input).find();
    }

    public boolean isValiablePhoneNum(String input){
        if(TextUtils.isEmpty(input)){
            return false;
        }

        return Patterns.PHONE.matcher(input).find();
    }

    public boolean isValiableWebUrl(String input){
        if(TextUtils.isEmpty(input)){
            return false;
        }

        return Patterns.WEB_URL.matcher(input).find();
    }

    public boolean isValiablePassword(String input){
        if(TextUtils.isEmpty(input)){
            return false;
        }

        return Pattern.matches(passwordReg, input);
    }
}
