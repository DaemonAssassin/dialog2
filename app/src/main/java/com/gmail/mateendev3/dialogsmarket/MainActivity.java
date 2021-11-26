package com.gmail.mateendev3.dialogsmarket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Android Docs Dialogs Guide
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiating Buttons
        Button showDialog1 = findViewById(R.id.show_dialog_1);
        Button showDialog2 = findViewById(R.id.show_dialog_2);
        Button showDialog3 = findViewById(R.id.show_dialog_3);
        Button showDialog4 = findViewById(R.id.show_dialog_4);
        Button showDialog5 = findViewById(R.id.show_dialog_5);


        //Applying click listeners to buttons
        showDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                //ya ye karlo
                FireMissilesDialogFragment dialog = new FireMissilesDialogFragment();
                dialog.show(getSupportFragmentManager(), "FIRE_MISSILE");
                */

                //ya ye karlo
                Dialog dialog1 = showDialog1();
                dialog1.show();

            }
        });
        showDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                //Ya yay karlo
                TraditionalSingleChoice dialog = new TraditionalSingleChoice();
                dialog.show(getSupportFragmentManager(), "CHOOSE_COLOR");
                */

                //Ya yay karlo
                AlertDialog dialog1 = showDialog2();
                dialog1.show();
            }
        });
        showDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                //Ya yay karlo
                PersistentMultipleChoice dialog = new PersistentMultipleChoice();
                dialog.show(getSupportFragmentManager(), "CHOOSE_SAUCE");
                */

                //Ya yay karlo
                Dialog dialog1 = showDialog3();
                dialog1.show();

            }
        });
        showDialog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /*
               //Ya ye karlo
                PersistentSingleChoice dialog = new PersistentSingleChoice();
                dialog.show(getSupportFragmentManager(), "CHOOSE_GENDER");
                */

               //Ya yay karlo
                Dialog dialog = showDialog4();
                dialog.show();
            }
        });
        showDialog5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Ya yay karlo
                CustomDialogLayout dialog = new CustomDialogLayout();
                dialog.show(getSupportFragmentManager(), "CUSTOM_LAYOUT");

                /*
                //Ya yay karlo
                AlertDialog dialog1 = showDialog5();
                dialog1.show();
                */
            }
        });
    }

    private Dialog showDialog1() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Launch Missile")
                .setMessage("Wanna Launch missile")
                .setPositiveButton("Launch", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You launched missile", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You cancelled launch", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();

        return dialog;
    }
    private AlertDialog showDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Select Game")
                .setItems(R.array.games, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String game = getResources().getStringArray(R.array.games)[which];
                        Toast.makeText(MainActivity.this,
                                "You choose " + game,
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        return builder.create();
    }
    private AlertDialog showDialog3() {

        final String[] car = {""};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Select Car")
                .setMultiChoiceItems(R.array.cars, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        car[0] = getResources().getStringArray(R.array.cars)[which];
                        Toast.makeText(MainActivity.this, "You selected : " + car[0], Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "You bought : " + car[0],
                                Toast.LENGTH_SHORT)
                                .show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();

        return dialog;
    }
    private Dialog showDialog4() {
        String[] genders = {"Male", "Female", "Both", "I don't know"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Gender")
                .setSingleChoiceItems(genders, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You are : " + genders[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(true);

        return builder.create();
    }
    private AlertDialog showDialog5() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setView(inflater.inflate(R.layout.custom_dialog_layout, null));

        return builder.create();
    }
}