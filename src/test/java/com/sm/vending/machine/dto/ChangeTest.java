/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sm.vending.machine.dto;

import static com.sm.vending.machine.dto.Change.getChange;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author tiara
 */
public class ChangeTest {
    
    public ChangeTest() {
    }

    @Test
    public void testingProperChangeReturned1() {
        //ARRANGE
        BigDecimal cost = new BigDecimal("25.17");
        BigDecimal moneyGiven = new BigDecimal("30");
        //ACT
        Map result = getChange(cost,moneyGiven);//$4.83 expected
        //ASSERT
        Map expectedAns = new HashMap<String,Integer>();
        
        expectedAns.put("DOLLARS", 4);
        expectedAns.put("QUARTERS", 3);
        expectedAns.put("DIMES", 0);
        expectedAns.put("NICKLES", 1);
        expectedAns.put("PENNIES", 3);
        assertFalse(!(result.equals(expectedAns)),"The map returned is not what was expected");
    }
    @Test
    public void testingProperChangeReturned2() {
        //ARRANGE
        BigDecimal cost = new BigDecimal("2.99");
        BigDecimal moneyGiven = new BigDecimal("10");
        //ACT
        Map result = getChange(cost,moneyGiven);//$4.83 expected
        //ASSERT
        Map expectedAns = new HashMap<String,Integer>();
        
        expectedAns.put("DOLLARS", 7);
        expectedAns.put("QUARTERS", 0);
        expectedAns.put("DIMES", 0);
        expectedAns.put("NICKLES", 0);
        expectedAns.put("PENNIES", 1);
        assertFalse(!(result.equals(expectedAns)),"The map returned is not what was expected");
    }
    @Test
    public void testingProperChangeReturned3() {
        //ARRANGE
        BigDecimal cost = new BigDecimal("1.49");
        BigDecimal moneyGiven = new BigDecimal("5");
        //ACT
        Map result = getChange(cost,moneyGiven);//$4.83 expected
        //ASSERT
        Map expectedAns = new HashMap<String,Integer>();
        
        expectedAns.put("DOLLARS", 3);
        expectedAns.put("QUARTERS", 2);
        expectedAns.put("DIMES", 0);
        expectedAns.put("NICKLES", 0);
        expectedAns.put("PENNIES", 1);
        assertFalse(!(result.equals(expectedAns)),"The map returned is not what was expected");
    }
    @Test
    public void testingProperChangeReturned4() {
        //ARRANGE
        BigDecimal cost = new BigDecimal("2.34");
        BigDecimal moneyGiven = new BigDecimal("10");
        //ACT
        Map result = getChange(cost,moneyGiven);//$4.83 expected
        //ASSERT
        Map expectedAns = new HashMap<String,Integer>();
        
        expectedAns.put("DOLLARS", 7);
        expectedAns.put("QUARTERS", 2);
        expectedAns.put("DIMES", 1);
        expectedAns.put("NICKLES", 1);
        expectedAns.put("PENNIES", 1);
        assertFalse(!(result.equals(expectedAns)),"The map returned is not what was expected");
    }
    
}
