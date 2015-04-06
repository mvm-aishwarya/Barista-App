/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baristamaticv2;

import baristamaticv2.menu.MenuItem;
import baristamaticv2.menu.SingleMenu;
import java.util.Scanner;

/**
 *
 * @author Aishwarya
 */
public class BaristamaticV2 {

    private static final String ENTER_CHOICE = "\nInput: ";
    //Single Menu - Singletons    
    private static SingleMenu objSingleMenu = null;
    private static Scanner scanner = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        objSingleMenu = SingleMenu.getInstance();

        objSingleMenu.initializeMenu();

        //Start here
        boolean isQuit = false;
        int userInput = 0;
        System.out.println(userGeneralInstruction());
        scanner = new Scanner(System.in);
        while (true) {
            StringBuilder builderAllDetail = new StringBuilder();            
            builderAllDetail.append(objSingleMenu.getMenuDetails());
            builderAllDetail.append(ENTER_CHOICE);
            System.out.println(builderAllDetail);

            String userSelection = "";
            try {
                //user i/p
                userSelection = scanner.nextLine();

                //always get the first character and convert to numeric.
                userInput = Character.getNumericValue(userSelection.charAt(0));
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
            String messageToDisplay = "";
            MenuItem drink;
            switch (userInput) {
                case 1:
                    drink = objSingleMenu.getObjListMenuItem().get(0);
                    messageToDisplay = objSingleMenu.dispenseDrink(drink);
                    break;
                case 2:
                    drink = objSingleMenu.getObjListMenuItem().get(1);
                    messageToDisplay = objSingleMenu.dispenseDrink(drink);                    
                    break;
                case 3:
                    drink = objSingleMenu.getObjListMenuItem().get(2);
                    messageToDisplay = objSingleMenu.dispenseDrink(drink);
                    break;
                case 4:
                    drink = objSingleMenu.getObjListMenuItem().get(3);
                    messageToDisplay = objSingleMenu.dispenseDrink(drink);
                    break;
                case 5:
                    drink = objSingleMenu.getObjListMenuItem().get(4);
                    messageToDisplay = objSingleMenu.dispenseDrink(drink);
                    break; 
                case 6:
                    drink = objSingleMenu.getObjListMenuItem().get(5);
                    messageToDisplay = objSingleMenu.dispenseDrink(drink);
                    break;

                //case 81:
                case 26:
                    isQuit = true;
                    System.out.println("\nQuitting!!");
                    break;

                case 27:
                    objSingleMenu.initializeInventoryStock();
                    System.out.println("\nStock refilled!");
                    break;
                default:
                    messageToDisplay = "Invalid entry " + userSelection;
            }
            
            objSingleMenu.checkAllDrinkAvailability();

            if (isQuit) {
                break;
            }

            if (!messageToDisplay.isEmpty()) {
                System.out.println("\n" + messageToDisplay);
            }                      
        }

    }
    
     /**
     * Provides a general navigation instruction for user
     * @return 
     */
    private static String userGeneralInstruction(){
        
        StringBuilder builderInstruction = new StringBuilder();       
        builderInstruction.append("\nWelcome to Baritamatic\n");
        builderInstruction.append("\nEnter numbers from [1-6] to choose your drink.\n");
        builderInstruction.append("\nEnter 'R' or 'r' to restock the inventory.\n");
        builderInstruction.append("\nEnter 'Q' or 'q' to quit the application.\n");
        
        return builderInstruction.toString();
    }

}
