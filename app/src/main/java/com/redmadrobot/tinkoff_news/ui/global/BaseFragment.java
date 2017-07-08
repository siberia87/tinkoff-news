package com.redmadrobot.tinkoff_news.ui.global;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

/**
 * Created by s.salnikov on 08/07/17
 */
abstract class BaseFragment extends MvpAppCompatFragment {

    @LayoutRes
    protected abstract Integer getLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }
}