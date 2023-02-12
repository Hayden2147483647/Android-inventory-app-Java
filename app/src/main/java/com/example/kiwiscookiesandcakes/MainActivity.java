package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

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
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{
    //Userlogin database
    public static UserLogins userLogins;

    //Boolean for if user is admin
    public static Boolean isAdmin = false;

    //Hashmap data structure for user logins
    public static HashMap<String, String> userLog = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialise the database
        userLogins = Room.databaseBuilder(getApplicationContext(), UserLogins.class, "userloginsdb").allowMainThreadQueries().build();

        //List to get all the users from the database
        List<Users> allUsers = userLogins.usersDao().getAllUsers();
        for (Users user : allUsers)
        {
            userLog.put(user.getUsername(), user.getPassword());
        }

        //Edit texts for the username and password
        EditText usernameInput = findViewById(R.id.editTextUsernameLogin);
        EditText passwordInput = findViewById(R.id.editTextPasswordLogin);

        //Button for moving to the Create account screen
        final Button createAccountNavigationButton = findViewById(R.id.createAccountButton);

        //Button to sign in
        final Button signinButton = findViewById(R.id.signinButton);

        //sign in verification
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                while (!userLog.entrySet().isEmpty())
                {
                    for (String x : userLog.keySet())
                    {
                        String userString = x;
                        String passString = userLog.get(x);
                        //Username and password matches up with the hashmap values and logs user in
                        if (usernameInput.getText().toString().equals(userString) && passwordInput.getText().toString().equals(passString))
                        {
                            Intent userSignIn = new Intent(getApplicationContext(), main_menu.class);
                            startActivity(userSignIn);
                            isAdmin = false;
                            break;
                        }
                        //Username and password match admin login details and takes the user to the admin page
                        else if (usernameInput.getText().toString().equals("Admin") && passwordInput.getText().toString().equals("CookieManagement84"))
                        {
                            Intent adminSignIn = new Intent(getApplicationContext(), Admin_Main_Menu.class);
                            startActivity(adminSignIn);
                            isAdmin = true;
                            break;
                        }
                        //If either text field is left blank shows up with and appropriate message
                        else if (usernameInput.length() == 0 || passwordInput.length() == 0)
                         {
                            //Calls the pop up message method from down below
                            Inputempty();
                            break;
                        }
                    }
                    break;
                }
                //Username and password match admin login details and takes the user to the admin page
                if (usernameInput.getText().toString().equals("Admin") && passwordInput.getText().toString().equals("CookieManagement84"))
                {
                    Intent adminSignIn = new Intent(getApplicationContext(), Admin_Main_Menu.class);
                    startActivity(adminSignIn);
                    isAdmin = true;
                }
                else
                {
                    //pop up for if both inputs are not blank and isn't a user login
                    Toast.makeText(getBaseContext(), "Username and Password is not a login.\nIf you have forgotten you login, please contact the customer support team\nElse, create a new account", Toast.LENGTH_LONG).show();
                    //Clears inputs
                    usernameInput.setText("");
                    passwordInput.setText("");
                }
            }
        });

        createAccountNavigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
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

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
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