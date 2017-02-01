/*
 * Tests for Author Class
 */
package ebookstore;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Stefan-Alexandru Rentea
 */
public class AuthorIT {
    
    public AuthorIT() {
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
     * Test of printAuthor method, of class Author.
     */
    @Test
    public void testPrintAuthor() {
        System.out.println("printAuthor");
        
        String parameters = "1\nSteven\nAlexander";
        ByteArrayInputStream bais = new ByteArrayInputStream(parameters.getBytes());
        System.setIn(bais);
        Scanner scanner = new Scanner(System.in);
        
        int id = Integer.parseInt(scanner.nextLine());
        String firstName = scanner.nextLine();
        String familyName = scanner.nextLine();
        
        Author instance = new Author(id, firstName, familyName);
        String expResult = firstName + " " + familyName + ", id: " + id + "\n";
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        
        instance.printAuthor();
        System.out.flush();
        assertEquals(expResult, baos.toString());
        
        System.setIn(System.in);
        System.setOut(System.out);
    }

    /**
     * Test of getFirstName method, of class Author.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        int id = 1;
        String firstName = "Steven";
        String familyName = "Alexander";
        Author instance = new Author(id, firstName, familyName);
        String expResult = "Steven";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFamilyName method, of class Author.
     */
    @Test
    public void testGetFamilyName() {
        System.out.println("getFamilyName");
        int id = 1;
        String firstName = "Steven";
        String familyName = "Alexander";
        Author instance = new Author(id, firstName, familyName);
        String expResult = "Alexander";
        String result = instance.getFamilyName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Author.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int id = 1;
        String firstName = "Steven";
        String familyName = "Alexander";
        Author instance = new Author(id, firstName, familyName);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }
    
}
