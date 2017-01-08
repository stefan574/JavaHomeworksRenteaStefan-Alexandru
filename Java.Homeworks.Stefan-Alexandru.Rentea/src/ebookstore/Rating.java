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
        this.userId = getUserId();
        this.rating = Double.parseDouble(new LegalValue().getLegalValue("Rating: "));
        this.description = new LegalValue().getLegalValue("Description: ");
    }
    
    void setDescription() {
        this.description = new LegalValue().getLegalValue("Description: ");
    }
    
    private int getUserId() {
        String userName = new LegalValue().getLegalValue("User Name: ");
        if (USERS.contains(userName))
            return USERS.indexOf(userName);
        else {
            USERS.add(userName);
            return USERS.indexOf(userName);
        }
    }
    
    String printRating() {
            return rating
                + "\nUser Id: " + userId
                + "\nDescription: " + description;
    }
    
    double getRating() {
        return rating;
    }
    
}
