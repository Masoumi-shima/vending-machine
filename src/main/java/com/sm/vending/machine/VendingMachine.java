/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sm.vending.machine;

import com.sm.vending.machine.dao.VendingMachineDao;
//import com.sm.vending.machine.dao.VendingMachineDaoException;
//import com.sm.vending.machine.dao.VendingMachineDaoImpl;
import com.sm.vending.machine.dto.Change;
import com.sm.vending.machine.dto.Items;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author melpomene
 */
public class VendingMachine
{
    public static void main(String[] args) //throws VendingMachineDaoException
    {
        VendingMachineDao testDao = new VendingMachineDaoImpl();
        String name = "Oreo";
        BigDecimal price = new BigDecimal("1.2");
        int amount = 7;
        Items item = new Items(name, price, amount);
        testDao.addItem(item);
        
        String secondName = "Lindt";
        BigDecimal secondPrice = new BigDecimal("5.07");
        int secondAmount = 20;
        Items secondItem = new Items(secondName, secondPrice, secondAmount);
        testDao.addItem(secondItem);
 
    }

}
