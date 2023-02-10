package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class createaccount extends AppCompatActivity
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
                //TODO: add in checks
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
}