/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.service;

import com.sm.vending.machine.dao.AuditDao;
import com.sm.vending.machine.dao.VendingMachineDao;
import com.sm.vending.machine.dto.Items;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author caroline
 */
public class ServiceImpl implements Service {
    
    private final VendingMachineDao dao;
    private AuditDao auditDao;

    public ServiceImpl(VendingMachineDao dao, AuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public Collection<Items> getAllItems() throws Exception{
        return dao.getAllItems();
    }
}
