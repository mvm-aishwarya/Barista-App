/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    SingleMenu menuInstance = null;
    HashMap<String, Integer> recipe1 = null;
    
    public SingleMenuTest() {
        menuInstance = SingleMenu.getInstance();
        menuInstance.initializeMenu();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        recipe1 = new HashMap<String, Integer>();
        recipe1.put("Coffee", 3);
        recipe1.put("Sugar", 1);
        recipe1.put("Cream", 1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetDrinkCost(){        
        System.out.println("\n---------- getDrinkCost ----------");
        
        String expResult = "$2.75";        
        String resultString = menuInstance.getDrinkCost(recipe1);
        assertTrue(resultString.compareToIgnoreCase(expResult) == 0);
    }
    
    @Test
    public void testGetMenuDetails() {
        System.out.println("---------- getMenuDetails ----------"); 
        
        String expResult = "";        
        String result = menuInstance.getMenuDetails();        
        assertTrue(result.length() > expResult.length());
    }
    
    
}
