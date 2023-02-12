package com.example.kiwiscookiesandcakes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "InventoryStat")
public class Inventory
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Inventory ID")
    private int id;

    @ColumnInfo(name = "Item")
    private String itemname;

    @ColumnInfo(name = "Quantity")
    private int quantity;

    @ColumnInfo(name = "Type")
    private String itemtype;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getItemname()
    {
        return itemname;
    }

    public void setItemname(String itemname)
    {
        this.itemname = itemname;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getItemtype()
    {
        return itemtype;
    }

    public void setItemtype(String itemtype)
    {
        this.itemtype = itemtype;
    }
}
