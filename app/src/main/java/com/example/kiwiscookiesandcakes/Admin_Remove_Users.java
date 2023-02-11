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

public class Admin_Remove_Users<userLog> extends AppCompatActivity {

    //String to be used to store the
    private String userstringRemove;

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
                //Shows Toast message for if their is no users in the database
                if (MainActivity.userLog.entrySet().isEmpty())
                {
                    Toast.makeText(getBaseContext(), "No users are in the database", Toast.LENGTH_LONG).show();
                }
                //Shows toast message for if the input is blank
                else if (removeUserInput.length() == 0)
                {
                    Toast.makeText(getBaseContext(), "Please input a users name first", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    for (String s : MainActivity.userLog.keySet())
                    {
                        userstringRemove = removeUserInput.getText().toString();
                        if (!removeUserInput.getText().toString().equals(s))
                        {
                            //Alert for if user is not in database
                            userNonExist();
                        }
                        else
                        {
                            //Alert for confirmation
                            removeConfirm();
                        }
                    }

                }
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

    private void removeConfirm()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Admin_Remove_Users.this);
        builder.setMessage("Are you sure to remove " + userstringRemove + " for good?").setTitle("Confirm Removal?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                MainActivity.userLog.remove(userstringRemove);
                Toast.makeText(getBaseContext(), "User removed", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
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

    private void userNonExist()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Admin_Remove_Users.this);
        builder.setMessage("User does not exist").setTitle("Does not exist");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
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