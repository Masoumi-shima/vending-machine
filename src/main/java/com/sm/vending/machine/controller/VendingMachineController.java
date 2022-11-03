/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.controller;

import com.sm.vending.machine.dao.VendingMachineDaoException;
import com.sm.vending.machine.dto.Items;
import com.sm.vending.machine.service.InsufficientFundsException;
import com.sm.vending.machine.service.NoItemInventoryException;
import com.sm.vending.machine.service.Service;
import com.sm.vending.machine.ui.View;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author melpomene
 */
public class VendingMachineController {

    private View view;
    private Service service;

    //constructor
    public VendingMachineController(Service service, View view) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {
            printInventory();
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 0:
                    keepGoing = false;
                    break;
                case 1:
                    buyItem();
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private void printInventory() {
        Collection<Items> inventory;
        try {
            inventory = service.getAllItems();
            view.printInventory(inventory);
        } catch (VendingMachineDaoException ex) {
            view.displayExceptionMessage(ex.getMessage());
        }

    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void buyItem() {
        BigDecimal money = view.getMoney();
        String itemName = view.selectItem();

        try {
            Map<String, Integer> change = service.buyItem(itemName, money);
            view.displaySuccessfulPurchaseMessage(itemName, change);
        } catch (VendingMachineDaoException | NoItemInventoryException | InsufficientFundsException ex) {
            view.displayExceptionMessage(ex.getMessage());
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommand();
    }

    public void exitMessage() {
        view.displayExitMessage();
    }
}
