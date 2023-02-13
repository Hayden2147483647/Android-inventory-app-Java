package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import static com.example.kiwiscookiesandcakes.MainActivity.*;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class main_menu<isAdmin> extends AppCompatActivity {

    //Inventory Status database
    public static InventoryStatDB inventoryStat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Initialise the database
        inventoryStat = Room.databaseBuilder(getApplicationContext(), InventoryStatDB.class, "inventoryStatdb").allowMainThreadQueries().build();


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

        //New inventory class object for inserting an item
        Inventory testItems = new Inventory();

        //In future maintenance, having a screen/button to modify items to save time and repeats into the database

        //arrays for storing test items name, quantity and type
        String[] itemArrayName = {"Chocolate", "Vanilla", "Biscoff", "Oreo", "Pipette", "Strawberry", "MarshMellow", "Icing", "Vanilla Essence", "Tea", "Coffee", "Milo", "Sugar", "Flour", "Eggs", "Baking Soda", "Spatula", "Bowl", "Butter", "Bread"};
        int[] itemArrayQuantity = {23, 45, 100, 24, 3, 16, 84, 54, 12, 4, 6, 9, 40, 30, 12, 60, 4, 2, 15, 3};
        String[] itemArrayType = {"Cake", "Cake", "Biscuit", "Cookie", "Other", "Ingredient", "Ingredient", "Ingredient", "Ingredient", "Ingredient", "Cake", "Ingredient", "Cookie", "Ingredient", "Ingredient", "Ingredient", "Other", "Other", "Ingredient", "Ingredient",};

        //check to see if button is visible or not
        //Calls the isAdmin boolean to see whether or not the user has administrative properties
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
        /*In Future maintenance have a screen for selecting individual items
         *to be deleted from the inventory instead of all
         */
        clearInvButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Confirm Delete all inventory
                confirmDeleteAll();
            }
        });

        //Adding 20 test items to inventory
        addTestItemsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //For loop for going through the arrays and assigning them to the inventory class object
                for (int i = 0; i < itemArrayName.length; i++)
                {
                    testItems.setItemname(itemArrayName[i]);
                    testItems.setQuantity(itemArrayQuantity[i]);
                    testItems.setItemtype(itemArrayType[i]);
                    inventoryStat.dao().addInventory(testItems);
                }
                //Message to user saying test items have been added
                Toast.makeText(getBaseContext(), "20 Test items have been added to the inventory", Toast.LENGTH_SHORT).show();
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

    private void confirmDeleteAll()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(main_menu.this);
        builder.setMessage("Do you wish to delete all from Inventory?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                inventoryStat.dao().deleteAllInventory();
                dialog.dismiss();
                Toast.makeText(getBaseContext(), "Inventory Deleted", Toast.LENGTH_LONG).show();
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
}