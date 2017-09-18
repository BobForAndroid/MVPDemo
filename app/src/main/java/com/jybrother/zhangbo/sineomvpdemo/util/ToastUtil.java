package com.jybrother.zhangbo.sineomvpdemo.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhangbo on 2017/9/14.
 */

public class ToastUtil {
    private Toast mToast;
    public void showToast(Context context, String text){
        if (null == mToast){
            mToast=Toast.makeText(context,text,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public void cancelToast(){
        if (mToast != null){
            mToast.cancel();
        }
    }


    public static void show(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }

    public static void show(Context context, int info) {
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }
}
