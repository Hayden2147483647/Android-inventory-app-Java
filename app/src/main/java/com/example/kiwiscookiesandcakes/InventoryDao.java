package com.example.kiwiscookiesandcakes;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface InventoryDao
{
    @Insert
    public void addInventory(Inventory inventory);

    @Query("SELECT * FROM InventoryStat")
    public List<Inventory> getAllInventory();

    @Query("DELETE FROM InventoryStat")
    public void deleteAllInventory();
}
