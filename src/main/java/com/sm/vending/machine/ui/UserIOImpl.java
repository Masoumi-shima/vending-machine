/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm.vending.machine.ui;

import java.util.Scanner;

/**
 *
 * @author melpomene
 */
public class UserIOImpl implements UserIO
{
    @Override
    public void print(String message)
    {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public int readInt(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public int readInt(String prompt, int min, int max)
    {
        Scanner sc = new Scanner(System.in);
        int number;
        
        do
        {            
            System.out.printf("%s : min is %d max is %d\n", prompt, min, max);
            number = Integer.parseInt(sc.nextLine());

        } while ((number < min) || (number > max));
        
        return number;
    }

    @Override
    public double readDouble(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return Double.parseDouble(sc.nextLine());
    }

    @Override
    public double readDouble(String prompt, double min, double max)
    {
        Scanner sc = new Scanner(System.in);
        double number;
        
        do
        {            
            System.out.printf("%s : min is %.2f max is %.2f\n", prompt, min, max);
            number = Double.parseDouble(sc.nextLine());

        } while ((number < min) || (number > max));
        
        return number;
    }

    @Override
    public float readFloat(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return Float.parseFloat(sc.nextLine());
    }

    @Override
    public float readFloat(String prompt, float min, float max)
    {
        Scanner sc = new Scanner(System.in);
        float number;
        
        do
        {            
            System.out.printf("%s : min is %.2f max is %.2f\n", prompt, min, max);
            number = Float.parseFloat(sc.nextLine());

        } while ((number < min) || (number > max));
        
        return number;
    }

    @Override
    public long readLong(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return Long.parseLong(sc.nextLine());
    }

    @Override
    public long readLong(String prompt, long min, long max)
    {
        Scanner sc = new Scanner(System.in);
        long number;
        
        do
        {            
            System.out.printf("%s : min is %d max is %d\n", prompt, min, max);
            number = Long.parseLong(sc.nextLine());

        } while ((number < min) || (number > max));
        
        return number;
    }
}
