/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baristamaticv2.inventory;

/**
 *
 * @author Aishwarya
 */
public interface Inventory {
    /**
     * Initialize the list of ingredient and price
     */
    public void initializePrice();

    /**
     * Initialize the stock of ingredients when user presses 'R' or 'r'
     */
    public void initializeStock();
     /**
     * Build the details to be displayed in the Inventory list using StringBuilder
     * @return 
     */
    public String getInventoryDetails();
    
}
