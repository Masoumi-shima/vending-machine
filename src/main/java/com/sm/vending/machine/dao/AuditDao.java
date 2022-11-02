/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.dao;

/**
 *
 * @author melpomene
 */
public interface AuditDao
{
    public void writeAuditEntry(String entry) throws VendingMachineDaoException;
}
