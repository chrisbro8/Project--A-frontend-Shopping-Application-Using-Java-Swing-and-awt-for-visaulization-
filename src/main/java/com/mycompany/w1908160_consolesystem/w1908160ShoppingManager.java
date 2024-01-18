/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1908160_consolesystem;

import java.util.ArrayList;

/**
 *
 * @author ehima
 */
public interface w1908160ShoppingManager  {
    public static ArrayList<W1908160CWProducts> SystemProduct=new ArrayList<>();// Made it Static so it remains the same when i extend 
    //it still the same
    public abstract void addtosystem();
    public abstract void removefromsystem();
    public abstract void stockinsystem();
    public abstract void runmenu();
    public abstract void Savefile();
    
    
}
