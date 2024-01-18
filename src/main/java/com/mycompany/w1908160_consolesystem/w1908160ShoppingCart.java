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
public class w1908160ShoppingCart {
    public  ArrayList<ArrayList<String>>userproduce=new ArrayList<>();
    // there should be methods to add, remove and calculate the total cost
    
    
    //constructors
    public w1908160ShoppingCart(){}
    //public void Addto(W1908160CWProducts product){ //static error? y
        
    //}
    public void removefrom(int producenum){ //static error? y
        this.userproduce.remove(producenum);
    }

    
    
}
