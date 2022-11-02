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
public enum Change
{
    DOLLARS(new BigDecimal("1")),
    QUARTERS(new BigDecimal("0.25")),
    DIMES(new BigDecimal("0.1")),
    NICKLES(new BigDecimal("0.05")),
    PENNIES(new BigDecimal("0.0"));
        
    private BigDecimal value;

    Change(BigDecimal value)
    {
        this.value = value;
    }
    
    public BigDecimal getValue()
    {
        return value;
    }
}
