package BaristaTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import baristamaticApp.inventory.SingleInventory;
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
public class SingleInventoryTest {
    
    private static SingleInventory inventoryInstance = null;
    
    public SingleInventoryTest() {       
    }
    
    @BeforeClass
    public static void setUpClass() {
        inventoryInstance = SingleInventory.getInstance();
        inventoryInstance.initializePrice();
        inventoryInstance.initializeStock();
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
     * Single Inventory: Get details of inventory items to display
     */
    @Test
    public void testGetInventoryDetails() {
        System.out.println("---------- getInventoryDetails ----------"); 
        
        String expResult = "";        
        String result = inventoryInstance.getInventoryDetails();
        assertTrue(result.length() > expResult.length());       
    }
        
       
}
