package com.jybrother.zhangbo.sineomvpdemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jybrother.zhangbo.sineomvpdemo.util.ErrorToastUtil;
import com.jybrother.zhangbo.sineomvpdemo.util.ToastUtil;

import static com.jybrother.zhangbo.sineomvpdemo.util.ErrorToastUtil.TOKEN_EXPIRED;

/**
 * Created by zhangbo on 2017/9/14.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private ToastUtil mToastUtil;
    private ErrorToastUtil mErrorToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initToolBar();
        initView();
        initData();
        initListeners();
    }


    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initToolBar();

    protected abstract void initListeners();

    protected abstract void initData();


    protected final void startActivity(@NonNull Class<?> targetActivity) {
        startActivity(new Intent(this, targetActivity));
    }

    protected final void startActivity(@NonNull String name, @NonNull Bundle data, @NonNull Class<?> targetActivity) {
        final Intent intent = new Intent();
        intent.putExtra(name, data);
        intent.setClass(this, targetActivity);
        startActivity(intent);
    }

    protected final void startActivity(@NonNull Bundle data, @NonNull Class<?> targetActivity) {
        final Intent intent = new Intent();
        intent.putExtras(data);
        intent.setClass(this, targetActivity);
        startActivity(intent);
    }

    protected final void startActivityForResult(@NonNull Class<?> targetActivity, int reqeustCode, @NonNull Bundle bundle) {
        final Intent intent = new Intent();

        intent.putExtras(bundle);
        intent.setClass(this, targetActivity);
        startActivityForResult(intent, reqeustCode, bundle);
    }


    protected final void showErrorToast(int errorCode) {
        if (TOKEN_EXPIRED == errorCode) {

        } else {
            if (mErrorToast == null)
                mErrorToast = new ErrorToastUtil();

            mErrorToast.showToast(this, errorCode);
        }
    }

    protected final void showToast(String text) {
        if (mToastUtil == null)
            mToastUtil = new ToastUtil();
        mToastUtil.showToast(this, text);
    }
}
