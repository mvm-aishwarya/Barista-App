/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baristamaticv2.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Aishwarya
 */
public class SingleInventory implements Inventory{
    
    private static final int CAPACITY = 10;
    private static final String INVENTORY_HEADING = "\nInventory:\n";
    private static SingleInventory objSingleInventory = null;   
    
    private ArrayList<InventoryItem> objListInventoryItem = null;

    private SingleInventory(){             
    }
    /**
     * Creating single instance of the inventory     
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
        objListInventoryItem.add(new InventoryItem("Coffee", 0.75, CAPACITY));
        objListInventoryItem.add(new InventoryItem("Sugar", 0.25, CAPACITY));
        objListInventoryItem.add(new InventoryItem("Cream", 0.25, CAPACITY));
        objListInventoryItem.add(new InventoryItem("Decaf Coffee", 0.75, CAPACITY));
        objListInventoryItem.add(new InventoryItem("Espresso", 1.10, CAPACITY));
        objListInventoryItem.add(new InventoryItem("Steamed milk", 0.35, CAPACITY));
        objListInventoryItem.add(new InventoryItem("Cocoa", 0.90, CAPACITY));
        objListInventoryItem.add(new InventoryItem("Whipped Cream", 1.00, CAPACITY));        
        objListInventoryItem.add(new InventoryItem("Foamed milk", 0.35, CAPACITY));
               
    }

    @Override
    public void initializeStock() {
        for(InventoryItem item: objListInventoryItem){
            item.setItemCapacity(CAPACITY);        
        }        

    }
    
    @Override
    public String getInventoryDetails() {
        StringBuilder builderDetails = new StringBuilder();
        builderDetails.append(INVENTORY_HEADING);                
       for(InventoryItem item: getObjListInventoryItem()){
            builderDetails.append(item.getItemName());
            builderDetails.append(",");
            builderDetails.append(item.getItemCapacity());
            builderDetails.append("\n");
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
