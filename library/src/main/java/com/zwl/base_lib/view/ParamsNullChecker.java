package com.zwl.base_lib.view;

import java.util.Collection;
import java.util.List;

/**
 * Created by hasee on 2017/5/9.
 */

public class ParamsNullChecker {
    public static boolean checkHasNull(Object... object){
        if(object == null){
            return false;
        }

        boolean hasNull = false;
        for(Object o : object){
            if(o == null){
                hasNull = true;
                break;
            }

            if(o instanceof Collection){
               if( ((List) o).isEmpty() ){
                   hasNull = true;
                   break;
               }
            }
        }

        return hasNull;
    }
}
