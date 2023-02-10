package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin_Remove_Users extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_remove_users);

        //edit text for what users to delete
        EditText removeUserInput = findViewById(R.id.removeUserEditText);

        //Button to confirm the removal of entered users
        Button removeUserButton = findViewById(R.id.removeUserButton);
        //Button to return to Admin main menu
        Button adminMainMenuButton = findViewById(R.id.mainMenuFromRemoveUser);
        //Button to go to View Users
        Button viewUsersNavButton = findViewById(R.id.viewUsersFromRemoveUsers);


        //Removal of user check and confirm
        removeUserButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //TODO add in the check for deleting user and show a Toast of pop-up message to confirm
            }
        });

        //Navigate to view users
        viewUsersNavButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent viewUsersNav = new Intent(getApplicationContext(), Admin_View_Users.class);
                startActivity(viewUsersNav);
            }
        });

        //back to admin main menu
        adminMainMenuButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent mainMenu = new Intent(getApplicationContext(), Admin_Main_Menu.class);
                startActivity(mainMenu);
            }
        });
    }
}