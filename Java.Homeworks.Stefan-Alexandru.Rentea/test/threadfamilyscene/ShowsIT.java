/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadfamilyscene;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class ShowsIT {
    
    public ShowsIT() {
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

    /**
     * Test of values method, of class Shows.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Shows[] expResult = {Shows.THE_VOICE, Shows.X_FACTOR, Shows.BRIDE_FOR_MY_BOY, Shows.PROTV_NEWS, Shows.MASTER_CHEF};
        Shows[] result = Shows.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class Shows.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "THE_VOICE";
        Shows expResult = Shows.THE_VOICE;
        Shows result = Shows.valueOf(name);
        assertEquals(expResult, result);
    }
    
}
