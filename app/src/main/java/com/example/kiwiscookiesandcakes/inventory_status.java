package com.example.kiwiscookiesandcakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.stream.Collectors;

public class inventory_status extends AppCompatActivity {

    //Inventory Status database
    public static InventoryStatDB inventoryStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_status);

        //Initialise the database
        inventoryStat = Room.databaseBuilder(getApplicationContext(), InventoryStatDB.class, "inventoryStatdb").allowMainThreadQueries().build();

        //List to get all the inventory from the database
        List<Inventory> allInvList = inventoryStat.dao().getAllInventory();

        //Button to go back to the main menu
        Button mainMenuButton = findViewById(R.id.mainMenufromInvStat);

        //Text views for both item labels and its display
        TextView itemLabelView = findViewById(R.id.itemsLabelsTextView);
        TextView itemDisplayView = findViewById(R.id.itemsDisplayTextView);
        //String to set the text of the display and label of the textviews
        final String[] labelString = {""};
        final String[] displayString = {""};

        //Buttons previous and next
        Button previousButton = findViewById(R.id.previousButton);
        Button nextButton = findViewById(R.id.nextButton);
        
        //String and int array to store list item labels
        String[] itemNameArray = new String[allInvList.size()];
        int[] itemQuantityArray = new int[allInvList.size()];
        String[] itemTypeArray = new String[allInvList.size()];

        //Integer for the "for" loops
        int x = 0;

            //"for" loop to only display the first five items
            for (Inventory inv : allInvList)
            {
                //Format for the label text
                //Getting item name, quantity and types and adding it to the arrays
                itemNameArray[x] = inv.getItemname();
                itemQuantityArray[x] = inv.getQuantity();
                itemTypeArray[x] = inv.getItemtype();
                x++;
            }
            for (int j = 0; j < 5; j++)
            {
                //Format for the display text
                labelString[0] += "Item:\nQuantity:\nType:\n\n";
                displayString[0] += itemNameArray[j] + "\n" + itemQuantityArray[j] + "\n" + itemTypeArray[j] + "\n\n";
                //Setting the text view of both the label and display to the string values above
                itemLabelView.setText(labelString[0]);
                itemDisplayView.setText(displayString[0]);
            }


        //integer for page number for previous and next buttons
        final int[] pageNum = {1};

        //Previous Button
        previousButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Resets the strings that will be used to set the textviews' text
                labelString[0] = "";
                displayString[0] = "";

                pageNum[0]--;
                //Sets the next button to be enabled when previous has been pressed
                nextButton.setEnabled(true);
                nextButton.setClickable(true);
                for (int p = ((5 * pageNum[0])-5); p < (5 * pageNum[0]); p++)
                {
                    //Format for the display text
                    labelString[0] += "Item:\nQuantity:\nType:\n\n";
                    displayString[0] += itemNameArray[p] + "\n" + itemQuantityArray[p] + "\n" + itemTypeArray[p] + "\n\n";
                    //Setting the text view of both the label and display to the string values above
                    itemLabelView.setText(labelString[0]);
                    itemDisplayView.setText(displayString[0]);
                }
                //disables the button when it it on the first page
                if (pageNum[0] <= 1)
                {
                    previousButton.setEnabled(false);
                    previousButton.setClickable(false);
                }
                //Makes the button enabled when not on page one
                else
                {
                    previousButton.setEnabled(true);
                    previousButton.setClickable(true);
                }
            }
        });

        //Next button
        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Sets the previous to be enabled when clicking next
                previousButton.setEnabled(true);
                previousButton.setClickable(true);
                //Resets the strings that will be used to set the textviews' text
                labelString[0] = "";
                displayString[0] = "";

                pageNum[0]++;
                for (int n = ((5*pageNum[0])-4); n <= (5 * pageNum[0]); n++)
                {
                    //Disables the button when it is on its last page
                    if ((pageNum[0] * 5) >= allInvList.size())
                    {
                        nextButton.setEnabled(false);
                        nextButton.setClickable(false);
                    }
                    else if (itemNameArray[n].isEmpty())
                    {
                        labelString[0] += "";
                        displayString[0] += "";
                        itemLabelView.setText(labelString[0]);
                        itemDisplayView.setText(displayString[0]);
                    }
                    else
                    {
                        //Format for the display text
                        labelString[0] += "Item:\nQuantity:\nType:\n\n";
                        displayString[0] += itemNameArray[n] + "\n" + itemQuantityArray[n] + "\n" + itemTypeArray[n] + "\n\n";
                        //Setting the text view of both the label and display to the string values above
                        itemLabelView.setText(labelString[0]);
                        itemDisplayView.setText(displayString[0]);
                    }
                }

            }
        });

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