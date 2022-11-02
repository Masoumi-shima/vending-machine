/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.ui;

import com.sm.vending.machine.dto.Change;
import static com.sm.vending.machine.dto.Change.DIMES;
import static com.sm.vending.machine.dto.Change.DOLLARS;
import static com.sm.vending.machine.dto.Change.NICKLES;
import static com.sm.vending.machine.dto.Change.PENNIES;
import static com.sm.vending.machine.dto.Change.QUARTERS;
import com.sm.vending.machine.dto.Items;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author caroline
 */
public class View {
    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("What would you like to do?");
        io.print("1. Buy an item");
        io.print("0. Exit");

        return io.readInt("Please select from the above choices.", 0, 1);
    }
    
    public void printInventory(List<Items> inventory){
        io.print("====== VENDING MACHINE INVENTORY ======");
        for(Items item : inventory){
            io.print(item.getName());
            io.print("Cost: " + item.getCost());
            io.print("Amount: " + item.getAmountOfItems());
            io.print("");
        }
    }
    
    public BigDecimal getMoney(){
        return new BigDecimal(io.readString("Please insert money:"));
    }
    
    public String selectItem(){
        return io.readString("What would you like to buy?");
    }
    
    public void displayInsufficientFunds(String itemName, BigDecimal moneyAmount){
        io.print("I'm sorry! That's not enough money for a " + itemName + " :(");
        io.print("You have inserted $" + moneyAmount);
    }
    
    public void displayChange(Map<Change, Integer> change){
        io.print("Here's your change: ");
        io.print("Dollars: " + change.get(DOLLARS));
        io.print("Quarters: " + change.get(QUARTERS));
        io.print("Dimes: " + + change.get(DIMES));
        io.print("Nickels: " + change.get(NICKLES));
        io.print("Pennies: " + change.get(PENNIES));
    }
    
    public void displayUnknownCommand(){
        io.print("Sorry, that's not an option!");
    }
    
    public void displayExitMessage(){
        io.print("Thanks for using the vending machine, goodbye!");
    }
}
