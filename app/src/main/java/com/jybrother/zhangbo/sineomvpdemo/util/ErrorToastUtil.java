package com.jybrother.zhangbo.sineomvpdemo.util;

import android.content.Context;
import android.widget.Toast;

import com.jybrother.zhangbo.sineomvpdemo.R;

/**
 * Created by zhangbo on 2017/9/14.
 */

public class ErrorToastUtil {
    private Toast mToast;
    private int text;
    public static final int NO_NETWORK = 10000;
    public static final int NETWORK_TIMEOUT = 10001;
    public static final int SERVER_EXCEPTION = 10002;
    public static final int OTHER_EXCEPTION = 10003;
    public static final int JSON_EXCEPTION = 10004;

    public static final int TOKEN_EXPIRED = 20000;

    public void showToast(Context context, int code) {
        switch (code) {
            case SERVER_EXCEPTION:
                text = R.string.server_exception;
                break;
            case NETWORK_TIMEOUT:
            case NO_NETWORK:
                text = R.string.timeout_exception;
                break;
            case OTHER_EXCEPTION:
                text = R.string.other_exception;
                break;
            default:
                text = R.string.other_exception;
                break;

        }
        if (null == mToast) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}
