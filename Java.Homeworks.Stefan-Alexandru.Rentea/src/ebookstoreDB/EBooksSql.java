/*
 * EBooksSql Class
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
public class EBooksSql {
    
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:derby://localhost:1527/EBOOKS_DB";
    
    /**
     * INSERT INTO query for the EBOOKS table
     * 
     * @param ebook is the object that will be inserted in the table
     */
    static void insert(EBook ebook) {
        Connection connection = null;
        Statement statement = null;

        int type = 0;
        switch(ebook.getSpecialField()) {
            case "Novel Type: SF" :
            case "Novel Type: ROMANTIC" :
            case "Novel Type: ACTION" :
            case "Novel Type: COMEDY" :
            case "Novel Type: THRILLER" :
                type = 1;
                break;
            case "Subject: ADMINISTRATING" :
            case "Subject: SECURITY" :
            case "Subject: NETWORKS" :
            case "Subject: ELEARNING" :
            case "Subject: PROGRAMMING" :
                type = 2;
                break;
            case "Paper Quality: VERY_BAD" :
            case "Paper Quality: BAD" :
            case "Paper Quality: NORMAL" :
            case "Paper Quality: GOOD" :
            case "Paper Quality: VERY_GOOD" :
                type = 3;
                break;
        }
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.execute("INSERT INTO ROOT.EBOOKS "
                    + "(ISBN, TITLE, NUMBER_OF_PAGES, PRICE, RATING, TYPE)"
                    + " VALUES ('" + ebook.getIsbn() + "', '" + ebook.getTitle() 
                    + "', " + ebook.getNumberOfPages() + ", " + ebook.getPrice() 
                    + ", " + ebook.getActualRating() + ", " + type
                    + ")");
            System.out.println("\nEBook added to database!");
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
     * UPDATE query for the EBOOKS table
     * 
     * @param ebook is the object that will be inserted in the table
     */
    static void update(EBook ebook) {
        Connection connection = null;
        Statement statement = null;
        
        System.out.println("1. Title\n2. NumberOfPages\n3. Price\n\n"
                + "Which Field whould you like to UPDATE: ");
        
        int choice = new LegalValue().getLegalValue(3);
        
        String field = null;
        String newValue = null;
        switch(choice) {
            case 1 : 
                field = "TITLE";
                newValue = new LegalValue().getLegalValue("Title: ");
                break;
            case 2 :
                field = "NUMBER_OF_PAGES";
                newValue = new LegalValue().getLegalValue("Number of Pages: ");
                break;
            case 3 :
                field = "PRICE";
                newValue = new LegalValue().getLegalValue("Price: ");
                break;
        }
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            if (choice == 1)
                statement.execute("UPDATE ROOT.EBOOKS SET \"" + field + "\" = '" + newValue + "' WHERE ISBN = '" + ebook.getIsbn() + "'");
            else
                statement.execute("UPDATE ROOT.EBOOKS SET \"" + field + "\" = " + newValue + " WHERE ISBN = '" + ebook.getIsbn() + "'");
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
    
    static void selectSorted() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        System.out.println("1. Price\n2. Rating\n3. Both\n\n"
                + "Which Field whould you like to sort by: ");
        
        int choice = new LegalValue().getLegalValue(3);
        
        String field = null;
        switch(choice) {
            case 1 : 
                field = "PRICE";
                break;
            case 2 :
                field = "RATING";
                break;
            case 3 :
                field = "PRICE, RATING";
                break;
        }
        
        System.out.println();
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select EBOOKS.ISBN, EBOOKS.TITLE, "
                    + "EBOOKS.NUMBER_OF_PAGES, EBOOKS.PRICE, EBOOKS.RATING, "
                    + "TYPES.NAME as TYPE from EBOOKS join TYPES "
                    + "on EBOOKS.TYPE = TYPES.ID ORDER BY " + field);
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                int i = 0;
                do {
                    System.out.println("EBook_" + (++i) + ":\n"
                            + "\tIsbn: " + resultSet.getString(1) + "\n"
                            + "\tTitle: " + resultSet.getString(2) + "\n"
                            + "\tNumber of Pages: " + resultSet.getInt(3) + "\n"
                            + "\tPrice: " + resultSet.getDouble(4) + "\n"
                            + "\tRating: " + resultSet.getDouble(5) + "\n"
                            + "\tType: " + resultSet.getString(6));
                    AuthorsSql.select(resultSet.getString(1));
                    RatingsSql.select(resultSet.getString(1));
                } while(resultSet.next());
            }
            else
                System.out.println("EBOOKS Table is Empty!");
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
    
    static void delete() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        System.out.println();
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ROOT.EBOOKS");
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                List<String> rows = new ArrayList<>();
                int i = 0;
                do {
                    rows.add(resultSet.getString(1));
                    System.out.println(++i + ": " + resultSet.getString(1)
                            + ", " + resultSet.getString(2));
                } while(resultSet.next());
                
                int choice = new LegalValue().getLegalValue(i);
                
                statement.execute("DELETE FROM ROOT.EBOOKS WHERE ISBN = '" + rows.get(choice - 1) + "'");
                statement.execute("DELETE FROM ROOT.AUTHORS WHERE ISBN = '" + rows.get(choice - 1) + "'");
                statement.execute("DELETE FROM ROOT.RATINGS WHERE ISBN = '" + rows.get(choice - 1) + "'");
                
                System.out.println("EBook Deleted!");
            }
            else
                System.out.println("EBOOKS Table is Empty!");
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
    
    static void addRatingToEBook() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM EBOOKS");
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                List<String> rows = new ArrayList<>();
                int i = 0;
                do {
                    System.out.println((++i) + ": " + resultSet.getString(1));
                    rows.add(resultSet.getString(1));
                } while(resultSet.next());
                
                int choice = new LegalValue().getLegalValue(i);
                Rating rating = new Rating();
                if (RatingsSql.verifyExistenceOfUserRating(rows.get(choice - 1), rating.getUserName())) {
                    RatingsSql.insert(rows.get(choice - 1), rating);
                    RatingsSql.adjustRating(rows.get(choice - 1));
                }
                else
                    System.out.println("User already rated this EBook!");
            }
            else
                System.out.println("EBOOKS Table is Empty!");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if (resultSet != null)
                try {
                    resultSet.close();
                }
                catch (SQLException ex) {
                    System.out.println(ex);
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
