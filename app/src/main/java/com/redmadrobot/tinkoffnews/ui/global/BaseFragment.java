package com.redmadrobot.tinkoffnews.ui.global;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.ButterKnife;

/**
 * Created by s.salnikov on 08/07/17
 */
public abstract class BaseFragment extends MvpAppCompatFragment {
    private static final String PROGRESS_DIALOG_TAG = "progress_dialog_tag";
    private static final String MESSAGE_DIALOG_TAG = "message_dialog";

    @LayoutRes
    protected abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    protected void showProgressDialog(Boolean progress) {
        final Fragment fragment = getChildFragmentManager().findFragmentByTag(PROGRESS_DIALOG_TAG);
        if (fragment != null && !progress) {
            ((ProgressDialog) fragment).dismiss();
            getChildFragmentManager().executePendingTransactions();
        } else if (fragment == null && progress) {
            new ProgressDialog().show(getChildFragmentManager(), PROGRESS_DIALOG_TAG);
            getChildFragmentManager().executePendingTransactions();
        }
    }

    protected void showMessageDialog(String msg) {

    }

    public void onBackPressed() {
    }
}
