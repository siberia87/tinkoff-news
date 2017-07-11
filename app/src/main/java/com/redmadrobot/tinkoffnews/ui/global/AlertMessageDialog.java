package com.redmadrobot.tinkoffnews.ui.global;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redmadrobot.tinkoffnews.R;

import java.io.Serializable;

/**
 * Created by s.salnikov on 10/07/17
 */
public class AlertMessageDialog extends DialogFragment {
    private static final String ARGS_ID = "args_id";
    private static final String ARGS_TITLE = "args_title";
    private static final String ARGS_MESSAGE = "args_message";
    private static final String ARGS_PRIMARY_BT = "args_primary";
    private static final String ARGS_SECONDARY_BT = "args_secondary";
    private static final String ARGS_DATA = "args_data";

    public static AlertMessageDialog newInstance(int id,
                                                 Context context,
                                                 String title,
                                                 String message,
                                                 String primaryButton,
                                                 String secondaryButtonText,
                                                 Serializable data) {
        AlertMessageDialog alertMessageDialog = new AlertMessageDialog();

        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_ID, id);
        bundle.putString(ARGS_TITLE, title);
        bundle.putString(ARGS_MESSAGE, message);
        bundle.putString(ARGS_PRIMARY_BT, primaryButton);
        bundle.putString(ARGS_SECONDARY_BT, secondaryButtonText);
        bundle.putSerializable(ARGS_DATA, data);
        alertMessageDialog.setArguments(bundle);

        return alertMessageDialog;
    }

    interface ClickListener {
        void onPrimaryDialogButtonClick(AlertMessageDialog dialog);

        void onSecondaryDialogButtonClick(AlertMessageDialog dialog);
    }

    private ClickListener clickListener;

    int dialogId = getArguments().getInt(ARGS_ID);
    Serializable data = getArguments().getSerializable(ARGS_DATA);

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        if (getParentFragment() instanceof ClickListener)
            clickListener = (ClickListener) getParentFragment();
        else if (getActivity() instanceof ClickListener)
            clickListener = (ClickListener) getActivity();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getContext(), R.style.AlertDialogStyle);
        View view = View.inflate(getContext(), R.layout.layout_alert_message, null);
        ((TextView) view.findViewById(R.id.alertTitleTextView)).setText(getArguments().getString(ARGS_TITLE));
        ((TextView) view.findViewById(R.id.alertPrimaryButton)).setText(getArguments().getString(ARGS_PRIMARY_BT));
        ((TextView) view.findViewById(R.id.alertSecondaryButton)).setText(getArguments().getString(ARGS_SECONDARY_BT));

        String message = getArguments().getString(ARGS_MESSAGE);
        if (message != null && !message.trim().isEmpty()) {
            ((TextView) view.findViewById(R.id.alertMessageTextView)).setText(getArguments().getString(ARGS_MESSAGE));
            view.findViewById(R.id.alertMessageTextView).setVisibility(View.VISIBLE);
        }
        dialog.setContentView(view, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        dialog.setCancelable(true);

        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getDialog().findViewById(R.id.alertPrimaryButton).setOnClickListener(v -> {
            dismiss();
            if (clickListener != null) {
                clickListener.onPrimaryDialogButtonClick(this);
            }
        });

        getDialog().findViewById(R.id.alertSecondaryButton).setOnClickListener(v -> {
            dismiss();
            if (clickListener != null) {
                clickListener.onSecondaryDialogButtonClick(this);
            }
        });
    }
}
