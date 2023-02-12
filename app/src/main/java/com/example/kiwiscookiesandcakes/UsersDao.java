package com.example.kiwiscookiesandcakes;


import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface UsersDao
{
    @Insert
    public void addUser(Users user);

    @Query("SELECT * FROM UserLogins")
    public List<Users> getAllUsers();

    @Query("DELETE FROM UserLogins WHERE Username= :username")
    abstract void deleteByUsername(String username);
}
