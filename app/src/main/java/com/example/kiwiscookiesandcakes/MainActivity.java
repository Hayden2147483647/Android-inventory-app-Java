package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

    //Boolean for if user is admin
    public static Boolean isAdmin = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Edit texts for the username and password
        EditText usernameInput = findViewById(R.id.editTextUsernameLogin);
        EditText passwordInput = findViewById(R.id.editTextPasswordLogin);

        //Button for moving to the Create account screen
        final Button createAccountNavigationButton = findViewById(R.id.createAccountButton);

        //Button to sign in
        final Button signinButton = findViewById(R.id.signinButton);

        //array for storing usernames and passwords for logging in
        String[] usernames = new String[100];
        String[] passwords = new String[100];

            do
            {
                //TODO add in data structure for logins(e.g. arrays, linked list, Hashmap). NOTE not from file
            }
            while ();//TODO fix loop so it reads all contents


        //sign in verification
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int x = 0; x < passwords.length; x++) {
                    String userString = usernames[x];
                    String passString = passwords[x];
                    if (usernameInput.getText().toString().equals(userString) && passwordInput.getText().toString().equals(passString)) {
                        Intent userSignIn = new Intent(getApplicationContext(), main_menu.class);
                        startActivity(userSignIn);
                        isAdmin = false;
                        break;
                    } else if (usernameInput.getText().toString().equals("Admin") && passwordInput.getText().toString().equals("CookieManagement84")) {
                        Intent adminSignIn = new Intent(getApplicationContext(), Admin_Main_Menu.class);
                        startActivity(adminSignIn);
                        isAdmin = true;
                        break;
                    } else if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                        Inputempty();
                        break;
                    } else {
                        //pop up for if both inputs are not blank and isn't a user login
                        Toast.makeText(getBaseContext(), "Username and Password is not a login.\nIf you have forgotten you login, please contact the customer support team\nElse, create a new account", Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });

        createAccountNavigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createAcc = new Intent(getApplicationContext(), createaccount.class);
                startActivity(createAcc);
            }
        });

    }



    //pop up message saying to the user that at least one input is blank
    private void Inputempty()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Please make sure both inputs are filled in").setTitle("Empty field");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}