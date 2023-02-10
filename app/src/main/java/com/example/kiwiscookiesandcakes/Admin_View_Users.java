package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Admin_View_Users extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_users);

        //Text views of username and passwords
        TextView userpassTitle = findViewById(R.id.usernamePasswordTextTitle);
        TextView userpassDisplay = findViewById(R.id.usernamesPasswordsDisplay);

        //TODO add in how the it will displayed

        //Button to return to admin main menu
        Button adminMainMenu = findViewById(R.id.mainMenuFromViewUsers);
        //Button to go to Add Users
        Button addUsersNavButton = findViewById(R.id.addUserFromViewUsers);
        //Button to go to Remove Users
        Button removeUsersNavButton = findViewById(R.id.removeUsersFromViewUsers);

        //Navigate to Add User
        addUsersNavButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent addUsersNav = new Intent(getApplicationContext(), Admin_Add_Users.class);
                startActivity(addUsersNav);
            }
        });

        //Navigate to Remove Users
        removeUsersNavButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent removeUsersNav = new Intent(getApplicationContext(), Admin_Remove_Users.class);
                startActivity(removeUsersNav);
            }
        });

        //Return to Admin main menu
        adminMainMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent adminMenu = new Intent(getApplicationContext(), Admin_Main_Menu.class);
                startActivity(adminMenu);
            }
        });
    }
}