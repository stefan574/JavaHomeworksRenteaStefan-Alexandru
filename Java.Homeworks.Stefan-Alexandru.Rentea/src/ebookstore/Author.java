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
    
    public Author() {
        this.id = count++;
        this.firstName = new LegalValue().getLegalValue("First Name: ");
        this.familyName = new LegalValue().getLegalValue("Family Name: ");
    }
    
    // for Test Class
    public Author(int id, String firstName, String familyName) {
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
    }
    
    // used for anonymous authors
    public Author(String string) {
        this.id = count++;
        this.firstName = string + this.id;
        this.familyName = "";
    }

    public Author(Author author) {
        this.id = author.id;
        this.firstName = author.firstName;
        this.familyName = author.familyName;
    }
    
    void printAuthor() {
        if (familyName != null)
            System.out.print(firstName + " " + familyName + ", id: " + id + "\n");
        else
            System.out.print(firstName + ", id: " + id + "\n");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getId() {
        return id;
    }
    
}
