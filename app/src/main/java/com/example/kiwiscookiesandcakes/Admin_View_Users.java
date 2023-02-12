package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.kiwiscookiesandcakes.MainActivity.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Admin_View_Users<userLog> extends AppCompatActivity {

    //Userlogin database
    public static UserLogins userLogins;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_users);

        //Initialise the database
        userLogins = Room.databaseBuilder(getApplicationContext(), UserLogins.class, "userloginsdb").allowMainThreadQueries().build();

        //List to get all the users from the database
        List<Users> allUsers = userLogins.usersDao().getAllUsers();
        for (Users user : allUsers)
        {
            MainActivity.userLog.put(user.getUsername(), user.getPassword());
        }

        //Text views of username and passwords
        TextView userpassTitle = findViewById(R.id.usernamePasswordTextTitle);
        TextView userpassDisplay = findViewById(R.id.usernamesPasswordsDisplay);

        //Strings for setting the information from the users login hashmap
        String userTitle = "";
        String userDisplay = "";

        if (!MainActivity.userLog.entrySet().isEmpty())
        {
            for (String s : MainActivity.userLog.keySet())
            {
                userTitle += "Username:\n\nPassword:\n\n";
                userDisplay += s + "\n\n" + MainActivity.userLog.get(s) + "\n\n";
            }
            userpassTitle.setText(userTitle);
            userpassDisplay.setText(userDisplay);
        }
        else
        {
            userpassTitle.setText("");
            userpassDisplay.setText("");
        }


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