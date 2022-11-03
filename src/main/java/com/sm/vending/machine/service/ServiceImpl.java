/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.service;

import com.sm.vending.machine.dao.AuditDao;
import com.sm.vending.machine.dao.VendingMachineDao;
import com.sm.vending.machine.dao.VendingMachineDaoException;
import com.sm.vending.machine.dto.Change;
import com.sm.vending.machine.dto.Items;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author caroline
 */
public class ServiceImpl implements Service {
    
    private final VendingMachineDao dao;
    private AuditDao auditDao;

    public ServiceImpl(VendingMachineDao dao, AuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public Collection<Items> getAllItems() throws VendingMachineDaoException{
        return dao.getAllItems();
    }
    
    @Override
    public Map<String,Integer> buyItem(String itemName, BigDecimal money) throws VendingMachineDaoException, NoItemInventoryException, InsufficientFundsException{
        // check if item exists in the Map of all items
        // or if there's zero left of the item
        if(dao.getItem(itemName) == null || dao.getItem(itemName).getAmountOfItems() == 0){
            throw new NoItemInventoryException("Sorry! We don't have any " + itemName + "s");
        }
        // check if money amount is enough
        // if the cost of the item is greater than the money inserted, throw an exception
        if(dao.getItem(itemName).getCost().compareTo(money) == 1){
            throw new InsufficientFundsException("Oh no! That's not enough money. A " + itemName + " costs $" + dao.getItem(itemName).getCost() + ". You only inserted $" + money);
        }
        
        // otherwise remove the item from the inventory
        dao.updateInventory(itemName);
        System.out.println(dao.getItem(itemName).getAmountOfItems());
        // get change
        return Change.getChange(dao.getItem(itemName).getCost(), money);
    }
}
