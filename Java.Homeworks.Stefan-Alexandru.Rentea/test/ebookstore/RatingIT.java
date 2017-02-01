/*
 * Tests for Rating Class
 */
package ebookstore;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan-Alexandru Rentea
 */
public class RatingIT {
    
    public RatingIT() {
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
     * Test of setDescription method, of class Rating.
     */
    @Test
    public void testSetDescription_0args() {
        System.out.println("setDescription");
        
        String parameters = "1" + "\n"
                + "1.0" + "\n"
                + " This book is very good!";
        System.setIn(new ByteArrayInputStream(parameters.getBytes()));
        Scanner scanner = new Scanner (System.in);
        
        int userId = Integer.parseInt(scanner.nextLine());
        double rating = Double.parseDouble(scanner.nextLine());
        String description = scanner.nextLine();
        
        Rating instance = new Rating(rating, userId, description);
        
        String data = "This book is very good!";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        
        String expResult = "This book is very good!";
        instance.setDescription();
        
        System.setIn(System.in);
        
        assertEquals(expResult, instance.getDescription());
    }

    /**
     * Test of setDescription method, of class Rating.
     */
    @Test
    public void testSetDescription_String() {
        System.out.println("setDescription");
        double rating = 1.0;
        int userId = 1;
        String description = "This book is very good!";
        Rating instance = new Rating(rating, userId, description);
        String expResult = "This book is very good!";
        instance.setDescription(description);
        assertEquals(expResult, instance.getDescription());
    }

    /**
     * Test of printRating method, of class Rating.
     */
    @Test
    public void testPrintRating() {
        System.out.println("printRating");
        double rating = 1.0;
        int userId = 1;
        String description = "This book is very good!";
        Rating instance = new Rating(rating, userId, description);
        String expResult = rating
                + "\nUser Id: " + userId
                + "\nDescription: " + description;
        String result = instance.printRating();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRating method, of class Rating.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        double rating = 1.0;
        int userId = 1;
        String description = "This book is very good!";
        Rating instance = new Rating(rating, userId, description);
        double expResult = 1.0;
        double result = instance.getRating();
        assertEquals(expResult, result, 1.0);
    }

    /**
     * Test of getDescription method, of class Rating.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        double rating = 1.0;
        int userId = 1;
        String description = "This book is very good!";
        Rating instance = new Rating(rating, userId, description);
        String expResult = "This book is very good!";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserId method, of class Rating.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        double rating = 1.0;
        int userId = 1;
        String description = "This book is very good!";
        Rating instance = new Rating(rating, userId, description);
        int expResult = 1;
        int result = instance.getUserId();
        assertEquals(expResult, result);
    }
    
}
