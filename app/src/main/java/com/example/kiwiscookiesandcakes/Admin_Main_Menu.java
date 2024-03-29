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
        Button toUsermenuButton = findViewById(R.id.userMenuFromAdminMenu);
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

        /* In future maintenance, having a dynamically animation
         * of when the button is pressed showing up with all the menus
         * navigation options so that it minimises the user going from screen to screen
         */

        //Normal user menu navigation
        toUsermenuButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent userMenu = new Intent(getApplicationContext(), main_menu.class);
                startActivity(userMenu);
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