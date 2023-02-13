package com.example.kiwiscookiesandcakes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import androidx.room.Room;

import org.junit.Test;

import java.util.HashMap;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MainUnitTests
{


    @Test
    public void addition_isCorrect()
    {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void userObject()
    {
        assertNotNull(Users.class);
        assertNotNull(Inventory.class);
    }

    @Test
    public void testaddUser()
    {
        Users user = new Users();
        user.setUsername("testname");
        user.setPassword("testpass");
        assertEquals("testname", user.getUsername());
        assertEquals("testpass", user.getPassword());
    }

    @Test
    public void testaddInventory()
    {
        Inventory inventory = new Inventory();
        inventory.setItemname("Chocolate");
        inventory.setQuantity(12);
        inventory.setItemtype("Cake");
        assertEquals("Chocolate", inventory.getItemname());
        assertEquals(12, inventory.getQuantity());
        assertEquals("Cake", inventory.getItemtype());
    }

    @Test
    public void testUserisempty()
    {
        Users user = new Users();
        HashMap<String, String> userLog = new HashMap<>();
        user.setUsername("testname");
        user.setPassword("testpass");
        userLog.put(user.getUsername(),user.getPassword());
        assertFalse(userLog.entrySet().isEmpty());
    }
}