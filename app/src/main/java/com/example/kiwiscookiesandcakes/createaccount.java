package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.kiwiscookiesandcakes.MainActivity.*;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class createaccount<userLog> extends AppCompatActivity
{
    //Userlogin database
    public static UserLogins userLogins;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        //Initialise the database
        userLogins = Room.databaseBuilder(getApplicationContext(), UserLogins.class, "userloginsdb").allowMainThreadQueries().build();

        //List to get all the users from the database
        List<Users> allUsers = userLogins.usersDao().getAllUsers();
        for (Users user : allUsers)
        {
            MainActivity.userLog.put(user.getUsername(), user.getPassword());
        }

        //Creating new users object
        Users newUser = new Users();

        //Edit texts for username, password, and re-enter password
        EditText usernameInput = findViewById(R.id.editTextUsernameCreateAcc);
        EditText passwordInput = findViewById(R.id.editTextPasswordCreateAcc);
        EditText repasswordInput = findViewById(R.id.editTextRe_enterPassword);

        //Create account button
        Button createAccButton = findViewById(R.id.createAccButtonConfirm);

        //Button for canceling out of the screen back to the login screen
        Button cancelToLogin = findViewById(R.id.cancelCreateAccButton);


        //Create account button with check on input from above edit texts
        createAccButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String userString = usernameInput.getText().toString();
                String passString = passwordInput.getText().toString();
                        //Checking that inputs are not blank
                        if (usernameInput.length() == 0 || passwordInput.length() == 0)
                        {
                            Toast.makeText(getBaseContext(), "Please make sure all the text field are not blank", Toast.LENGTH_SHORT).show();
                        }
                        //Checking that if re-enter password does not match with the password input
                        else if (!repasswordInput.getText().toString().equals(passwordInput.getText().toString()))
                        {
                            Toast.makeText(getBaseContext(), "Please make sure both password are entered in correctly", Toast.LENGTH_SHORT).show();
                        }
                        //Checks if users is already in Hashmap
                        else if (MainActivity.userLog.containsKey(usernameInput.getText().toString()))
                        {
                            //Calls method of popup screen
                            userExists();
                        }
                        //Success
                        else
                        {
                            MainActivity.userLog.put(userString, passString);
                            //setting user name and password to user object
                            newUser.setUsername(userString);
                            newUser.setPassword(passString);
                            //Inserting user login detail into database
                            userLogins.usersDao().addUser(newUser);
                            //Calls method of popup screen for success
                            newUserSuccess();
                            //Clears inputs
                            usernameInput.setText("");
                            passwordInput.setText("");
                            repasswordInput.setText("");
                        }
            }
        });

        //Navigate back to login screen
        cancelToLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent cancel = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(cancel);
            }
        });


    }

    private void newUserSuccess()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(createaccount.this);
        builder.setMessage("User added Successfully");

        builder.setPositiveButton("Dismiss", new DialogInterface.OnClickListener()
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

    private void userExists()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(createaccount.this);
        builder.setMessage("user already exists");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
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