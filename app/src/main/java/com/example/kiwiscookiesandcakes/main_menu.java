package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.kiwiscookiesandcakes.MainActivity.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main_menu<isAdmin> extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Button to log-out from main menu
        Button logoutMainMenu = findViewById(R.id.logoutFromMainMenu);
        //Button to go to the add items screen
        Button addItemsButton = findViewById(R.id.addItemsMenuButton);
        //Button to go to inventory status
        Button inventoryStatusButton = findViewById(R.id.inventoryStatusMenuButton);
        //Button to clear inventory
        Button clearInvButton = findViewById(R.id.clearInventoryButton);
        //Button to add 20 test items into inventory
        Button addTestItemsButton = findViewById(R.id.addTestItemButton);
        //Button for if user is admin
        Button isAdminButton = findViewById(R.id.isAdminButton);
        //check to see if button is visible or not

        if (isAdmin == false)
        {
            isAdminButton.setVisibility(View.INVISIBLE);
        }
        else
        {
            isAdminButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent toAdmin = new Intent(getApplicationContext(), Admin_Main_Menu.class);
                    startActivity(toAdmin);
                }
            });
        }

        //Add Items navigation Button
        addItemsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent addItemsNav = new Intent(getApplicationContext(), Add_Item.class);
                startActivity(addItemsNav);
            }
        });

        //Inventory status navigation Button
        inventoryStatusButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent inventoryStatNav = new Intent(getApplicationContext(), inventory_status.class);
                startActivity(inventoryStatNav);
            }
        });

        //Clear inventory
        clearInvButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        //Adding 20 test items to inventory
        addTestItemsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        //Log out
        logoutMainMenu.setOnClickListener(new View.OnClickListener()
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