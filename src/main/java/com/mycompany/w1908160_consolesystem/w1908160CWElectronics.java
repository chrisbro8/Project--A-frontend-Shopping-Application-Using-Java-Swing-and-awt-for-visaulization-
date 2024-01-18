/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1908160_consolesystem;

/**
 *
 * @author ehima
 */
public class w1908160CWElectronics extends W1908160CWProducts {
    private String brand;
    private double Warranty_Period;
    private String Category;
    private static int count;
    
    // constructors
    
    public w1908160CWElectronics(){
        super();
        this.brand="";
        this.Warranty_Period=0.0;
    } 
    public w1908160CWElectronics(String Productid,String ProductName,double price,String brand,double warrant_period){
      
        super(Productid,ProductName,price);
        count++;// use for appl discount to the category
        this.brand=brand;
        this.Warranty_Period=warrant_period;
    }
    
    
    //set Methods
    public void setBrand(String brand){
        this.brand=brand;
        
    }
    public void setWarrantyPeriod(double warrantPeriod){
        this.Warranty_Period=warrantPeriod;
        
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
    public String getBrand(){
        return this.brand;
        
    }
    @Override
    public String getProductID(){
        return super.getProductID();
        
    }
    public Double getPrice(){
        return super.getProductPrice();
        
    }
    public double getWarrantyPeriod(){
        return this.Warranty_Period;
        
    }
    @Override
    public String getProductCategory(){
        return this.Category;
        
    }
    public String getInfo(){
        return "Brand:"+this.getBrand()+","+"Warranty Period"+this.getWarrantyPeriod();
        
    }
    @Override
    public String toString(){
        
        return  "The ProductID:"+getProductID()+"\nThe name of the Product:"+ProductName+"\nThe Price:"+getPrice()+"\nThe Brand:"+getBrand()+"\nThe Warranty Period:"+getWarrantyPeriod();
    }

    @Override
    public int getItemAV() {
        return SystemProduct.size();
    }
    
}
