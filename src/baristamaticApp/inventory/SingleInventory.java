/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baristamaticApp.inventory;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Single inventory which holds the list of items.
 * @author Aishwarya
 */
public class SingleInventory implements Inventory {

    private static final int CAPACITY = 10;
    private static final String EMPTY_STRING = "";
    private static final String EXCEPTION_MESSAGE = "\nException: ";
    private static final String INVENTORY_HEADING = "\nInventory:\n";
    private static final String COMMA = ",";
    private static final String NEXT_LINE = "\n";
    private static SingleInventory objSingleInventory = null;

    //Holds arraylist of inventory items
    private ArrayList<InventoryItem> objListInventoryItem = null;

    private SingleInventory() {
    }

    /**
     * Creating single instance of the inventory
     *
     * @return instance
     */
    public static SingleInventory getInstance() {
        if (objSingleInventory == null) {
            objSingleInventory = new SingleInventory();
        }

        return objSingleInventory;
    }

    @Override
    public void initializePrice() {
        objListInventoryItem = new ArrayList<>();
        objListInventoryItem.add(new InventoryItem("Coffee", 0.75));
        objListInventoryItem.add(new InventoryItem("Sugar", 0.25));
        objListInventoryItem.add(new InventoryItem("Cream", 0.25));
        objListInventoryItem.add(new InventoryItem("Decaf Coffee", 0.75));
        objListInventoryItem.add(new InventoryItem("Espresso", 1.10));
        objListInventoryItem.add(new InventoryItem("Steamed milk", 0.35));
        objListInventoryItem.add(new InventoryItem("Cocoa", 0.90));
        objListInventoryItem.add(new InventoryItem("Whipped Cream", 1.00));
        objListInventoryItem.add(new InventoryItem("Foamed milk", 0.35));
    }

    @Override
    public void initializeStock() {
        for (InventoryItem item : objListInventoryItem) {
            item.setItemCapacity(CAPACITY);
        }

    }

    @Override
    public String getInventoryDetails() {
        StringBuilder builderDetails = new StringBuilder();
        try {
            builderDetails.append(INVENTORY_HEADING);
            Collections.sort(objListInventoryItem, InventoryItem.itemNameComparator);
            for (InventoryItem item : getObjListInventoryItem()) {
                builderDetails.append(item.getItemName());
                builderDetails.append(COMMA);
                builderDetails.append(item.getItemCapacity());
                builderDetails.append(NEXT_LINE);
            }
        } catch (IndexOutOfBoundsException | NullPointerException inex) {
            System.out.println(EXCEPTION_MESSAGE + inex.getMessage());
            builderDetails.append(EMPTY_STRING);
        }
        return builderDetails.toString();
    }

    /**
     * @return the objListInventoryItem
     */
    public ArrayList<InventoryItem> getObjListInventoryItem() {
        return objListInventoryItem;
    }

    /**
     * @param objListInventoryItem the objListInventoryItem to set
     */
    public void setObjListInventoryItem(ArrayList<InventoryItem> objListInventoryItem) {
        this.objListInventoryItem = objListInventoryItem;
    }

}
