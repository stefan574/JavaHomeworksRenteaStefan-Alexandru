/*
 * RatingsSql Class
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
public class RatingsSql {
    
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:derby://localhost:1527/EBOOKS_DB";
    
    /**
     * INSERT INTO query for the RATINGS table
     * 
     * @param isbn is the Isbn of an ebook and part of the pk in the table
     * @param rating is the object that will be inserted in the table
     */
    static void insert(String isbn, Rating rating) {
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.execute("INSERT INTO ROOT.RATINGS "
                    + "(ISBN, USER_ID, DESCRIPTION, RATING)"
                    + " VALUES ('" + isbn + "', " + rating.getUserId()
                    + ", '" + rating.getDescription() + "', " + rating.getRating()
                    + ")");
            System.out.println("\nRating added to database!");
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
     * UPDATE query for the RATINGS table
     * 
     * @param isbn is the Isbn of an ebook and part of the pk in the table
     * @param rating is the object that will be inserted in the table
     */
    static void update(String isbn, Rating rating) {
        Connection connection = null;
        Statement statement = null;
        
        System.out.println("1. Rating\n2. Description\n\n"
                + "Which Field whould you like to UPDATE: ");
        
        int choice = new LegalValue().getLegalValue(2);
        
        String field = null;
        String newValue = null;
        switch(choice) {
            case 1 : 
                field = "RATING";
                newValue = new LegalValue().getLegalValue("Rating: ");
                break;
            case 2 :
                field = "DESCRIPTION";
                newValue = new LegalValue().getLegalValue("Description: ");
                break;
        }
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            if (choice == 1)
                statement.execute("UPDATE ROOT.RATINGS SET \"" + field + "\" = " + newValue + " WHERE ISBN = '" + isbn + "' AND USER_ID = " + rating.getUserId());
            else
                statement.execute("UPDATE ROOT.RATINGS SET \"" + field + "\" = '" + newValue + "' WHERE ISBN = '" + isbn + "' AND USER_ID = " + rating.getUserId());
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
     * DELETE query for the RATINGS table
     * 
     * @param isbn is the Isbn of an ebook and part of the pk in the table
     * @param rating is the object that will be inserted in the table
     */
    static void delete(String isbn, Rating rating) {
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.execute("DELETE FROM ROOT.RATINGS WHERE ISBN = '" + isbn + "' AND USER_ID = " + rating.getUserId());
            System.out.println("\nRating Deleted from Database!");
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
            resultSet = statement.executeQuery("SELECT * FROM ROOT.RATINGS");
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows)
                do {
                    System.out.println(resultSet.getString(1) + " "
                            + resultSet.getInt(2) + " "
                            + resultSet.getString(3) + " "
                            + resultSet.getDouble(4) + "\n");
                } while(resultSet.next());
            else
                System.out.println("RATINGS Table is Empty!");
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
