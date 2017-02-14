/*
 * Tests for Television Class
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
public class TelevisionIT {
    
    public TelevisionIT() {
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
     * Test of run method, of class Television.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testRun() throws InterruptedException {
        System.out.println("run");
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        
        Television instance = new Television(
                new Husband(new Wife(new Cigar()), new VacuumCleaner()));
        instance.start();
        instance.join(100);
        
        System.out.flush();
        
        assertTrue(baos.toString().contains("Husband started vacuuming")
                && baos.toString().contains("Vacuum cleaner is vacuuming")
                && baos.toString().contains("Curent show: ")
                && baos.toString().contains("Cigar is cigaring")
                && baos.toString().contains("Wife is sleeping")
                && baos.toString().contains("Husband is husbanding"));
        
        System.setOut(System.out);
    }
    
}
