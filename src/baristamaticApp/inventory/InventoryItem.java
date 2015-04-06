/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baristamaticApp.inventory;

import java.util.Comparator;

/**
 *
 * @author Aishwarya
 */
public class InventoryItem {   
    
    private int itemCapacity;
    private String itemName;
    private double itemPricePerUnit;
    
    public InventoryItem(){
        
    }
    
    public InventoryItem(String iName, double iPricePerUnit, int iCapacity){
        this.itemName = iName;
        this.itemPricePerUnit = iPricePerUnit; 
        this.itemCapacity = iCapacity;
    }
     
     /**
     * Comparator to sort the MenuItem according to drink name
     */
    
    public static Comparator<InventoryItem> itemNameComparator = new Comparator<InventoryItem>() {

        @Override
	public int compare(InventoryItem item1, InventoryItem item2) {
	   String itemName1 = item1.getItemName().toUpperCase();
	   String itemName2 = item2.getItemName().toUpperCase();

	   //ascending order
	   return itemName1.compareTo(itemName2);
    }};

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemPricePerUnit
     */
    public double getItemPricePerUnit() {
        return itemPricePerUnit;
    }

    /**
     * @param itemPricePerUnit the itemPricePerUnit to set
     */
    public void setItemPricePerUnit(double itemPricePerUnit) {
        this.itemPricePerUnit = itemPricePerUnit;
    }

    /**
     * @return the itemCapacity
     */
    public int getItemCapacity() {
        return itemCapacity;
    }

    /**
     * @param itemCapacity the itemCapacity to set
     */
    public void setItemCapacity(int itemCapacity) {
        this.itemCapacity = itemCapacity;
    }
    
    
}
