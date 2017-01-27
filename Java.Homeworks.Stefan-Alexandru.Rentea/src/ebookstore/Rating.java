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
    
    Rating() {
        this.userId = getValidUserId();
        this.rating = Double.parseDouble(new LegalValue().getLegalValue("Rating: "));
        this.description = new LegalValue().getLegalValue("Description: ");
    }
    
    // for Test Class
    public Rating(double rating, int userId, String description) {
        this.rating = rating;
        this.userId = userId;
        this.description = description;
    }
    
    void setDescription() {
        this.description = new LegalValue().getLegalValue("Description: ");
    }
    
    // for Test Class
    void setDescription(String description) {
        this.description = description;
    }
    
    private int getValidUserId() {
        String userName = new LegalValue().getLegalValue("User Name: ");
        
        if (!USERS.contains(userName))
            USERS.add(userName);
        
        return USERS.indexOf(userName);
        
    }
    
    String printRating() {
            return rating
                + "\nUser Id: " + userId
                + "\nDescription: " + description;
    }
    
    double getRating() {
        return rating;
    }

    // for Test Class
    public String getDescription() {
        return description;
    }

    // for Test Class
    public int getUserId() {
        return userId;
    }
    
}
