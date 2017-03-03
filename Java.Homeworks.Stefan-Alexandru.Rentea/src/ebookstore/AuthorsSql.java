/*
 * AuthorsSql
 */
package ebookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Stefan-Alexandru Rentea
 */
public class AuthorsSql {
    
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:derby://localhost:1527/EBOOKS_DB";
    
    /**
     * INSERT INTO query for AUTHORS table
     * 
     * @param isbn is the Isbn of an ebook and part of the pk in the table
     * @param author is the object that will be inserted in the table
     */
    static void insert(String isbn, Author author) {
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.execute("INSERT INTO ROOT.AUTHORS "
                    + "(ISBN, ID, FIRST_NAME, LAST_NAME)"
                    + " VALUES ('" + isbn + "', " + author.getId() 
                    + ", '" + author.getFirstName() + "', '" + author.getFamilyName()
                    + "')");
            System.out.println("\nAuthor added to database!");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if (statement != null)
                try {
                    statement.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
            if (connection != null)
                try {
                    connection.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
        }
    }
    
    /**
     * UPDATE query for the AUTHORS table
     * 
     * @param isbn is the Isbn of an ebook and part of the pk in the table
     * @param author is the object that will be inserted in the table
     */
    static void update(String isbn, Author author) {
        Connection connection = null;
        Statement statement = null;
        
        System.out.println("1. FirstName\n2. LastName\n\n"
                + "Which Field whould you like to UPDATE: ");
        
        int choice = new LegalValue().getLegalValue(2);
        
        String field = null;
        String newValue = null;
        switch(choice) {
            case 1 : 
                field = "FIRST_NAME";
                newValue = new LegalValue().getLegalValue("First Name: ");
                break;
            case 2 :
                field = "LAST_NAME";
                newValue = new LegalValue().getLegalValue("Family Name: ");
                break;
        }
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.execute("UPDATE ROOT.AUTHORS SET \"" + field + "\" = '" + newValue + "' WHERE ISBN = '" + isbn + "' AND ID = " + author.getId());
            System.out.println("\nField Modified!");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if (statement != null)
                try {
                    statement.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
            if (connection != null)
                try {
                    connection.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
        }
    }
    
    /**
     * DELETE query for the AUTHORS table
     * 
     * @param isbn is the Isbn of an ebook and part of the pk in the table
     * @param author is the object that will be inserted in the table
     */
    static void delete(String isbn, Author author) {
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.execute("DELETE FROM ROOT.AUTHORS WHERE ISBN = '" + isbn + "' AND ID = " + author.getId());
            System.out.println("\nAuthor Deleted from Database!");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if (statement != null)
                try {
                    statement.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
            if (connection != null)
                try {
                    connection.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
        }
    }
    
    static void select() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ROOT.AUTHORS");
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows)
                do {
                    System.out.println(resultSet.getString(1) + " "
                            + resultSet.getInt(2) + " "
                            + resultSet.getString(3) + " "
                            + resultSet.getString(4) + "\n");
                } while(resultSet.next());
            else
                System.out.println("AUTHORS Table is Empty!");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            if (statement != null)
                try {
                    statement.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
            if (connection != null)
                try {
                    connection.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex);
                }
        }
    }
    
}
