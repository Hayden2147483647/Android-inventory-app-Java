package com.example.kiwiscookiesandcakes;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Inventory.class}, version = 1)
public abstract class InventoryStatDB extends RoomDatabase
{
    public abstract InventoryDao dao();
}
