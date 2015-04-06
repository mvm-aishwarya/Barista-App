/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baristamaticv2.menu;

import java.util.HashMap;
import java.util.Comparator;

/**
 *
 * @author Aishwarya
 */
public class MenuItem {
    
    private String drinkName;
    private String drinkPrice;
    private boolean isInStock;
    
    private HashMap<String,Integer> drinkIngredient;
    
     public MenuItem(){
        drinkName = "";
        drinkPrice = "";
        isInStock = true;       
    }
    public MenuItem(String dName, HashMap<String,Integer> dIngredient, String dPrice, boolean dStock){
        this.drinkName = dName;
        this.drinkIngredient = dIngredient;
        this.drinkPrice = dPrice;
        this.isInStock = dStock;
    }
    
    /**
     * @return the drinkName
     */
    public String getDrinkName() {
        return drinkName;
    }

    /**
     * @param drinkName the drinkName to set
     */
    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    /**
     * @return the drinkPrice
     */
    public String getDrinkPrice() {
        return drinkPrice;
    }

    /**
     * @param drinkPrice the drinkPrice to set
     */
    public void setDrinkPrice(String drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    /**
     * @return the isInStock
     */
    public boolean isIsInStock() {
        return isInStock;
    }

    /**
     * @param isInStock the isInStock to set
     */
    public void setIsInStock(boolean isInStock) {
        this.isInStock = isInStock;
    }

    /**
     * @return the drinkIngredient
     */
    public HashMap<String,Integer> getDrinkIngredient() {
        return drinkIngredient;
    }

    /**
     * @param drinkIngredient the drinkIngredient to set
     */
    public void setDrinkIngredient(HashMap<String,Integer> drinkIngredient) {
        this.drinkIngredient = drinkIngredient;
    }
    
    
    
    public static Comparator<MenuItem> menuNameComparator = new Comparator<MenuItem>() {

	public int compare(MenuItem item1, MenuItem item2) {
	   String itemName1 = item1.getDrinkName().toUpperCase();
	   String itemName2 = item2.getDrinkName().toUpperCase();

	   //ascending order
	   return itemName1.compareTo(itemName2);
    }};
}
