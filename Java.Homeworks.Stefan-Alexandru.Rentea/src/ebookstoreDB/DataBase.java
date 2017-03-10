/*
 * DataBase Class
 */
package ebookstoreDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Stefan-Alexandru Rentea
 */
public class DataBase {
    
    private static final String[] TABLES = {"AUTHORS", "EBOOKS", "RATINGS", "TYPES"};
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:derby://localhost:1527/EBOOKS_DB;create=true";
    private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    
    static void checkExistenceOfDatabase() {
        
        Connection connection = null;
        
        try {
            Class driverClass = Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            for (String string : TABLES)
                if(!checkExistenceOfTable(connection, string))
                    createTable(connection, string);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Missing required driver!");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            if (connection != null)
                try {
                    connection.close();
                }
                catch (SQLException e) {
                    System.out.println("Could not close the connection!");
                }
        }
    }
    
    private static boolean checkExistenceOfTable(Connection connection, String tableName) {
        boolean exists = false;
        try (ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, null)) {
            while (resultSet.next()) { 
                String _tableName = resultSet.getString("TABLE_NAME");
                if (_tableName != null && _tableName.equalsIgnoreCase(tableName)) {
                    exists = true;
                    break;
                }
            }
        }
        catch (SQLException e) { 
            System.out.println(e);
        }
        return exists;
    }
    
    private static void createTable(Connection connection, String tableName) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            switch(tableName) {
                case "AUTHORS" :
                    statement.execute("CREATE TABLE AUTHORS ("
                            + "ISBN VARCHAR(16) NOT NULL, "
                            + "ID INTEGER NOT NULL, "
                            + "FIRST_NAME VARCHAR(32) NOT NULL, "
                            + "LAST_NAME VARCHAR(32) NOT NULL, "
                            + "PRIMARY KEY (ISBN, ID))");
                    statement.execute("INSERT INTO ROOT.AUTHORS ("
                            + "ISBN, ID, FIRST_NAME, LAST_NAME) "
                            + "VALUES ('321-54-54321-54', 1, 'Mihail', 'Sadoveanu')");
                    statement.execute("INSERT INTO ROOT.AUTHORS ("
                            + "ISBN, ID, FIRST_NAME, LAST_NAME) "
                            + "VALUES ('999-12-12345-12', 2, 'Paul', 'Deitel')");
                    statement.execute("INSERT INTO ROOT.AUTHORS ("
                            + "ISBN, ID, FIRST_NAME, LAST_NAME) "
                            + "VALUES ('999-12-12345-12', 3, 'Harvey', 'Deitel')");
                    break;
                case "EBOOKS" :
                    statement.execute("CREATE TABLE EBOOKS ("
                            + "ISBN VARCHAR(16) NOT NULL, "
                            + "TITLE VARCHAR(32) NOT NULL, "
                            + "NUMBER_OF_PAGES INTEGER NOT NULL, "
                            + "PRICE DOUBLE NOT NULL, "
                            + "RATING DOUBLE NOT NULL, "
                            + "TYPE INTEGER NOT NULL, "
                            + "PRIMARY KEY (ISBN))");
                    statement.execute("INSERT INTO ROOT.EBOOKS (ISBN, TITLE, "
                            + "NUMBER_OF_PAGES, PRICE, RATING, \"TYPE\")"
                            + " VALUES ('123-45-12345-12', 'Fratii Jderi', 792, 47.5, 4.0, 1)");
                    statement.execute("INSERT INTO ROOT.EBOOKS (ISBN, TITLE, "
                            + "NUMBER_OF_PAGES, PRICE, RATING, \"TYPE\")"
                            + " VALUES ('321-54-54321-54', 'Baltagul', 210, 22.0, 5.0, 1)");
                    statement.execute("INSERT INTO ROOT.EBOOKS (ISBN, TITLE, "
                            + "NUMBER_OF_PAGES, PRICE, RATING, \"TYPE\")"
                            + " VALUES ('999-12-12345-12', 'Java, How to program', 1535, 100.0, 2.0, 2)");
                    break;
                case "RATINGS" :
                    statement.execute("CREATE TABLE RATINGS ("
                            + "ISBN VARCHAR(16) NOT NULL, "
                            + "USER_NAME VARCHAR(32) NOT NULL, "
                            + "DESCRIPTION VARCHAR(256) NOT NULL, "
                            + "RATING DOUBLE NOT NULL, "
                            + "PRIMARY KEY (ISBN, USER_NAME))");
                    statement.execute("INSERT INTO ROOT.RATINGS (ISBN, "
                            + "USER_NAME, DESCRIPTION, RATING) "
                            + "	VALUES ('123-45-12345-12', 'User1', 'E buna', 5.0)");
                    statement.execute("INSERT INTO ROOT.RATINGS (ISBN, "
                            + "USER_NAME, DESCRIPTION, RATING) "
                            + "	VALUES ('123-45-12345-12', 'User2', 'E in regula', 3.0)");
                    statement.execute("INSERT INTO ROOT.RATINGS (ISBN, "
                            + "USER_NAME, DESCRIPTION, RATING) "
                            + "	VALUES ('321-54-54321-54', 'User3', 'Cel mai bun roman', 5.0)");
                    statement.execute("INSERT INTO ROOT.RATINGS (ISBN, "
                            + "USER_NAME, DESCRIPTION, RATING) "
                            + "	VALUES ('999-12-12345-12', 'User1', 'Groaznic', 1.0)");
                    statement.execute("INSERT INTO ROOT.RATINGS (ISBN, "
                            + "USER_NAME, DESCRIPTION, RATING) "
                            + "	VALUES ('999-12-12345-12', 'User2', 'N-am inteles nimic', 2.0)");
                    statement.execute("INSERT INTO ROOT.RATINGS (ISBN, "
                            + "USER_NAME, DESCRIPTION, RATING) "
                            + "	VALUES ('999-12-12345-12', 'User4', 'Cat de cat ok', 3.0)");
                    break;
                case "TYPES" :
                    statement.execute("CREATE TABLE TYPES ("
                            + "ID INTEGER NOT NULL, "
                            + "NAME VARCHAR(32) NOT NULL, "
                            + "PRIMARY KEY (ID))");
                    statement.execute("INSERT INTO TYPES (ID, NAME) VALUES "
                            + "(1, 'Novel'), "
                            + "(2, 'Technical'), "
                            + "(3, 'Art Album')");
                    break;
                default :
                    // write in log file
                    break;
            }
        }
        catch (SQLException e) {
            System.out.println("Could not create Table " + tableName);
        }
        finally {
            if (statement != null)
                try {
                    statement.close();
                }
                catch (SQLException ex) {
                    System.out.println("Could not close statement!");
                }
        }
    }
    
}
