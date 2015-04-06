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
 *
 * @author Aishwarya
 */
public class BaristamaticApp {

    private static final String ENTER_CHOICE = "\nInput: ";
    private static final String QUIT_MESSAGE = "\nQuit Baristamatic successfult! ";
    private static final String RESTOCK_MESSAGE = "\nRe-stock inventory successful! ";
    //Single Menu - Singleton   
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
                //userInput = Character.getNumericValue(userSelection.charAt(0));
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
            String messageToDisplay = "";
            MenuItem drink;
            int menuItemLength = objSingleMenu.getObjListMenuItem().size();
            if("q".equals(userSelection)||"Q".equals(userSelection)){
                 isQuit = true;
                 messageToDisplay = QUIT_MESSAGE;
                
            } else if("r".equals(userSelection)||"R".equals(userSelection)){
                objSingleMenu.initializeInventoryStock();
                messageToDisplay = RESTOCK_MESSAGE;
            }
            else if(Character.getNumericValue(userSelection.charAt(0))<= menuItemLength){
                 drink = objSingleMenu.getObjListMenuItem().get(Integer.parseInt(userSelection) - 1);
                 messageToDisplay = objSingleMenu.dispenseDrink(drink);
            }
            else{
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
