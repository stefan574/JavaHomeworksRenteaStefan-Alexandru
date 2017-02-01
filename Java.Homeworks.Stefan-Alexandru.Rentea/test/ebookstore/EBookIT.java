/*
 * Test for EBook Class
 */
package ebookstore;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class EBookIT {
    
    public EBookIT() {
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
     * Test of getRating method, of class EBook.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        String expResult = "3.0";
        String result = instance.getRating();
        assertEquals(expResult, result);
    }

    /**
     * Test of printListOfAuthors method, of class EBook.
     */
    @Test
    public void testPrintListOfAuthors() {
        System.out.println("printListOfAuthors");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        
        int id = 1;
        String firstName = "Steven";
        String familyName = "Alexander";
        Author author = new Author(id, firstName, familyName);
        instance.getListOfAuthors().add(author);
        
        String expResult = "Author: " + firstName + " " + familyName + ", id: " + id + "\n";
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        
        instance.printListOfAuthors();
        System.out.flush();
        
        assertEquals(expResult, baos.toString());
        
        System.setOut(System.out);
    }

    /**
     * Test of addRating method, of class EBook.
     */
    @Test
    public void testAddRating() {
        System.out.println("addRating");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        double newRating = 1.0;
        instance.addRating(newRating);
        String expResult = "2.0";
        assertEquals(expResult, instance.getRating());
    }

    /**
     * Test of getIsbnValue method, of class EBook.
     */
    @Test
    public void testGetIsbnValue() {
        System.out.println("getIsbnValue");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        String expResult = "361-5278-487925525-111251";
        String result = instance.getIsbn();
        assertEquals(expResult, result);
        
        // regex test for the random value isbn
        Pattern pattern = Pattern.compile("[0-9]{3}[-][0-9]{4}[-][0-9]{9}[-][0-9]{6}");
        Matcher matcher = pattern.matcher(instance.getIsbn());
        boolean bool = matcher.matches();
        assertTrue(bool);
    }

    /**
     * Test of printEBook method, of class EBook.
     */
    @Test
    public void testPrintEBook() {
        System.out.println("printEBook");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        String expResult = "Title: " + title + ", ISBN: " + isbn;
        String result = instance.printEBook();
        assertEquals(expResult, result);
    }

    /**
     * Test of printDetailedEBook method, of class EBook.
     */
    @Test
    public void testPrintDetailedEBook() {
        System.out.println("printDetailedEBook");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        instance.printDetailedEBook();
    }

    /**
     * Test of getTitle method, of class EBook.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        String expResult = "The Secret Book Of Secrets";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfPages method, of class EBook.
     */
    @Test
    public void testGetNumberOfPages() {
        System.out.println("getNumberOfPages");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        int expResult = 300;
        int result = instance.getNumberOfPages();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class EBook.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        double expResult = 450.50;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getIsbn method, of class EBook.
     */
    @Test
    public void testGetIsbn() {
        System.out.println("getIsbn");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        String expResult = "361-5278-487925525-111251";
        String result = instance.getIsbn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfRatings method, of class EBook.
     */
    @Test
    public void testGetListOfRatings() {
        System.out.println("getListOfRatings");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        
        List<Double> expResult = new ArrayList<>();
        expResult.add(rating);
        
        List<Double> result = instance.getListOfRatings();
        if (expResult.size() == 1 && result.size() == 1)
            assertEquals(expResult.get(0), result.get(0));
        else
            fail("Test Failed!");
    }

    /**
     * Test of getListOfAuthors method, of class EBook.
     */
    @Test
    public void testGetListOfAuthors() {
        System.out.println("getListOfAuthors");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        
        List<Author> expResult = new ArrayList<>();
        int id = 1;
        String firstName = "Steven";
        String familyName = "Alexander";
        Author author = new Author(id, firstName, familyName);
        expResult.add(author);
        
        List<Author> result = instance.getListOfAuthors();
        result.add(author);
        if (expResult.size() == 1 && result.size() == 1)
            assertEquals(expResult.get(0), result.get(0));
        else
            fail("Test Failed!");
    }

    /**
     * Test of getSpecialField method, of class EBook.
     */
    @Test
    public void testGetSpecialField() {
        System.out.println("getSpecialField");
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        double rating = 3.0;
        EBook instance = new EBookImpl(isbn, title, numberOfPages, price, rating);
        String expResult = "Special Field";
        String result = instance.getSpecialField();
        assertEquals(expResult, result);
    }

    public class EBookImpl extends EBook {

        EBookImpl(String isbn, String title, int numberOfPages, double price, double rating) {
            super(isbn, title, numberOfPages, price, rating);
        }
        
        @Override
        public String getSpecialField() {
            return "Special Field";
        }
    }
    
}
