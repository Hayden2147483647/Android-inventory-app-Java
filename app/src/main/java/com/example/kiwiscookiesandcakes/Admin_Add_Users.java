package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin_Add_Users extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_users);

        //Edit text for input of username and password
        EditText usernameInput = findViewById(R.id.usernameEditTextAddUser);
        EditText passwordInput = findViewById(R.id.passwordEditTextAddUsers);

        //Add user button
        Button addUserButton = findViewById(R.id.addUserButton);
        //Button to go back to Admin main menu
        Button adminMainMenuButton = findViewById(R.id.mainMenuFromAddUser);
        //Button to go to the view users page
        Button viewUsersButton = findViewById(R.id.viewUsersFromAddUser);

        //Add user while checking inputs are suffice
        addUserButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //TODO add in check from input
                //TODO add in Toast or pop-up for if input is empty of username exists
            }
        });

        //Navigate to View Users
        viewUsersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent viewUsers = new Intent(getApplicationContext(), Admin_View_Users.class);
                startActivity(viewUsers);
            }
        });

        //navigate to Admin main menu
        adminMainMenuButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent adminmenu = new Intent(getApplicationContext(), Admin_Main_Menu.class);
                startActivity(adminmenu);
            }
        });
    }
}