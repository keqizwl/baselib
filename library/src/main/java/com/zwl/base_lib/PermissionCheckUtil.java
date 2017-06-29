package com.zwl.base_lib;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Administrator on 2016/4/17.
 */
public class PermissionCheckUtil {
    public static boolean mayRequestPermission( final View v, final Activity activity, final String permission, final int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        if (activity.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }

        if (activity.shouldShowRequestPermissionRationale(permission)) {
            Snackbar.make(v, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            activity.requestPermissions(new String[]{permission}, requestCode);
                        }
                    });
        } else {
            activity.requestPermissions(new String[]{permission}, requestCode);
        }

        return false;
    }

    public static boolean mayRequestPermission(final View v, final Fragment fragment, final String permission, final int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        if (fragment.getActivity().checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }

        if (fragment.shouldShowRequestPermissionRationale(permission)) {
            Snackbar.make(v, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            fragment.requestPermissions(new String[]{permission}, requestCode);
                        }
                    });
        } else {
            fragment.requestPermissions(new String[]{permission}, requestCode);
        }

        return false;
    }

    public static boolean isPermissionGranted(@NonNull int grantResult) {
        if (grantResult == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
}
