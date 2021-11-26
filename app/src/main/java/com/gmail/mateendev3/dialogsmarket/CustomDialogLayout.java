package com.gmail.mateendev3.dialogsmarket;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;

public class CustomDialogLayout extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //View v = LayoutInflater.from(getActivity()).inflate(R.layout.custom_dialog_layout, null);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setView(inflater.inflate(R.layout.custom_dialog_layout, null))
                .create();

        return dialog;
    }
}
