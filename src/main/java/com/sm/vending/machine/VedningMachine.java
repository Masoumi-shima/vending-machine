/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sm.vending.machine;

import com.sm.vending.machine.dao.VendingMachineDao;
import com.sm.vending.machine.dao.VendingMachineDaoException;
import com.sm.vending.machine.dao.VendingMachineDaoImpl;
import com.sm.vending.machine.dto.Change;
import com.sm.vending.machine.dto.Items;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author melpomene
 */
public class VedningMachine
{

    public static void main(String[] args) throws VendingMachineDaoException
    {
        String name = "Oreo";
        BigDecimal price = new BigDecimal("1.2");
        int amount = 7;
        Items item = new Items(name, price, amount);
        VendingMachineDao mydao = new VendingMachineDaoImpl();
        mydao.addItem(item);
        System.out.println("Done");
        mydao.updateCost(name, new BigDecimal("4.09"));
        Collection<Items> allItems = mydao.getAllItems();
        allItems.forEach((i) -> System.out.println(i.getName()));
 
    }
}
