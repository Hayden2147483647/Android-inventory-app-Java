package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Add_Item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        //Edit text for item name and quantity
        EditText itemNameInput = findViewById(R.id.itemNameEditText);
        EditText itemQuantityInout = findViewById(R.id.itemQuantityEditText);

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


        //Adding in item while checking from all the input types
        addItemButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //TODO Add in checking from inputs and inserting into the inventory database
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
}