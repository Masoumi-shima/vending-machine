/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sm.vending.machine.dao;

import com.sm.vending.machine.dto.Items;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author melpomene
 */
public interface VendingMachineDao
{
    void addItem(Items item) throws VendingMachineDaoException;
    void updateInventory(String name) throws VendingMachineDaoException;
    void updateCost(String name, BigDecimal price) throws VendingMachineDaoException;
    Collection<Items> getAllItems() throws VendingMachineDaoException;
}
