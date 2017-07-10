package com.redmadrobot.tinkoffnews.ui.global;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.redmadrobot.tinkoffnews.R;

/**
 * Created by s.salnikov on 10/07/17
 */
public class ProgressDialog extends DialogFragment {
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, R.style.ProgressDialogStyle);
        setCancelable(false);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             final Bundle savedInstanceState) {
        return new ProgressBar(getContext());
    }
}
