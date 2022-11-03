/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.service;

import com.sm.vending.machine.dao.VendingMachineDao;
import com.sm.vending.machine.dao.VendingMachineDaoException;
import com.sm.vending.machine.dto.Items;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author caroline
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    public Items onlyItem;

    public VendingMachineDaoStubImpl() {

        onlyItem = new Items("Kit Kat", new BigDecimal("2.15"), 1);
    }

    public VendingMachineDaoStubImpl(Items testItem) {
        this.onlyItem = testItem;
    }

    @Override
    public void addItem(Items item) throws VendingMachineDaoException {
        // do nothing
    }

    @Override
    public void updateInventory(String name) throws VendingMachineDaoException {
        if(name.equals(onlyItem.getName())){
            onlyItem.popItem();
        } else{
            throw new VendingMachineDaoException("We don't sell that item.");
        }
     
    }

    @Override
    public void updateCost(String name, BigDecimal price) throws VendingMachineDaoException {
        // do nothing
    }

    @Override
    public Collection<Items> getAllItems() throws VendingMachineDaoException {
        Collection<Items> items = new ArrayList<>();
        items.add(onlyItem);
        return items;
    }

    @Override
    public Items getItem(String itemName) throws VendingMachineDaoException {
        if(itemName.equals(onlyItem.getName())){
            return onlyItem;
        }else{
            return null;
        }
    }
}
