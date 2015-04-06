/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baristamaticApp;

import baristamaticApp.menu.MenuItem;
import baristamaticApp.menu.SingleMenu;
import java.util.Scanner;

/**
 * Class which has the main function that implements the BaristaApp functionalities.
 * Creates a SingleMenu instance. Dispenses selected drink if available. 
 * Quits when user types 'q'|'Q'. Refills stock when user types 'r'|'R'
 * @author Aishwarya
 */
public class BaristamaticApp {
   
    private static final String ENTER_CHOICE = "\nInput: ";
    private static final String QUIT_MESSAGE = "\nQuit Baristamatic successful! ";
    private static final String RESTOCK_MESSAGE = "\nRe-stock inventory successful! ";
    private static final String EXCEPTION_MESSAGE = "\nException: ";
    private static final String INVALID_MESSAGE = "\nInvalid entry: ";
    private static final String EMPTY_STRING = "";

    //Single Menu - Singleton   
    private static SingleMenu objSingleMenu = null;
    private static Scanner scanner = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Create SingleMenu instance and initialize   
        objSingleMenu = SingleMenu.getInstance();
        objSingleMenu.initializeMenu();

        //Start here
        boolean isQuit = false;
        
        //Print general instructions for the user
        System.out.println(userGeneralInstruction());
                
        scanner = new Scanner(System.in);
        while (true) {
            StringBuilder builderAllDetail = new StringBuilder();
            
            //Get menu details from SingleMenu instance
            builderAllDetail.append(objSingleMenu.getMenuDetails());
            builderAllDetail.append(ENTER_CHOICE);
            
            System.out.println(builderAllDetail);

            String userSelection = "";
            try {
                //user i/p
                while (userSelection.equals(EMPTY_STRING)) {
                    userSelection = scanner.nextLine();
                }
            } catch (NullPointerException nex) {
                System.out.println(EXCEPTION_MESSAGE + nex);
            } catch (Exception e) {
                System.out.println(EXCEPTION_MESSAGE + e);
            }
            
            String messageToDisplay = "";
            MenuItem drink;
            int menuItemLength = objSingleMenu.getObjListMenuItem().size();
            /**
             * OPTIMIZED: From the user input I can directly pass the index to the ArrayList in SingleMenu. 
             * Since the ArrayList<MenuItem> is already sorted, I can use this efficiently to pass the exact index which fetches the result in constant time.
             */
            if (userSelection.length() == 1) {
                if ("q".equals(userSelection) || "Q".equals(userSelection)) {
                    isQuit = true;
                    messageToDisplay = QUIT_MESSAGE;
                } else if ("r".equals(userSelection) || "R".equals(userSelection)) {
                    objSingleMenu.initializeInventoryStock();
                    messageToDisplay = RESTOCK_MESSAGE;
                } else if (Character.getNumericValue(userSelection.charAt(0)) <= menuItemLength && Character.getNumericValue(userSelection.charAt(0)) > 0) {
                    drink = objSingleMenu.getObjListMenuItem().get(Integer.parseInt(userSelection) - 1);
                    messageToDisplay = objSingleMenu.dispenseDrink(drink);
                } else {
                    messageToDisplay = INVALID_MESSAGE + userSelection;
                }
            } else {
                messageToDisplay = INVALID_MESSAGE + userSelection;
            }
            
            //Check each drink availability after a specific drink is dispensed.
            objSingleMenu.checkAllDrinkAvailability();

            if (!messageToDisplay.isEmpty()) {
                System.out.println(messageToDisplay);
            }

            if (isQuit) {
                break;
            }

        } 
        scanner.close();

    }

    /**
     * Provides a general navigation instruction for user
     *
     * @return String which has the general instruction.
     */
    private static String userGeneralInstruction() {

        StringBuilder builderInstruction = new StringBuilder();
        builderInstruction.append("\nWelcome to Baritamatic");
        builderInstruction.append("\nEnter the number to choose your drink.");
        builderInstruction.append("\nEnter 'R' or 'r' to restock the inventory.");
        builderInstruction.append("\nEnter 'Q' or 'q' to quit the application.\n");

        return builderInstruction.toString();
    }

}
