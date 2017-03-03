/*
 * Rating Class
 */
package ebookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Rating {
    
    private final static List<String> USERS;
    private final double rating;
    private final int userId;
    private String description;
    
    static {
        USERS = new ArrayList<>();
    }
    
    /**
     * Default Constructor for the Rating class
     */
    Rating() {
        this.userId = getValidUserId();
        this.rating = Double.parseDouble(new LegalValue().getLegalValue("Rating: "));
        this.description = new LegalValue().getLegalValue("Description: ");
    }
    
    /**
     * Parameterized Constructor for the Rating class
     * 
     * @param rating represents the value for the rating field
     * @param userId represents the value for the userId field
     * @param description represents the value for the description field
     */
    public Rating(double rating, int userId, String description) {
        this.rating = rating;
        this.userId = userId;
        this.description = description;
    }
    
    /**
     * Setter for the description field
     */
    void setDescription() {
        this.description = new LegalValue().getLegalValue("Description: ");
    }
    
    /**
     * Setter for the description field with parameter
     * 
     * @param description represents the value for the description field
     */
    void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Returns a valid userId for the userId field
     * 
     * @return valid userId
     */
    private int getValidUserId() {
        String userName = new LegalValue().getLegalValue("User Name: ");
        
        if (!USERS.contains(userName))
            USERS.add(userName);
        
        return USERS.indexOf(userName);
    }
    
    /**
     * Returns the fields of the Rating Object in a String
     * 
     * @return the fields of the current Rating Object in a String
     */
    String printRating() {
            return rating
                + "\nUser: " + USERS.get(userId)
                + "\nDescription: " + description;
    }
    
    /**
     * Getter for the rating field
     * 
     * @return rating field
     */
    double getRating() {
        return rating;
    }

    /**
     * Getter for the description field
     * 
     * @return description field
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for the userId field
     * 
     * @return userId field
     */
    public int getUserId() {
        return userId;
    }
    
}
