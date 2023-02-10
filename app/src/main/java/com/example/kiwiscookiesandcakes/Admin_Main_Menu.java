package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Main_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_menu);

        //All Buttons from the admin main menu
        Button addUserButton = findViewById(R.id.addUsersButton);
        Button viewUsersButton = findViewById(R.id.viewUsersButton);
        Button removeUsersButton = findViewById(R.id.removeUsersButton);
        Button invStatButton = findViewById(R.id.invStatFromAdminMenu);
        Button logoutButton = findViewById(R.id.logoutFromAdminMenu);

        //Add user navigation
        addUserButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent addUsers = new Intent(getApplicationContext(), Admin_Add_Users.class);
                startActivity(addUsers);
            }
        });

        //view users navigation
        viewUsersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent viewUsers = new Intent(getApplicationContext(), Admin_View_Users.class);
                startActivity(viewUsers);
            }
        });

        //Remove user navigation
        removeUsersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent removeUsers = new Intent(getApplicationContext(), Admin_Remove_Users.class);
                startActivity(removeUsers);
            }
        });

        //inventory status navigation
        invStatButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent invStat = new Intent(getApplicationContext(), inventory_status.class);
                startActivity(invStat);
            }
        });

        //Log out navigation
        logoutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent logout = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(logout);
            }
        });
    }
}