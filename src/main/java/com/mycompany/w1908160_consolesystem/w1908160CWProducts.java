/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1908160_consolesystem;

/**
 *
 * @author ehima
 */
abstract class W1908160CWProducts implements Comparable<W1908160CWProducts>,w1908160ShoppingManager{
       // Attriburtes
      protected String ProductId;
      protected String ProductName;
      int NumberOfAvItems; //Number of avaliable items
      protected double ProductPrice;
      
      //Constructors
      public W1908160CWProducts(){
          this.ProductId = "see";
          this.ProductName = "see";
          
          this.ProductPrice=0.0;
          
      
          
     
      }
      public W1908160CWProducts(String Productid,String ProductName,double price){
          this.ProductId = Productid;
          this.ProductName = ProductName;
          
          this.ProductPrice=price;
          
      
          
     
      }
       // Get Methods
      public  String getProductID(){
          return this.ProductId;
      }
   
      public String getProductName(){
          return this.ProductName;
      }

      public double getProductPrice(){
          return this.ProductPrice;
      }
      
     
      // Set Methods
      abstract void setProductID(String productid);
      abstract void setProductName(String productname);
      abstract void setProductPrice(double price);
      abstract int  getItemAV();
      
      abstract String getProductCategory();
      abstract String getInfo();
  
      public String toString(){
          return "Product ID:"+getProductID()+"Product Name:"+getProductName()+"Number of Avaliable items:"+NumberOfAvItems+"Product Price=:"+this.getProductPrice();
      }
      public int compareTo(W1908160CWProducts otherID) {
        
        //compare USing ID productID
        System.out.println(this.ProductId.compareTo(otherID.ProductId));
        return this.ProductId.compareTo(otherID.ProductId);
        
    }

    @Override
    public void addtosystem() {
        //Do Nothing
    }

    @Override
    public void removefromsystem() {
        //Do Nothing
    }

    @Override
    public void stockinsystem() {
        //Do Nothing
    }

    @Override
    public void runmenu() {
        //Do Nothing
    }

    @Override
    public void Savefile() {
        //Do  Nothing
    }
      
}
