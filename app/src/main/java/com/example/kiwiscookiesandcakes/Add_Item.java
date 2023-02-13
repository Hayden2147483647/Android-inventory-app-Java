package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Add_Item extends AppCompatActivity {

    //Inventory Status database
    public static InventoryStatDB inventoryStat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //Initialise the database
        inventoryStat = Room.databaseBuilder(getApplicationContext(), InventoryStatDB.class, "inventoryStatdb").allowMainThreadQueries().build();

        //Edit text for item name and quantity
        EditText itemNameInput = findViewById(R.id.itemNameEditText);
        EditText itemQuantityInput = findViewById(R.id.itemQuantityEditText);

        //Radio button for type of item
        RadioButton biscuitRadioInput = findViewById(R.id.biscuitRadio);
        RadioButton cookieRadioInput = findViewById(R.id.cookieRadio);
        RadioButton cakeRadioInput = findViewById(R.id.cakeRadio);
        RadioButton ingredientRadioInput = findViewById(R.id.ingredientRadio);
        RadioButton otherRadioInput = findViewById(R.id.otherRadio);

        //Button to go back to the main menu
        Button mainMenuButton = findViewById(R.id.toMainMenuFromAddItem);
        //Button to add item into inventory
        Button addItemButton = findViewById(R.id.addItemButton);
        //Button to go to the inventory status
        Button invStatButton = findViewById(R.id.inventoryStatFromAddButton);

        //New inventory class object for inserting an item
        Inventory newItem = new Inventory();

        /* In Future maintenance, having a check condition for if an item is already in the database.
         * If an item is in the database, an option should show up saying if they wish to modify it
         */


        //Adding in item while checking from all the input types
        addItemButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String typeString = "";
                //Checking that inputs are not empty
                if (itemNameInput.length() == 0 || itemQuantityInput.length() == 0)
                {
                    Toast.makeText(getBaseContext(), "Both input fields have to be filled out before submittin", Toast.LENGTH_SHORT).show();
                }
                //Checks quantity input isn't less than zero
                else if (Integer.parseInt(itemQuantityInput.getText().toString()) <= 0)
                {
                    Toast.makeText(getBaseContext(), "Quantity cannot be less than zero", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Setting the type string to which ever radio button is pressed
                    if (biscuitRadioInput.isChecked())
                    {
                        typeString = "Biscuit";
                    }
                    else if (cookieRadioInput.isChecked())
                    {
                        typeString = "Cookie";
                    }
                    else if (cakeRadioInput.isChecked())
                    {
                        typeString = "Cake";
                    }
                    else if (ingredientRadioInput.isChecked())
                    {
                        typeString = "Ingredient";
                    }
                    else
                    {
                        typeString = "Other";
                    }
                    //code for putting item in database here
                    //Setting item name, quantity and type to inventory object
                    newItem.setItemname(itemNameInput.getText().toString());
                    newItem.setQuantity(Integer.parseInt(itemQuantityInput.getText().toString()));
                    newItem.setItemtype(typeString);
                    //adding item into inventory
                    inventoryStat.dao().addInventory(newItem);
                    //pop up for the success of item input
                    itemSuccess();
                    //Clears the input fields
                    itemNameInput.setText("");
                    itemQuantityInput.setText("");
                }
            }
        });

        //navigate to inventory status
        invStatButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent invStat = new Intent(getApplicationContext(), inventory_status.class);
                startActivity(invStat);
            }
        });

        //navigate to main menu
        mainMenuButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent mainMenu = new Intent(getApplicationContext(), main_menu.class);
                startActivity(mainMenu);
            }
        });
    }

    private void itemSuccess()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Add_Item.this);
        builder.setMessage("Item added successfully!");

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
}