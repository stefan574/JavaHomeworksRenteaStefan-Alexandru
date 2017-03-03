/*
 * Author class
 */
package ebookstore;

/**
 * @author Stefan-Alexandru Rentea
 */
class Author {
    
    private static int count = 0;
    private final int id;
    private final String firstName;
    private final String familyName;
    
    /**
     * Default Constructor for the Author class
     */
    public Author() {
        this.id = count++;
        this.firstName = new LegalValue().getLegalValue("First Name: ");
        this.familyName = new LegalValue().getLegalValue("Family Name: ");
    }
    
    /**
     * Parameterized Constructor for the Author class
     * 
     * @param id represents the value for the id field
     * @param firstName represents the value for the firstName field
     * @param familyName represents the value for the familyName field
     */
    public Author(int id, String firstName, String familyName) {
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
    }
    
    /**
     * Parameterized Constructor for the Author class for anonymous authors
     * 
     * @param string represents the value for the firstName field
     */
    public Author(String string) {
        this.id = count++;
        this.firstName = string + this.id;
        this.familyName = "";
    }

    /**
     * Copy-Constructor for the Author class
     * 
     * @param author the object from which the field values are taken 
     */
    public Author(Author author) {
        this.id = author.id;
        this.firstName = author.firstName;
        this.familyName = author.familyName;
    }
    
    /**
     * Prints the fields of the author
     */
    void printAuthor() {
        if (familyName != null)
            System.out.print(firstName + " " + familyName + "\n");
        else
            System.out.print(firstName + "\n");
    }

    /**
     * Getter for the firstName field
     * 
     * @return the firstName field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for the familyName field
     * 
     * @return the familyName field
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Getter for the id field
     * 
     * @return the id field
     */
    public int getId() {
        return id;
    }
    
    /**
     * In case of duplicate author for an ebook, this method is invoked to
     * decrement the already incremented count field
     */
    public static void decrementCount() {
        count--;
    }
    
}
