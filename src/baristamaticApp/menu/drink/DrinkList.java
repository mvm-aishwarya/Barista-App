/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baristamaticApp.menu.drink;

import java.util.HashMap;

/**
 * List of drink recipes
 * @author Aishwarya
 */
public class DrinkList {

    private static HashMap<String, Integer> recipe = null;

    public static HashMap<String, Integer> CoffeeRecipe() {
        recipe = new HashMap<>();
        recipe.put("Coffee", 3);
        recipe.put("Sugar", 1);
        recipe.put("Cream", 1);

        return recipe;
    }

    public static HashMap<String, Integer> DecafCoffeeRecipe() {
        recipe = new HashMap<>();
        recipe.put("Decaf Coffee", 3);
        recipe.put("Sugar", 1);
        recipe.put("Cream", 1);

        return recipe;
    }

    public static HashMap<String, Integer> CafeLatteRecipe() {
        recipe = new HashMap<>();
        recipe.put("Espresso", 2);
        recipe.put("Steamed milk", 1);

        return recipe;
    }
    
    public static HashMap<String, Integer> CafeAmericanoRecipe() {
        recipe = new HashMap<>();
        recipe.put("Espresso", 3);        

        return recipe;
    }
    
    public static HashMap<String, Integer> CafeMochaRecipe() {
        recipe = new HashMap<>();
        recipe.put("Espresso", 1);
        recipe.put("Cocoa", 1);
        recipe.put("Steamed milk", 1);
        recipe.put("Whipped Cream", 1);

        return recipe;
    }
    
    public static HashMap<String, Integer> CappuccinoRecipe() {
        recipe = new HashMap<>();
        recipe.put("Espresso", 2);
        recipe.put("Steamed milk", 1);
        recipe.put("Foamed milk", 1);

        return recipe;
    }

}
