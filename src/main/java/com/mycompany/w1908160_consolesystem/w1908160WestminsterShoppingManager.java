/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1908160_consolesystem;

import java.util.Scanner;

import java.util.HashSet;
import java.util.Iterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap; // for storing the number of avalibale items
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author ehima
 */
public class w1908160WestminsterShoppingManager implements w1908160ShoppingManager{// Sorting the Array with an Object

    private static final String File_Path = "w1908160File.csv";

    Scanner input = new Scanner(System.in);
    public static HashSet<String> DoesitExist = new HashSet<String>();// for the Clothing and clothing
    public static HashMap<String, Integer> StoreItem = new HashMap<String, Integer>(); //nike,5

    public w1908160WestminsterShoppingManager() {
        super();
    }

    
    //get the list
    public ArrayList<W1908160CWProducts> getMyList(){
        return SystemProduct;
    }
    @Override
    public void addtosystem() {
        System.out.println("::This is adding a product to the system:::");
        System.out.println("::Enter 1 for Clothing and 2 for Electronics::");

        //setting the size of the arraylist to be a maximum of 50
        if (SystemProduct.size() == 50) {
            System.out.println("::The System is Full Buy new new Element OR remove some Element");
        } //Then it Less than so it continues
        else {
                System.out.println(StoreItem.keySet());//debugging
                System.out.println(StoreItem.values());//debugging
            try {

                int Whatproduct = input.nextInt();
                input.nextLine();

                if (Whatproduct == 1) {
                    //Clothing
                    System.out.println("Please Note the Product ID has to be distinct");

                    System.out.println("What the Product Unique ID");
                    String ProductIdentification1 = input.nextLine();

                    if (DoesitExist.contains(ProductIdentification1) == true) {
                        System.out.println("Item Already Exist");

                    } else {
                        System.out.println("What the Clothing name?");
                        String Productname1 = input.nextLine();
                        if(!StoreItem.containsKey(Productname1)){
                            StoreItem.put(Productname1,1);
                        }
                        else{
                            StoreItem.put(Productname1,StoreItem.get(Productname1)+1);// So i am incrementing 
                        }
                        
                        System.out.println("What the Clothing Color?");
                        String ProductColor1 = input.nextLine();
                        System.out.println("What the Clothing Price?");
                        Double Productamount1 = input.nextDouble();
                        input.nextLine();//Consume the newline character left in the buffer
                        System.out.println("What the Clothing Size(SL,L,Xl,XXL,XXXL)?");
                        String Productsize1 = input.nextLine();

                        DoesitExist.add(ProductIdentification1);
                        w1908160CWClothing add1System = new w1908160CWClothing(ProductIdentification1, Productname1, Productamount1, ProductColor1, Productsize1);
                        add1System.setCategory("Clothing");
                        SystemProduct.add(add1System);

                    }

                } else if (Whatproduct == 2) {
                    //electronics
                    System.out.println("Please Note the Product ID has to be distinct");

                    System.out.println("What the Product Unique ID");
                    String ProductIdentification2 = input.nextLine();

                    if (DoesitExist.contains(ProductIdentification2) == true) {
                        System.out.println("Item Already Exist");

                    } else {
                        System.out.println("What the Product name?");
                        String Productname2 = input.nextLine();
                        //check if product exits in the hashmap else add
                        if(!StoreItem.containsKey(Productname2)){
                            StoreItem.put(Productname2,1);
                        }
                        else{
                            StoreItem.put(Productname2,StoreItem.get(Productname2)+1);// So i am incrementing 
                        }
                        System.out.println("What the Electronics Brand?");
                        String Productbrand = input.nextLine();
                        System.out.println("What the Electronics Warrant Period");
                        Double Productperiod = input.nextDouble();
                        input.nextLine();
                        System.out.println("What the Product Price?");
                        Double Productamount2 = input.nextDouble();
                        input.nextLine();
                        DoesitExist.add(ProductIdentification2);
                        w1908160CWElectronics add2System = new w1908160CWElectronics(ProductIdentification2, Productname2, Productamount2, Productbrand, Productperiod);
                        SystemProduct.add(add2System);
                        add2System.setCategory("Electronics");

                    }

                } else {
                    System.out.println("Wrong Input Try Again");

                }

            } catch (Exception e/*i  have to get the correct error*/) {
                System.out.println("::A Value Seems to be a Mismatch");

            }
        }

    }

    @Override
    public void removefromsystem() {
        //I Used a tracker Before but it can cause out of bound error so i used anb iterator

        try {
            boolean runnit = true;// to check the size
            if (SystemProduct.size() < 1) {
                System.out.println("It is Empty");
                runnit = false;
            }
            while (runnit != false) {

                System.out.println("What is the ProductID Number #it can be a mix of String and Numbers#");
                String removeproduct = input.nextLine();
                
                System.out.println("What the Product Name");
                String removeproductbyname = input.nextLine();

                if (DoesitExist.contains(removeproduct)) {
                    //since the hashmap only needs the name of produce i dont need to worry about ID
                    if(StoreItem.containsKey(removeproductbyname) && !StoreItem.get(removeproductbyname).equals(0)){
                            StoreItem.put(removeproductbyname,StoreItem.get(removeproductbyname)-1);
                    }
                    else{
                            //delete it has it is Zero
                            StoreItem.remove(removeproductbyname);//The first condition of the top can never be wrong as the hashset already check it validaity before coming inside
                    }
                    
                    System.out.println("debug");
                    
                    DoesitExist.remove(removeproduct);
                    Iterator<W1908160CWProducts> iterator = SystemProduct.iterator();
                    while (iterator.hasNext()) {
                            W1908160CWProducts Checker=iterator.next();

                        if (Checker.getProductID().equals(removeproduct)) {
                            
                            System.out.println("Removing" + Checker.toString());
                            iterator.remove();
                            System.out.println("The total number of ProductLeft is =" + Checker.getItemAV());
                            break;

                        }
                        
                        
                    }

                } else {
                    System.out.println("That Element does not Exist,did you put the correct ID");
                    break;

                }

            }
        } catch (Exception e) {

        }

    }
    public int SysExit(int XR){
        if(XR==0){
            System.out.println("::Exiting the System");
            
        }
        else{
            System.out.println(":Exiting the Graphical User Interface Upon Closing the GUI");
        }
        return 0;
        
        
    }

    @Override

    public void stockinsystem() {
        //information about all product
        //what type of product is it//using instanceof
        Collections.sort(SystemProduct);// Sorting the List based on the ProductID
        if (SystemProduct.size() < 1) {
            System.out.println("No product in the System");
        } else {
            for (W1908160CWProducts SystemProductin : SystemProduct) {
                
                if (SystemProductin instanceof w1908160CWClothing) {
                    //i can also get Category if i implement its get Method
                    System.out.println("This is Clothing Product");
                    System.out.println(SystemProductin.toString());//The ToString validating this
                    System.out.println("-----------------------------------------------");
                } else {
                    System.out.println("-----------------------------------------------");
                    System.out.println("This is Electronic  Product");
                    System.out.println(SystemProductin.toString());//To String Validating this
                }
                System.out.println();//number of avaliable items
                
            }

        }

    }

    @Override
    public void runmenu() {
        //The Manager control

        int firstin = 011;//default values assigned so as the computer regonise before entry
        int Minput = 011;//using first then 
        while (firstin != 0) {
            System.out.println("::This is the Manager Control System::");
            System.out.println("Enter 1 to ADD a product to the System");
            System.out.println("Enter 2 to REMOVE a product to the System");
            System.out.println("Enter 3 to VIEW avaliable Stock");
            System.out.println("Enter 4 to SAVE to a file or load from a file");
            System.out.println("Enter 5 to Open from the Graphical User INTERFACE");
            System.out.println("Enter 0 to EXIT System");

            System.out.println("--------------------------------");
            System.out.print("Choose an Option:");
            // there should be try block incase if oblivious entry#

            try {
                int MXinput = input.nextInt();
                input.nextLine();//Consume the newline character left in the buffer
                firstin = MXinput;
                Minput = MXinput;

            } catch (Exception e) {
                System.out.println(":::Wrong input try again:::\n   -----------------------   \n   -----------------------   \n");
                runmenu();

            }

            switch (Minput) {
                case 1:
                    addtosystem();

                    break;
                case 2:
                    System.out.println("::Removing a product from the system:::");
                    removefromsystem();

                    break;
                case 3:
                    System.out.println("::View avaliable Stock in the system:::");
                    stockinsystem();
                    break;
                case 4:
                    System.out.println("::Saving to a File:::");
                    Savefile();
                    break;
                case 5:
                    System.out.println("::Opening the GUI:::");
                     //The GUI visualization
                    TheGUI userControl=new TheGUI();
                    userControl.setVisible(true);
                    userControl.setSize(500,600);
                    userControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                     while (true) {
                        // Your existing console code here

                        // Check if the GUI should be closed
                        if (userControl.isCloseRequested()) {
                            SysExit(5);
                            userControl.dispose(); // Close the GUI
                            System.out.println("GUI closed.");
                            break; // Exit the loop
                        }
                    }
                    
               
                    break;
                case 0:
                   Minput=SysExit(0);
                    break;

            }

        }

    }

    @Override
    public void Savefile() {
        //Save in a file the list of products that have been added to the system, with all the relative attributes.
        //The next timethe application starts, it should be able to read back all the information saved in the file and continue to use thesystem (6 marks).

        //read all the files first
        //then save all the files
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(File_Path))) {
            Iterator<W1908160CWProducts> iterator = SystemProduct.iterator();
            while (iterator.hasNext()) {
                W1908160CWProducts product = iterator.next();
                String productString = product.toString(); // Convert your object to string
                writer.write(productString);

                
                writer.newLine();
            }

        } catch (IOException e) {
             e.printStackTrace();
        }

        }



        
    
    }
