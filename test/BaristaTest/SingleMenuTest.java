package BaristaTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import baristamaticApp.inventory.SingleInventory;
import baristamaticApp.menu.MenuItem;
import baristamaticApp.menu.SingleMenu;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aishwarya
 */
public class SingleMenuTest {

    private static SingleMenu menuInstance = null;
    private static SingleInventory inventoryInstance = null;
    private static HashMap<String, Integer> recipe1 = null;
    private static MenuItem mItem = null;

    public SingleMenuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        menuInstance = SingleMenu.getInstance();
        inventoryInstance = SingleInventory.getInstance();
        menuInstance.initializeMenu();
        recipe1 = new HashMap<>();
        recipe1.put("Coffee", 3);
        recipe1.put("Sugar", 1);
        recipe1.put("Cream", 1);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test Menu details display
     */
    @Test
    public void testGetMenuDetails() {
        System.out.println("---------- getMenuDetails ----------");

        String expResult = "";
        String result = menuInstance.getMenuDetails();
        assertTrue(result.length() > expResult.length());
    }

    /**
     * Test Given a recipe, it should provide the cost
     */
    @Test
    public void testGetDrinkCost() {
        System.out.println("---------- getDrinkCost ----------");

        String expResult = "$2.75";
        String resultString = menuInstance.getDrinkCost(recipe1);
        assertTrue(resultString.compareToIgnoreCase(expResult) == 0);
    }

    /**
     * Test Reduce resources and refill to check refill function
     */
    @Test
    public void testReInitializeStock() {
        System.out.println("---------- reinitializeStock ----------");

        System.out.print("\nStock initialized. \n");
        System.out.println(inventoryInstance.getInventoryDetails());

        menuInstance.reduceResource(recipe1);

        System.out.print("\nResource reduced. \n");
        System.out.println(inventoryInstance.getInventoryDetails());

        menuInstance.reinitializeInventoryStock();

        System.out.print("\nRefilled: \n");
        System.out.println(inventoryInstance.getInventoryDetails());
    }
    
    /**
     * Test Given a recipe, check if the ingredients are in stock
     */
    @Test
    public void testIsDrinkInStock(){
        System.out.println("---------- IsDrinkInStock ----------");
        boolean expResult = true;        
        boolean result = menuInstance.isDrinkInStock(recipe1);
        assertEquals(expResult, result);
    }
    
    /**
     * Test Dispense drink until it becomes out of stock and display the menu and inventory
     */
    @Test
    public void testDispenseDrink() {
        int count = 0;
        System.out.println("---------- dispenseDrink ----------");

        System.out.print("\nInitial menu and inventory \n");
        System.out.println(menuInstance.getMenuDetails());

        mItem = menuInstance.getObjListMenuItem().get(0);
                
        while(true){              
        System.out.println(menuInstance.dispenseDrink(mItem));                        
        count++;
        if(count == 10)
            break;
        }
        
        System.out.print("\nMenu and inventory after dispenseDrink\n");
        System.out.println(menuInstance.getMenuDetails());
                 
    }

}
