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

import java.util.List;

public class Admin_Add_Users<userLog> extends AppCompatActivity {

    //Userlogin database
    public static UserLogins userLogins;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_users);

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
                String userString = usernameInput.getText().toString();
                String passString = passwordInput.getText().toString();

                    //Checking that inputs are not blank
                    if (usernameInput.length() == 0 || passwordInput.length() == 0)
                    {
                        Toast.makeText(getBaseContext(), "Please make sure all the text field are not blank", Toast.LENGTH_SHORT).show();
                    }
                    //Checks if users is already in Hashmap
                    else if (MainActivity.userLog.containsKey(usernameInput.getText().toString()))
                    {
                        //Calls method of popup screen
                        userExists();
                        passwordInput.setText("");
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
                        //sets the text to blank to quickly input another if be
                        usernameInput.setText("");
                        passwordInput.setText("");
                    }
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

    private void newUserSuccess()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Admin_Add_Users.this);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(Admin_Add_Users.this);
        builder.setMessage("User already exists");

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