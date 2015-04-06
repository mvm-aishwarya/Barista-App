/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baristamaticApp.menu;

import baristamaticApp.inventory.InventoryItem;
import baristamaticApp.inventory.SingleInventory;
import baristamaticApp.menu.drink.DrinkList;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Aishwarya
 */
public class SingleMenu implements Menu {

    private static final String DISPENSING_MESSAGE = "\nDispensing: ";
    private static final String OUTOFSTOCK_MESSAGE = "\nOut of stock: ";
    private static final String MENU_HEADING = "\nMenu:\n";
    private ArrayList<MenuItem> objListMenuItem = null;
    private boolean isAvailable = true;
    private static SingleMenu objSingleMenu = null;
    private static SingleInventory objSingleInventory = null;

    private SingleMenu() {
        objSingleInventory = SingleInventory.getInstance();
        objSingleInventory.initializePrice();
        objSingleInventory.initializeStock();
    }

    /**
     * Get single instance of menu
     *
     * @return instance
     */
    public static SingleMenu getInstance() {
        if (objSingleMenu == null) {
            objSingleMenu = new SingleMenu();
        }
        return objSingleMenu;
    }

    /**
     * Calls the initialize stock method in SingeInventory. Initialize the stock
     * of ingredients when user presses 'R' or 'r'
     */
    public void initializeInventoryStock() {
        objSingleInventory.initializeStock();
    }

    @Override
    public void initializeMenu() {
        objListMenuItem = new ArrayList<>();

        objListMenuItem.add(new MenuItem("Coffee", DrinkList.coffeeRecipe(), getDrinkCost(DrinkList.coffeeRecipe()), isAvailable));
        objListMenuItem.add(new MenuItem("Decaf Coffee", DrinkList.DecafCoffeeRecipe(), getDrinkCost(DrinkList.DecafCoffeeRecipe()), isAvailable));
        objListMenuItem.add(new MenuItem("Cafe Latte", DrinkList.CafeLatteRecipe(), getDrinkCost(DrinkList.CafeLatteRecipe()), isAvailable));

        objListMenuItem.add(new MenuItem("Caffe Americano", DrinkList.CafeAmericanoRecipe(), getDrinkCost(DrinkList.CafeAmericanoRecipe()), isAvailable));
        objListMenuItem.add(new MenuItem("Cafe Mocha", DrinkList.CafeMochaRecipe(), getDrinkCost(DrinkList.CafeMochaRecipe()), isAvailable));
        objListMenuItem.add(new MenuItem("Cappuccino", DrinkList.CappuccinoRecipe(), getDrinkCost(DrinkList.CappuccinoRecipe()), isAvailable));
    }    
    
    @Override
    public String getMenuDetails() {

        StringBuilder builderDetails = new StringBuilder();
        builderDetails.append(objSingleInventory.getInventoryDetails());
        int index = 1;
        Collections.sort(objListMenuItem, MenuItem.menuNameComparator);
        builderDetails.append(MENU_HEADING);

        //for each item in the available menu loop through
        for (MenuItem item : getObjListMenuItem()) {
            builderDetails.append(index);
            builderDetails.append(",");
            builderDetails.append(item.getDrinkName());
            builderDetails.append(",");
            builderDetails.append(item.getDrinkPrice());
            builderDetails.append(",");
            builderDetails.append(item.isIsInStock());
            builderDetails.append("\n");
            index++;
        }
        return builderDetails.toString();
    }    

    @Override
    public String getDrinkCost(HashMap<String, Integer> recipe) {
        String totalCost;
        String consumedKey;

        int consumedUnit;
        double eachIngredientCost = 0.0;
        double computeCost = 0.0;

        Set<Map.Entry<String, Integer>> ingredientConsumed = recipe.entrySet();
        ArrayList<InventoryItem> listItem = objSingleInventory.getObjListInventoryItem();

        for (Map.Entry<String, Integer> consumed : ingredientConsumed) {
            consumedKey = consumed.getKey();
            consumedUnit = consumed.getValue();

            for (InventoryItem iItem : listItem) {
                if (iItem.getItemName().equals(consumedKey)) {
                    eachIngredientCost = iItem.getItemPricePerUnit();
                    break;
                }
            }
            computeCost += (consumedUnit * eachIngredientCost);
            eachIngredientCost = 0.0;
        }
        totalCost = formatToString(computeCost);
        return totalCost;
    }

    @Override
    public boolean isDrinkInStock(HashMap<String, Integer> recipe) {

        boolean inStock = true;
        boolean checkInStockFlag = false;

        Set<Map.Entry<String, Integer>> ingredientConsumed = recipe.entrySet();
        ArrayList<InventoryItem> listItem = objSingleInventory.getObjListInventoryItem();

        int consumedUnit = 0;
        String consumedKey;
        int availableUnit = 0;

        for (Map.Entry<String, Integer> consumed : ingredientConsumed) {
            consumedKey = consumed.getKey();
            consumedUnit = consumed.getValue();

            for (InventoryItem iItem : listItem) {
                if (iItem.getItemName().equals(consumedKey)) {
                    availableUnit = iItem.getItemCapacity();
                    if (availableUnit < consumedUnit) {
                        checkInStockFlag = true; //Change flag only when the ingredient is not available
                    }
                    break;
                }

            }
            //Check the flag. Even if one ingredient is missing, we cannot make that drink.
            if (checkInStockFlag == true) {
                inStock = false;
                break;
            }
        }
        return inStock;
    }

    @Override
    public void reduceResource(HashMap<String, Integer> recipe) {
        Set<Map.Entry<String, Integer>> ingredientConsumed = recipe.entrySet();
        ArrayList<InventoryItem> listItem = objSingleInventory.getObjListInventoryItem();

        int consumedUnit = 0;
        String consumedKey;
        int availableUnit = 0;

        for (Map.Entry<String, Integer> consumed : ingredientConsumed) {
            consumedKey = consumed.getKey();
            consumedUnit = consumed.getValue();

            for (InventoryItem iItem : listItem) {
                if (iItem.getItemName().equals(consumedKey)) {
                    availableUnit = iItem.getItemCapacity();
                    availableUnit -= consumedUnit;
                    iItem.setItemCapacity(availableUnit);
                    break;
                }

            }
        }
    }
    
    /**
     * Dispense drink when the user selects a specific drink
     * @param dispenseDrink The specific drink that is dispensed (MenuItem)
     * @return message to the user on drink availability
     */
    public String dispenseDrink(MenuItem dispenseDrink) {
        if (checkDrinkAvailability(dispenseDrink)) {
            objSingleMenu.reduceResource(dispenseDrink.getDrinkIngredient());
            String message = DISPENSING_MESSAGE + dispenseDrink.getDrinkName();
            return message;
        } else {
            String message = OUTOFSTOCK_MESSAGE + dispenseDrink.getDrinkName();
            return message;
        }       
    }


    /**
     * Check all the drink's availability once a drink is served. 
     * Used to update the menu.
     */
    public void checkAllDrinkAvailability() {
        for (MenuItem eachItem : objListMenuItem) {
            boolean isDrinkAvailable = isDrinkInStock(eachItem.getDrinkIngredient());
            updateDrinkAvailability(eachItem.getDrinkName(), isDrinkAvailable);
        }
    }
    
    /**
     * Check a specific drink's availability with the stock available. Update
     * the menu's inStock value accordingly.
     *
     * @return boolean: true if available, false otherwise
     */
    private boolean checkDrinkAvailability(MenuItem checkItem) {
        boolean isDrinkAvailable = isDrinkInStock(checkItem.getDrinkIngredient());
        objSingleMenu.updateDrinkAvailability(checkItem.getDrinkName(), isDrinkAvailable);
        return isDrinkAvailable;
    }
    
    /**
     * Updates drink availability according to stock in the inventory
     * @param drinkName the drink name 
     * @param isInStock whether or not the drink is in stock
     */

    private void updateDrinkAvailability(String drinkName, boolean isInStock) {
        for (MenuItem mItem : objListMenuItem) {
            if (mItem.getDrinkName().equals(drinkName)) {
                mItem.setIsInStock(isInStock); //Stock availability stored at 1                                
            }
        }
    }    
    
    /**
     * Format the double value to String
     * @param computeCost the price in double
     * @return converted String 
     */
    private String formatToString(double computeCost) {
        DecimalFormat objDecimal = new DecimalFormat("$#.00");
        return objDecimal.format(computeCost);
    }

    /**
     * @return the objListMenuItem
     */
    public ArrayList<MenuItem> getObjListMenuItem() {
        return objListMenuItem;
    }

    /**
     * @param objListMenuItem the objListMenuItem to set
     */
    public void setObjListMenuItem(ArrayList<MenuItem> objListMenuItem) {
        this.objListMenuItem = objListMenuItem;
    }

    /**
     * @return the isAvailable
     */
    public boolean isIsAvailable() {
        return isAvailable;
    }

    /**
     * @param isAvailable the isAvailable to set
     */
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
