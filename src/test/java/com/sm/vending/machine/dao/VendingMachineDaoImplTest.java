/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sm.vending.machine.dao;

import com.sm.vending.machine.dto.Items;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
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

//        mydao.updateCost(name, new BigDecimal("4.09"));
//        Collection<Items> allItems = mydao.getAllItems();
//        allItems.forEach((i) -> System.out.println(i.getName()));
    }
}
