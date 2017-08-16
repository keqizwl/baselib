package com.zwl.base_lib.view.toolbar;

import android.support.annotation.ColorRes;
import android.support.annotation.MenuRes;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zwl.base_lib.view.ParamsNullChecker;


/**
 * Created by hasee on 2016/9/23.
 */
public class ToolbarHelper {

    public static void setPrimaryToolbar(Toolbar toolbar, int icoBack, String tilte, @ColorRes int titleColor, View.OnClickListener onClickListener) {
        if (ParamsNullChecker.checkHasNull(toolbar)) {
            return;
        }
        if (icoBack != 0) {
            toolbar.setNavigationIcon(icoBack);//设置导航栏图标
        }
        toolbar.setTitle(tilte);
        toolbar.setTitleTextColor(toolbar.getResources().getColor(titleColor));
        toolbar.setNavigationOnClickListener(onClickListener);
    }

    public static void setPrimaryToolbar(Toolbar toolbar, int icoNav, String tilte, @ColorRes int titleColor, String subTitle, @ColorRes int subTitleColor, View.OnClickListener onClickListener) {
        if (ParamsNullChecker.checkHasNull(toolbar)) {
            return;
        }
        if (icoNav != 0) {
            toolbar.setNavigationIcon(icoNav);//设置导航栏图标
        }
        toolbar.setTitle(tilte);//设置主标题
        toolbar.setSubtitle(subTitle);//设置子标题
        toolbar.setTitleTextColor(toolbar.getResources().getColor(titleColor));
        toolbar.setSubtitleTextColor(toolbar.getResources().getColor(subTitleColor));
        toolbar.setNavigationOnClickListener(onClickListener);
    }

    public static void setPrimaryToolbar(Toolbar toolbar, int icoNav, String tilte, @ColorRes int ttleColor, View.OnClickListener onClickListener, @MenuRes int menuId, Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        if (ParamsNullChecker.checkHasNull(toolbar)) {
            return;
        }
        if (icoNav != 0) {
            toolbar.setNavigationIcon(icoNav);//设置导航栏图标
        }
        toolbar.setTitle(tilte);//设置主标题
        toolbar.setNavigationOnClickListener(onClickListener);
        toolbar.inflateMenu(menuId);//设置右上角的填充菜单
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    private ToolbarHelper() {

    }
}
