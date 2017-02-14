/*
 * Tests for FamilySceneMain Class
 */
package threadfamilyscene;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Stefan-Alexandru Rentea
 */
public class FamilySceneMainIT {
    
    public FamilySceneMainIT() {
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
     * Test of main method, of class FamilySceneMain.
     * @throws java.lang.InterruptedException
     */
    @Test
    public void testMain() throws InterruptedException {
        System.out.println("main");
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        
        String[] args = null;
        FamilySceneMain.main(args);
        
        System.out.flush();
        
        TimeUnit.MILLISECONDS.sleep(100);
        
        assertTrue(baos.toString().contains("Husband started vacuuming")
                && baos.toString().contains("Vacuum cleaner is vacuuming")
                && baos.toString().contains("Curent show: ")
                && baos.toString().contains("Cigar is cigaring")
                && baos.toString().contains("Wife is sleeping")
                && baos.toString().contains("Husband is husbanding"));
        
        System.setOut(System.out);
    }
    
}
