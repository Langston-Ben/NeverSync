/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.neversnyc.control;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author benjaminlangston
 */
public class PlantControlTest {
    
    public PlantControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcBushelsToPlant method, of class PlantControl.
     */
    @Test
    public void testCalcBushelsToPlant() {
        System.out.println("calcBushelsToPlant");
        System.out.println("\tTest Case #1");
        double acresOwned = 500;
        double acresToPlant = 400;
        double initWheatStorage = 300;
        double expResult = 70.0;
        double result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    static {
        System.out.println("\tTest Case #2");
        double acresOwned = 500;
        double acresToPlant = 0;
        double initWheatStorage = 300;
        double expResult = -1;
        double result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    static {
        System.out.println("\tTest Case #3");
        double acresOwned = 500;
        double acresToPlant = 1004;
        double initWheatStorage = 5;
        double expResult = -1;
        double result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    static {
        System.out.println("\tTest Case #4");
        double acresOwned = 500;
        double acresToPlant = 300;
        double initWheatStorage = 0;
        double expResult = -1;
        double result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    static {
        System.out.println("\tTest Case #5");
        double acresOwned = 1000;
        double acresToPlant = 100;
        double initWheatStorage = 110;
        double expResult = 49;
        double result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    static {
        System.out.println("\tTest Case #6");
        double acresOwned = 2000;
        double acresToPlant = 1000;
        double initWheatStorage = 560;
        double expResult = 4;
        double result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    static {
        System.out.println("\tTest Case #7");
        double acresOwned = 2000;
        double acresToPlant = 1000;
        double initWheatStorage = 600;
        double expResult = 40;
        double result = PlantControl.calcBushelsToPlant(acresOwned, acresToPlant, initWheatStorage);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");

    }
    
}
