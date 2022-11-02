/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.dao;

import com.sm.vending.machine.dto.Items;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author melpomene
 */
public class VendingMachineDaoImpl
{
    public static final String LIBRARY_FILE = "items.txt";
    public static final String DELIMITER = "::";
    
    Map<String, Items> items = new HashMap<>();
    
    private Items unmarshallItemsInfo(String itemsInfoAsText)
    {
        String[] itemsInfoTokens = itemsInfoAsText.split(DELIMITER);
        String name = itemsInfoTokens[0];
        BigDecimal cost = new BigDecimal(itemsInfoTokens[1]);
        int amount = Integer.parseInt(itemsInfoTokens[2]);
        Items itemFromFile = new Items(name, cost, amount);
        
        return itemFromFile;
    }
    
    private String marshallItemsInfo(Items itemsInfo)
    {
        String itemsInfoAsText = itemsInfo.getName() + DELIMITER;
        itemsInfoAsText += itemsInfo.getCost().toString() + DELIMITER;
        itemsInfoAsText += itemsInfo.getAmountOfItems();
        
        return itemsInfoAsText;
    }
    
    private void loadLibrary() throws VendingMachineDaoException
    {
        Scanner scanner = null;

        try
        {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } 
        catch (FileNotFoundException e)
        {
            throw new VendingMachineDaoException("Could not load library data into memory.", e);
        }
        String currentLine;
        Items currentItem;
        while (scanner.hasNextLine())
        {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItemsInfo(currentLine);
            items.put(currentItem.getName(), currentItem);
        }
        scanner.close();
    }
    
    private void writeItemInfo() throws VendingMachineDaoException
    {
       PrintWriter out = null;

       try
       {
           out = new PrintWriter(new FileWriter(LIBRARY_FILE));
       }
       catch (IOException e)
       {
           throw new VendingMachineDaoException("Could not save item's info.", e);
       }
       
       String itemInfoAsText;
       Collection<Items> itemsList = this.getAllItems();
       for(Items item : itemsList)
       {
           itemInfoAsText = marshallItemsInfo(item);
           out.print(itemInfoAsText);
           out.flush();
       }
       out.close();
    }
}
