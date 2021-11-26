package com.gmail.mateendev3.dialogsmarket;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/**
 * Android Docs second example (Traditional Single Choice List)
 */
public class TraditionalSingleChoice extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String[] colors = {"Red", "Green", "Blue"};

        //We can also use builder object and return dialog at the end
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Select Color")
                .setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String color = colors[which];
                        Toast.makeText(getActivity(),
                                "You Choose " + color,
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .create();

        return dialog;
    }
}
