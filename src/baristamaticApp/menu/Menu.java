/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baristamaticApp.menu;

import java.util.HashMap;

/**
 *
 * @author Aishwarya
 */
public interface Menu {
    
     /**
     * Build the details to be displayed in the menu using StringBuilder
     * @return String: The menu
     */
    public String getMenuDetails();
    
    /**
     * Initializes menu with the Menu items
     */
    public void initializeMenu();
    
    /**
     * Check if the drink is available (by checking each ingredient in the recipe) to dispense. 
     * @param recipe
     * @return true if in stock
     */
    public boolean isDrinkInStock(HashMap<String, Integer> recipe);

    /**
     * Get cost by computing total cost for each ingredient and no. of units
     * @param recipe
     * @return cost as String $0.00
     */
    public String getDrinkCost(HashMap<String, Integer> recipe);

    /**
     * Reduce resources after each serving. Reduce each ingredient in recipe from the inventory
     * @param recipe 
     */
    public void reduceResource(HashMap<String, Integer> recipe);

}
