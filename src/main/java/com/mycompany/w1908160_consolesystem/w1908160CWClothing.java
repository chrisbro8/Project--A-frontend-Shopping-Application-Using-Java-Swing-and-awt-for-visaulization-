/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1908160_consolesystem;

/**
 *
 * @author ehima
 */
public class w1908160CWClothing extends W1908160CWProducts {
    private String Size;
    private String Color;
    private String Category;
    
    //constructors
    public w1908160CWClothing(){
    super();
    this.Color="defautl:red";
    this.Size="";
    } 
    public w1908160CWClothing(String Productid,String ProductName,double price,String color,String size){
        super(Productid,ProductName,price);
        //Number+1;
       
        this.Color=color;
        this.Size=size;
    }

   
    //setMethods
    public void setColor(String color){
    this.Color=color;
    }
    public void setSize(String size){
        this.Size=size;
    }
     @Override
    public void setProductID(String productid){
        super.ProductId=productid;
    }
    @Override
    public void setProductName(String productname){
        super.ProductName=productname;
    }
    @Override
    public void setProductPrice(double price){
        super.ProductPrice=price;
    }
    
    public void setCategory(String Category){
        this.Category=Category;
        
    }
    // get Methods Only for the Subclass
    public String getColor(){
        return this.Color;
        
    }
    public String getSize(){
        return this.Size;
        
    }
    public double getPrice(){
        return super.ProductPrice;
        
    }
    @Override
    public String getProductCategory(){
        return this.Category;
        
    }
    @Override
    public String getProductID(){
        return super.getProductID();
        
    }
    @Override
    public String getInfo(){
        return ""+this.getColor()+","+this.getSize();
        
    }
    public String tostring(){
        return "The ProductID:"+getProductID()+"\nName Of Product:"+super.getProductName()+"\nThe Color:"+getColor()+"\nThe Price:"+getPrice();
    }
     public int getItemAV() {
        return SystemProduct.size();
    }
    
}
