package com.redmadrobot.tinkoff_news.ui.global;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.arellomobile.mvp.MvpAppCompatActivity;

/**
 * Created by s.salnikov on 08/07/17
 */
public abstract class BaseActivity extends MvpAppCompatActivity {

    @LayoutRes
    protected abstract Integer getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }
}
