/*
 * AuthorsSql
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
    static void delete() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ROOT.AUTHORS");
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                List<Integer> rows = new ArrayList<>();
                int i = 0;
                do {
                    if (!rows.contains(resultSet.getInt(2))) {
                        rows.add(resultSet.getInt(2));
                        System.out.println(++i + ": " + resultSet.getString(3)
                                + " " + resultSet.getString(4)
                                + ", id: " + resultSet.getString(2));
                    }
                } while(resultSet.next());

                int choice = new LegalValue().getLegalValue(i);

                statement.execute("DELETE FROM ROOT.AUTHORS WHERE ID = " + rows.get(choice - 1));
                
                System.out.println("Author Deleted!");
            }
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
    
    static void select(String isbn) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            if (isbn == null)
                resultSet = statement.executeQuery("SELECT * FROM ROOT.AUTHORS");
            else
                resultSet = statement.executeQuery("SELECT * FROM ROOT.AUTHORS WHERE ISBN = '" + isbn + "'");
            boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows) {
                    int i = 0;
                    do {
                        if (isbn == null)
                            System.out.println("Author_" + (++i) + "\n"
                                    + "\tIsbn: " + resultSet.getString(1) + "\n"
                                    + "\tId: " + resultSet.getInt(2) + "\n"
                                    + "\tFirstName: " + resultSet.getString(3) + "\n"
                                    + "\tLastName: " + resultSet.getString(4));
                        else
                            System.out.println("Author_" + (++i) + "\n"
                                    + "\tId: " + resultSet.getInt(2) + "\n"
                                    + "\tFirstName: " + resultSet.getString(3) + "\n"
                                    + "\tLastName: " + resultSet.getString(4));
                    } while(resultSet.next());
                }
            else
                if (isbn == null)
                    System.out.println("AUTHORS Table is Empty!");
                else 
                    System.out.println("No Author!");
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
