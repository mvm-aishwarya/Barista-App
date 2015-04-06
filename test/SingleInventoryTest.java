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
    
    SingleInventory itemInstance = null;
    
    public SingleInventoryTest() {
        itemInstance = SingleInventory.getInstance();
        itemInstance.initializePrice();
        itemInstance.initializeStock();
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    @Test
    public void testGetInventoryDetails() {
        System.out.println("---------- getInventoryDetails ----------"); 
        
        String expResult = "";        
        String result = itemInstance.getInventoryDetails();
        assertTrue(result.length() > expResult.length());
    }
       
}
