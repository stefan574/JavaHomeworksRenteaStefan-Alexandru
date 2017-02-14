/*
 * Tests for Wife Class
 */
package threadfamilyscene;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Stefan-Alexandru Rentea
 */
public class WifeIT {
    
    public WifeIT() {
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
     * Test of run method, of class Wife.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testRun() throws InterruptedException {
        System.out.println("run");
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        
        Wife instance = new Wife(new Cigar());
        instance.start();
        instance.join(100);
        
        System.out.flush();
        
        assertTrue(baos.toString().contains("Wife is sleeping")
                && baos.toString().contains("Cigar is cigaring"));
        
        System.setOut(System.out);
    }

    /**
     * Test of getShow method, of class Wife.
     */
    @Test
    public void testGetShow() {
        System.out.println("getShow");
        Wife instance = new Wife(new Cigar());
        Shows[] expResult = Shows.values();
        Shows result = instance.getShow();
        assertTrue(Arrays.toString(expResult).contains(result.toString()));
    }
    
}
