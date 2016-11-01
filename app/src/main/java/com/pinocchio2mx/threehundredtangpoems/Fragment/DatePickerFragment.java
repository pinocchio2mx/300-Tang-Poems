package com.pinocchio2mx.threehundredtangpoems.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import com.pinocchio2mx.threehundredtangpoems.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date,null);
        return  new AlertDialog.Builder(getActivity())
                .setTitle("Date")
                .setView(v)
                .setPositiveButton(android.R.string.ok,null)
                .create();

    }
}
