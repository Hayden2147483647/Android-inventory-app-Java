package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class inventory_status extends AppCompatActivity {

    //Inventory Status database
    public static InventoryStatDB inventoryStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_status);

        //Initialise the database
        inventoryStat = Room.databaseBuilder(getApplicationContext(), InventoryStatDB.class, "inventoryStatdb").allowMainThreadQueries().build();

        //Button to go back to the main menu
        Button mainMenuButton = findViewById(R.id.mainMenufromInvStat);

        //Text views for both item labels and its display
        TextView itemLabelView = findViewById(R.id.itemsLabelsTextView);
        TextView itemDisplayView = findViewById(R.id.itemsDisplayTextView);

        //Buttons previous and next
        Button previousButton = findViewById(R.id.previousButton);
        Button nextButton = findViewById(R.id.nextButton);



        //return to main menu
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