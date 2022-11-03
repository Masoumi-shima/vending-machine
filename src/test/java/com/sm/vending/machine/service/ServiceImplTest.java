/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sm.vending.machine.service;

import com.sm.vending.machine.dao.AuditDao;
import com.sm.vending.machine.dao.VendingMachineDao;
import com.sm.vending.machine.dao.VendingMachineDaoException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author caroline
 */
public class ServiceImplTest {

    private Service service;

    public ServiceImplTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        AuditDao auditDao = new AuditDaoStubImpl();

        service = new ServiceImpl(dao, auditDao);
    }

    @Test
    public void testBuyNoItem() {
        // ARRANGE
        String itemName = "Reeses"; // buy an item we don't have in the DAO Stub
        BigDecimal money = new BigDecimal("3"); // not testing the change part here because should get an Exception before we even get to this part

        // ACT
        try {
            service.buyItem(itemName, money);
            // ASSERT
            fail("Expected NoItemInventoryException was not thrown.");

        // ASSERT
        } catch(InsufficientFundsException | VendingMachineDaoException e){
            fail("Incorrect exception was thrown.");
        }catch (NoItemInventoryException e) {
            
        }
    }
    
    @Test
    public void testBuyItem() {
        // ARRANGE
        String itemName = "Kit Kat"; // buy the one item we have in the DAO Stub
        BigDecimal money = new BigDecimal("3"); // not checking the change part
        BigDecimal money2 = new BigDecimal("2.15"); // not testing the change part with this amount because should get an Exception before we even get to the change calculation
        // ACT & ASSERT
        try {
            service.buyItem(itemName, money); // buy the remaining Kit Kat
            // now try to buy another Kit Kat
            // this should throw a NoItemInventoryException because there are zero Kit Kat's left
            service.buyItem(itemName, money2); 
            fail("Expected NoItemInventoryException was not thrown.");

        // ASSERT
        } catch(InsufficientFundsException | VendingMachineDaoException e){
            fail("Incorrect exception was thrown.");
        }catch (NoItemInventoryException e) {
            
        }
    }
    
    @Test
    public void testBuyInsufficientFunds() {
        // ARRANGE
        String itemName = "Kit Kat"; // buy the one item we have in the DAO Stub
        BigDecimal money = new BigDecimal("1"); // make sure to have less money than the cost (2.15)

        // ACT
        try {
            service.buyItem(itemName, money);
            // ASSERT
            fail("Expected InsufficientFundsException was not thrown.");

        // ASSERT
        } catch(NoItemInventoryException | VendingMachineDaoException e){
            fail("Incorrect exception was thrown.");
        }catch (InsufficientFundsException e) {
            
        }
    }
}
