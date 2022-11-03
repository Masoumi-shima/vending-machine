/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sm.vending.machine.dao;

import com.sm.vending.machine.dto.Items;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author melpomene
 */
public class VendingMachineDaoImplTest
{
    VendingMachineDao testDao;

    public VendingMachineDaoImplTest()
    {
    }
    
    @BeforeEach
    public void setUp() throws IOException
    {
        String testFile = "test-machine.txt";
        new FileWriter(testFile);
        testDao = new VendingMachineDaoImpl(testFile);
    }
    
    @Test
    public void testAddGetItem() throws VendingMachineDaoException
    {
        String name = "Oreo";
        BigDecimal price = new BigDecimal("1.2");
        int amount = 7;
        Items item = new Items(name, price, amount);
        testDao.addItem(item);
        Items retrievedItem = testDao.getItem(name);
        
        assertEquals(item.getName(), 
                retrievedItem.getName(), "cheking item's name");
        assertEquals(item.getCost(), 
                retrievedItem.getCost(), "cheking item's price");
        assertEquals(item.getAmountOfItems(),
                retrievedItem.getAmountOfItems(), "cheking amount of items");
    }
    
    @Test
    public void testUpdateInventory() throws VendingMachineDaoException
    {
        String name = "Oreo";
        BigDecimal price = new BigDecimal("1.2");
        int amount = 7;
        Items item = new Items(name, price, amount);
        testDao.addItem(item);
        Items oldItem = testDao.getItem(name);
        testDao.updateInventory(name);
        Items newItem = testDao.getItem(name);
        
        assertEquals(oldItem.getName(), 
                newItem.getName(), "cheking item's name");
        assertEquals(oldItem.getCost(), 
               newItem.getCost(), "cheking item's price");
        assertEquals(oldItem.getAmountOfItems() - 1,
                newItem.getAmountOfItems(), "cheking amount of items");
    }
    
    @Test
    public void testUpdatePrice() throws VendingMachineDaoException
    {
        String name = "Oreo";
        BigDecimal price = new BigDecimal("1.2");
        int amount = 7;
        Items item = new Items(name, price, amount);
        testDao.addItem(item);
        Items oldItem = testDao.getItem(name);
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal newPrice = price.add(hundred);
        testDao.updateCost(name, newPrice);
        Items newItem = testDao.getItem(name);
        
        assertEquals(oldItem.getName(), 
                newItem.getName(), "cheking item's name");
        assertEquals(oldItem.getCost().add(hundred), 
               newItem.getCost(), "cheking item's price");
        assertEquals(oldItem.getAmountOfItems(),
                newItem.getAmountOfItems(), "cheking amount of items");
    }
    
    @Test
    public void testGetAllItems() throws VendingMachineDaoException
    {
        String name = "Godiva";
        BigDecimal price = new BigDecimal("1.2");
        int amount = 7;
        Items item = new Items(name, price, amount);
        testDao.addItem(item);
        
        String secondName = "Kit Kat";
        BigDecimal secondPrice = new BigDecimal("5.07");
        int secondAmount = 20;
        Items secondItem = new Items(secondName, secondPrice, secondAmount);
        testDao.addItem(secondItem);
        
        List<Items> allItems = (List<Items>) testDao.getAllItems();
        
        assertNotNull(allItems, "The list of items should not be null");
        assertEquals(2, allItems.size(), "Collection of items should have 2 items.");
    }
}
