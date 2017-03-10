/*
 * Rating Class
 */
package ebookstoreDB;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Rating {
    
    private final double rating;
    private String description;
    private final String userName;
    
    /**
     * Default Constructor for the Rating class
     */
    Rating() {
        this.userName = new LegalValue().getLegalValue("User Name: ");
        this.rating = Double.parseDouble(new LegalValue().getLegalValue("Rating: "));
        this.description = new LegalValue().getLegalValue("Description: ");
    }
    
    /**
     * Parameterized Constructor for the Rating class
     * 
     * @param rating represents the value for the rating field
     * @param userName represents the value for the userName field
     * @param description represents the value for the description field
     */
    public Rating(double rating, String userName, String description) {
        this.rating = rating;
        this.userName = userName;
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
     * Returns the fields of the Rating Object in a String
     * 
     * @return the fields of the current Rating Object in a String
     */
    String printRating() {
            return rating
                + "\nUser: " + userName
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
     * Getter for the userName field
     * 
     * @return userName field
     */
    public String getUserName() {
        return userName;
    }
    
}
