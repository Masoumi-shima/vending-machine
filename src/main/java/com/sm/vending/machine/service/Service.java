/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.service;

import com.sm.vending.machine.dto.Items;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author melpomene
 */
public interface Service
{
    Collection<Items> getAllItems() throws Exception;
}
