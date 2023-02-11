package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kiwiscookiesandcakes.MainActivity.*;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class createaccount<userLog> extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

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
                while (!MainActivity.userLog.entrySet().isEmpty())
                {
                        //Checking that inputs are not blank
                        if (usernameInput.length() == 0 || passwordInput.length() == 0)
                        {
                            Toast.makeText(getBaseContext(), "Please make sure all the text field are not blank", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        //Checking that if re-enter password does not match with the password input
                        else if (!repasswordInput.getText().toString().equals(passwordInput.getText().toString()))
                        {
                            Toast.makeText(getBaseContext(), "Please make sure both password are entered in correctly", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        //Checks if users is already in Hashmap
                        else if (MainActivity.userLog.containsKey(usernameInput.getText().toString()))
                        {
                            //Calls method of popup screen
                            userExists();
                            break;
                        }
                        //Success
                        else
                        {
                            MainActivity.userLog.put(userString, passString);
                            //Calls method of popup screen for success
                            newUserSuccess();
                            break;
                        }
                }
                //Checking that inputs are not blank
                if (usernameInput.length() == 0 || passwordInput.length() == 0)
                {
                    Toast.makeText(getBaseContext(), "Please make sure all the text field are not blank", Toast.LENGTH_SHORT).show();
                }
                //Checking that if re-enter password does not match with the password input
                else if (!repasswordInput.getText().toString().equals(passwordInput.getText().toString()))
                {
                    Toast.makeText(getBaseContext(), "Please make sure both password are entered in correctly", Toast.LENGTH_SHORT).show();
                    //Clears re-enter password field
                    repasswordInput.setText("");
                }
                //Success
                else
                {
                    MainActivity.userLog.put(userString, passString);
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