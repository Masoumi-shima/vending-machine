/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.dto;

import java.math.BigDecimal;

/**
 *
 * @author melpomene
 */
public class Items
{
    private String name;
    private BigDecimal cost;
    private int amountOfItems;

    public Items(String name, BigDecimal cost, int amount)
    {
        this.name = name;
        this.cost = cost;
        this.amountOfItems = amount;
    }

    public String getName()
    {
        return name;
    }

    public BigDecimal getCost()
    {
        return cost;
    }

    public void setCost(BigDecimal cost)
    {
        this.cost = cost;
    }

    public int getAmountOfItems()
    {
        return amountOfItems;
    }
    
    public void popItem()
    {
        this.amountOfItems--;
    }
}
