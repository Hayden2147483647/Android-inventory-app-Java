package com.example.kiwiscookiesandcakes;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Users.class}, version = 1)
public abstract class UserLogins extends RoomDatabase
{
    public abstract UsersDao usersDao();
}
