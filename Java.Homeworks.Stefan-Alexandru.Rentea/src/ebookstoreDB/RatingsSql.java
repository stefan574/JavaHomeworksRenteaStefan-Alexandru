/*
 * RatingsSql Class
 */
package ebookstoreDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    static void delete() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ROOT.RATINGS");
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                List<String> rows = new ArrayList<>();
                int i = 0;
                do {
                    if (!rows.contains(resultSet.getString(1) + resultSet.getInt(2))) {
                        rows.add(resultSet.getString(1) + resultSet.getInt(2));
                        System.out.println(++i + ": " + resultSet.getString(1)
                                + ", description: " + resultSet.getString(3)
                                + ", rating: " + resultSet.getString(4));
                    }
                } while(resultSet.next());

                int choice = new LegalValue().getLegalValue(i);

                statement.execute("DELETE FROM ROOT.RATINGS WHERE ISBN = '"
                        + rows.get(choice - 1).substring(0, 15)
                        + "' AND USER_ID = " + rows.get(choice - 1).substring(15));

                adjustRating(rows.get(choice - 1).substring(0, 15));
                
                System.out.println("Rating Deleted!");
            }
            else
                System.out.println("Ratings Table is Empty!");
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
    
    static void select(String isbn) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            if (isbn == null)
                resultSet = statement.executeQuery("SELECT * FROM ROOT.RATINGS");
            else
                resultSet = statement.executeQuery("SELECT * FROM ROOT.RATINGS WHERE ISBN = '" + isbn + "'");
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                int i = 0;
                do {
                    if (isbn == null)
                        System.out.println("Rating_" + (++i) + ":\n"
                                + "\tIsbn: " + resultSet.getString(1) + "\n"
                                + "\tUserId: " + resultSet.getInt(2) + "\n"
                                + "\tDescription: " + resultSet.getString(3) + "\n"
                                + "\tRating: " + resultSet.getDouble(4));
                    else 
                        System.out.println("Rating_" + (++i) + ":\n"
                                + "\tUserId: " + resultSet.getInt(2) + "\n"
                                + "\tDescription: " + resultSet.getString(3) + "\n"
                                + "\tRating: " + resultSet.getDouble(4));
                } while(resultSet.next());
                System.out.println();
            }
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
    
    static boolean adjustRating(String isbn) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ROOT.RATINGS WHERE ISBN = '" + isbn + "'");
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                List<Double> rows = new ArrayList<>();
                do {
                    rows.add(resultSet.getDouble(4));
                } while(resultSet.next());
                
                double newValue = 0;
                newValue = rows.stream().map((_double) -> _double)
                        .reduce(newValue, (accumulator, _item) -> accumulator + _item);
                newValue = new DoublePrecision().doPrecisionRating(new DoublePrecision().doPrecision(newValue/rows.size(), 2));
                
                statement.execute("UPDATE ROOT.EBOOKS SET \"RATING\" = " + newValue + " WHERE ISBN = '" + isbn + "'");
            }
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
        return false;
    }
    
}
