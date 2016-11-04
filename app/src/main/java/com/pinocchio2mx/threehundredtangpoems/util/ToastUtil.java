package com.pinocchio2mx.threehundredtangpoems.util;

import android.content.Context;
import android.widget.Toast;

import static android.support.v7.widget.AppCompatDrawableManager.get;

/**
 * Created by pinocchio2mx on 2016/10/30.
 */

public class ToastUtil {
    private static Toast toast = null;


    public static void showToast(Context context, CharSequence text,int duration) {
        if (toast == null) {
            toast = Toast.makeText(context, text, duration);
        } else {
            toast.setText(text);
        }
        toast.show();
    }
}
