package com.mycompany.w1908160_consolesystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * GUI class for your console system.
 * 
 * @author ehima
 */
public class TheGUI extends JFrame {

    public boolean closeRequested; // track exiting the GUI
    public JMenuBar dropdown;
    public JMenuItem Clothing = new JMenuItem("Clothing");
    public JMenuItem Electronics = new JMenuItem("Electronics");
    public JMenuItem All = new JMenuItem("All");
    w1908160WestminsterShoppingManager gettable = new w1908160WestminsterShoppingManager(); // can't instantiate an abstract class
    public ArrayList<W1908160CWProducts> CopyList;
    public String TableHead[] = {"ProductID", "Name", "Category", "Price", "Info"}; // the heads
    public String data[][];
    public int size;
    String productId ;
    String name;
    String category ;
    String price ;
    String info ;
                        

    // first Outside Layout Setting
    // constructors
    public TheGUI() {
            
        CopyList = gettable.getMyList(); // the products
        size = CopyList.size() + 2; // ;3
        JPanel panel1, panel2, panel3, panel4, OutestPanel;
        JLabel selectcategory;
        JButton b1;
        panel3 = new JPanel();
        panel4 = new JPanel();

        OutestPanel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        OutestPanel.setLayout(new GridLayout(2, 1));
        OutestPanel.add(panel1);
        OutestPanel.add(panel2);
        panel3.setBackground(Color.red);
        panel2.add(new JButton("add to cart"));
        panel1.add(panel3);
        panel1.add(panel4);

        closeRequested = false;
        int width = 200;
        int height = 200;

        // setting the first Outside Layout 1
        setLayout(new BorderLayout());

        //
        dropdown = new JMenuBar();
        JMenu categoryMenu = new JMenu("Categories");

        categoryMenu.add(All);
        categoryMenu.add(Clothing);
        categoryMenu.add(Electronics);
        dropdown.add(categoryMenu);

        // Add dropdown to the content pane
        setJMenuBar(dropdown);

        // testing the layouts
        // add buttons
        // Divided into 5 panels for tue first image
        // 2 outside panel p1 and p2(Using gridLayout,p3 and p4(inside of p1
        // The Table creation in panel 4
        // Implement the array
        System.out.println(size + ":size");
        data = new String[size][TableHead.length];
        data[0] = new String[]{"ProductID", "Name", "Category", "Price", "Info"};

        // Call the method for handling the "All" choice
        AllChoice();

        System.out.println("size:" + (size - 1));
        data[size - 1] = new String[]{"    ", "    ", "        ", "       ", "       "};

        JTable Thetable = new JTable(data, TableHead);
        JScrollPane Scroll = new JScrollPane(Thetable);

        b1 = new JButton("Shopping Cart");// Select Product Category
        selectcategory = new JLabel("Select Product Category");
        // sub panel 1

        panel1.setPreferredSize(new Dimension(width, height));

        // Adding to System

        panel2.setPreferredSize(new Dimension(width, height));
        // adding Listener to the table
        ListSelectionModel tableSelect = Thetable.getSelectionModel();
        tableSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableSelect.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = Thetable.getSelectedRow();
                    w1908160ShoppingCart cart = new w1908160ShoppingCart();

                    if (selectedRow != -1) {

                        productId = Thetable.getValueAt(selectedRow, 0).toString();
                         name = Thetable.getValueAt(selectedRow, 1).toString();
                         category = Thetable.getValueAt(selectedRow, 2).toString();
                        price = Thetable.getValueAt(selectedRow, 3).toString();
                        info = Thetable.getValueAt(selectedRow, 4).toString();
                        

                        // Do something with the data
                        if (category.equals("Clothing")) {
                            System.out.println("Selected Row: " + selectedRow);
                            System.out.println("Product ID: " + productId);
                            System.out.println("Name: " + name);
                            System.out.println("Category: " + category);
                            System.out.println("Price: " + price);
                            System.out.println("Info: " + info);
                        } else if (category.equals("Electronics")) {
                            System.out.println("Selected Row: " + selectedRow);
                            System.out.println("Product ID: " + productId);
                            System.out.println("Name: " + name);
                            System.out.println("Category: " + category);
                            System.out.println("Price: " + price);
                            System.out.println("Info: " + info);
                            //
                        }

                    }
                }
            }
            
        });
        panel2.add(new JLabel("" + productId));
        panel2.add(new JLabel("" + name));
        panel2.add(new JLabel("" + category));
        panel2.add(new JLabel("" + price));
        panel2.add(new JLabel("" + info));
        add(OutestPanel);
        // add(Scroll);

        panel3.add(selectcategory);

        panel3.add(dropdown);

        panel3.add(b1);

        panel4.add(Thetable);

        panel4.add(Scroll);

        // BorderLayout());//Learnt Boder layout
        // from:https://www.javatpoint.com/java-layout-manager
        // Exiting the GUI
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeRequested = true;
            }
        });
    }

    // Method to handle the "All" choice
    public void AllChoice() {
        if (size > 2) {
            for (int i = 0; i < size - 2; i++) {
                System.out.println(i);

                data[i + 1] = new String[]{"" + CopyList.get(i).getProductID(),
                        "" + CopyList.get(i).getProductName(), "" + CopyList.get(i).getProductCategory(),
                        "" + CopyList.get(i).getProductPrice(), "" + CopyList.get(i).getInfo()};
            }
        }
    }

    public boolean isCloseRequested() {
        return closeRequested;
    }
}
