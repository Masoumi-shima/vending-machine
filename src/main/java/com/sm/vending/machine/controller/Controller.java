/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.controller;

import com.sm.vending.machine.service.Service;
import com.sm.vending.machine.ui.View;
import java.math.BigDecimal;

/**
 *
 * @author melpomene
 */
public class Controller {

    private View view;
    private Service service;

    //constructor
    public Controller(Service service, View view) {
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
                case 0 ->
                    keepGoing = false;
                case 1 ->
                    buyItem();
                default ->
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private void printInventory() {
        // List<Items> inventory = call to service layer to get inventory
        //view.printInventory(inventory);
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void buyItem(){
        BigDecimal money = view.getMoney();
        String itemName = view.selectItem();
        
    }
    
    private void unknownCommand() {
        view.displayUnknownCommand();
    }
    
    public void exitMessage() {
        view.displayExitMessage();
    }
}
