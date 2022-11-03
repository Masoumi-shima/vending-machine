/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.dto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author melpomene
 */
public class Change {
    //constants --> start with c to not be confused with enums
    private static final BigDecimal C_QUARTER = new BigDecimal(".25");
    private static final BigDecimal C_DIME = new BigDecimal(".1");
    private static final BigDecimal C_NICKLE = new BigDecimal(".05");
    private static final BigDecimal C_PENNY = new BigDecimal(".01");

    /**
     *
     */
    public enum ChangeValues {
        DOLLARS,QUARTERS,DIMES,NICKLES,PENNIES;
    }

    public static HashMap getChange(BigDecimal itemCost,BigDecimal moneyGiven){
        HashMap<String,Integer> changeMap = new HashMap<>();
        BigDecimalMath calc = new BigDecimalMath();
        //get full change
        BigDecimal change = calc.calculate(MathOperator.MINUS, moneyGiven, itemCost);
        //throw error for not enough money?
        // get dollars add to map
        int dollars =change.intValue();
        changeMap.put(ChangeValues.DOLLARS.name(), dollars);
        //subtract dollars from change
        change = calc.calculate(MathOperator.MINUS, change, new BigDecimal(Integer.toString(dollars)));
        
        
        //get quarters add to map
        BigDecimal temp = calc.calculate(MathOperator.DIVIDE, change, C_QUARTER);
        int quarters =(temp).intValue();
        changeMap.put(ChangeValues.QUARTERS.name(),quarters);
        //subtract quarters from change
        temp = calc.calculate(MathOperator.MULTIPLY, C_QUARTER, new BigDecimal(Integer.toString(quarters)));
        change = calc.calculate(MathOperator.MINUS, change, temp);
        
        
        //get dimes add to map
        temp = calc.calculate(MathOperator.DIVIDE, change, C_DIME);
        int dimes = temp.intValue();
        changeMap.put(ChangeValues.DIMES.name(), dimes);
        
        //subtract dimes from change
        temp = calc.calculate(MathOperator.MULTIPLY, C_DIME, new BigDecimal(Integer.toString(dimes)));
        change= calc.calculate(MathOperator.MINUS, change, temp);
        
        
        //get nickles add to map
        temp = calc.calculate(MathOperator.DIVIDE, change, C_NICKLE);
        int nickles = temp.intValue();
        changeMap.put(ChangeValues.NICKLES.name(), nickles);
        
        //subtract nickles from change
        temp = calc.calculate(MathOperator.MULTIPLY, C_NICKLE, new BigDecimal(Integer.toString(nickles)));
        change= calc.calculate(MathOperator.MINUS, change, temp);
        
        
        //add remaining pennies to map
        temp = calc.calculate(MathOperator.DIVIDE, change, C_PENNY);
        int pennies = temp.intValue();
        changeMap.put(ChangeValues.PENNIES.name(), pennies);
        return changeMap;
    }
    //version with doubles
    public static Map getChange(double itemCost,double moneyGiven){
        HashMap<String,Integer> changeMap = new HashMap<>();
        //get full change
        double change = moneyGiven-itemCost;
        
        // get dollars add to map
        int dollars = (int)change;
        changeMap.put(ChangeValues.DOLLARS.name(), dollars);
        //subtract dollars from change
        change-=dollars;
        
        //get quarters add to map
        int quarters = (int)(change/.25);
        changeMap.put(ChangeValues.QUARTERS.name(),quarters);
        //subtract quarters from change
        change -= quarters*.25;
        
        //get dimes add to map
        int dimes = (int)(change/.1);
        changeMap.put(ChangeValues.DIMES.name(), dimes);
        //subtract dimes from change
        change-= dimes*.1;
        
        
        //get nickles add to map
        int nickles = (int)(change/.05);
        changeMap.put(ChangeValues.NICKLES.name(), nickles);
        //subtract nickles from change
        change -=nickles*.05;
        
        //add remaining pennies to map
        int pennies = (int) (change/.01);
        changeMap.put(ChangeValues.PENNIES.name(), pennies);
        return changeMap;
    }
    
    
}
