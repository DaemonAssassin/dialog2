package com.gmail.mateendev3.dialogsmarket;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/**
 * Android guide 1st example
 */
public class FireMissilesDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //using dialog
        //AlertDialog dialog = new AlertDialog.Builder(getActivity());

        //using builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.title_dialog_first)
                .setMessage("Wanna Fire missile?")
                .setPositiveButton("Fire", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "You Fired Missile", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "You Cancelled Fire", Toast.LENGTH_SHORT).show();
                    }
                });

        //return dialog;
        return builder.create();
    }
}
