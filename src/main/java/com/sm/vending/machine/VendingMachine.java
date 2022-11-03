/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sm.vending.machine;

import com.sm.vending.machine.controller.VendingMachineController;
import com.sm.vending.machine.dao.AuditDaoImpl;
import com.sm.vending.machine.dao.VendingMachineDao;
import com.sm.vending.machine.dao.VendingMachineDaoException;
import com.sm.vending.machine.dao.VendingMachineDaoImpl;

import com.sm.vending.machine.dto.Items;
import com.sm.vending.machine.service.ServiceImpl;
import com.sm.vending.machine.ui.UserIOImpl;
import com.sm.vending.machine.ui.View;
import java.math.BigDecimal;


/**
 *
 * @author melpomene
 */
public class VendingMachine
{
    public static void main(String[] args) throws VendingMachineDaoException
    {
        VendingMachineDao myDao = new VendingMachineDaoImpl();
        AuditDaoImpl auditDao = new AuditDaoImpl();
        UserIOImpl io = new UserIOImpl();
        View view = new View(io);
        ServiceImpl service = new ServiceImpl(myDao, auditDao);
        VendingMachineController controller = new VendingMachineController(service, view);
        
        addItemsToDB(myDao);
        controller.run();
    }
    
    private static void addItemsToDB(VendingMachineDao myDao) throws VendingMachineDaoException
    {
        String name = "Oreo";
        BigDecimal price = new BigDecimal("1.2");
        int amount = 4;
        Items item = new Items(name, price, amount);
        myDao.addItem(item);
        
        String secondName = "Lindt";
        BigDecimal secondPrice = new BigDecimal("5.07");
        int secondAmount = 20;
        Items secondItem = new Items(secondName, secondPrice, secondAmount);
        myDao.addItem(secondItem);
    }
}
