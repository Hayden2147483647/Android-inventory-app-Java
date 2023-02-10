package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Edit texts for the username and password
        EditText usernameInput = findViewById(R.id.editTextUsernameLogin);
        EditText passwordInput = findViewById(R.id.editTextPasswordLogin);

        //Button for moving to the Create account screen
        Button createAccountNavigationButton = findViewById(R.id.createAccountButton);

        //Button to sign in
        Button signinButton = findViewById(R.id.signinButton);

        //sign in verification
        signinButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        createAccountNavigationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent createAcc = new Intent(getApplicationContext(), createaccount.class);
                startActivity(createAcc);
            }
        });

    }
}