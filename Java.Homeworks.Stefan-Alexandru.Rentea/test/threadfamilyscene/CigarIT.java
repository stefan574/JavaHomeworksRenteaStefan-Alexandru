/*
 * Tests for Cigar Class
 */
package threadfamilyscene;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Stefan-Alexandru Rentea
 */
public class CigarIT {
    
    public CigarIT() {
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
     * Test of run method, of class Cigar.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testRun() throws InterruptedException {
        System.out.println("run");
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        
        Cigar instance = new Cigar();
        instance.start();
        instance.join(100);
        
        System.out.flush();
        
        assertTrue(baos.toString().contains("Cigar is cigaring"));
        
        System.setOut(System.out);
    }
    
}
