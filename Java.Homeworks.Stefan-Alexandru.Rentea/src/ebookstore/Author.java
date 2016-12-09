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
    
    public Author(String string) {
        this.id = count++;
        this.firstName = string + this.id;
        this.familyName = null;
    }

    public Author(Author author) {
        this.id = author.id;
        this.firstName = author.firstName;
        this.familyName = author.familyName;
    }
    
    void printAuthor() {
        if (familyName != null)
            System.out.print("Id: " + id + "\nFirst Name: " + firstName
                    + "\nFamily Name: " + familyName + "\n");
        else
            System.out.print("Id: " + id + "\nFirst Name: " + firstName + "\n");
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
