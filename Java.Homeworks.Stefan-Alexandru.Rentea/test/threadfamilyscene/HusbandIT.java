/*
 * Tests for Husband Class
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
public class HusbandIT {
    
    public HusbandIT() {
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
     * Test of run method, of class Husband.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testRun() throws InterruptedException {
        System.out.println("run");
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        
        Husband instance = new Husband(new Wife(new Cigar()), new VacuumCleaner());
        instance.start();
        instance.join(100);
        
        System.out.flush();
        
        assertTrue(baos.toString().contains("Husband started vacuuming")
                && baos.toString().contains("Husband is husbanding")
                && baos.toString().contains("Wife is sleeping")
                && baos.toString().contains("Vacuum cleaner is vacuuming")
                && baos.toString().contains("Cigar is cigaring"));
        
        System.setOut(System.out);
    }

    /**
     * Test of getShow method, of class Husband.
     */
    @Test
    public void testGetShow() {
        System.out.println("getShow");
        Husband instance = new Husband(new Wife(new Cigar()), new VacuumCleaner());
        Shows[] expResult = Shows.values();
        Shows result = instance.getShow();
        assertTrue(Arrays.toString(expResult).contains(result.toString()));
    }
    
}
