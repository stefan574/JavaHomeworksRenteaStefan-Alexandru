/*
 * Test Class
 */
package ebookstore;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Test {
    
    private static boolean bool = true;
    
    static void test() {
        
        System.out.println("\nTesting the Rating Class:\n");
        
        double rating = 5.0;
        int userId = 1;
        String description = "The book is very good!";
        Rating ratingObject = new Rating(rating, userId, description);
        
        System.out.println("Testing Constructor:\n\n"
                + "Initial values of parameters fed to Constructor:\n\n"
                + "    rating: " + rating + "\n"
                + "    userId: " + userId + "\n"
                + "    description: " + description + "\n");
        
        System.out.println("Values of fields of the Rating Object created:\n\n"
                + "    rating: " + ratingObject.getRating() + "\n"
                + "    userId: " + ratingObject.getUserId() + "\n"
                + "    description: " + ratingObject.getDescription() + "\n");
        
        if(rating == ratingObject.getRating() && userId == ratingObject.getUserId()
                && description.equals(ratingObject.getDescription()))
            System.out.println("The initial values and the Object's values "
                    + "are identical!\n");
        else {
            System.out.println("The initial values and the Object's values "
                    + "are NOT identical!\n");
            bool = false;
        }
        
        description = "The book is better than I expected!";
        String newDescription = "The book is better than I expected!";
        
        System.out.println("Testing setDescription() Method:\n\n"
                + "    oldDescription: " + ratingObject.getDescription());
        
        ratingObject.setDescription(newDescription);
        
        System.out.println("    descriptionToBeAdded: " + newDescription + "\n"
                + "    newDescription: " + ratingObject.getDescription() + "\n");
        
        if (description.equals(ratingObject.getDescription()))
            System.out.println("The oldDescription and the newDescription are identical!\n");
        else {
            System.out.println("The oldDescription and the newDescription are NOT identical!\n");
            bool = false;
        }
        
        if (bool)
            System.out.println("Testing the Rating Class was a success!\n");
        else
            System.out.println("Testing the Rating Class was NOT a success!\n");
        
        System.out.println("Testing the Author Class:\n");
        
        bool = true;
        int id = 1;
        String firstName = "Steven";
        String familyName = "Alexander";
        Author authorObject = new Author(id, firstName, familyName);
        
        System.out.println("Testing Constructor:\n\n"
                + "Initial values of parameters fed to Constructor:\n\n"
                + "    id: " + id + "\n"
                + "    firstName: " + firstName + "\n"
                + "    familyName: " + familyName + "\n");
        
        System.out.println("Values of fields of the Author Object created:\n\n"
                + "    userId: " + authorObject.getId() + "\n"
                + "    firstName: " + authorObject.getFirstName() + "\n"
                + "    familyName: " + authorObject.getFamilyName() + "\n");
        
        if(id == authorObject.getId() && firstName.equals(authorObject.getFirstName())
                && familyName.equals(authorObject.getFamilyName()))
            System.out.println("The initial values and the Object's values "
                    + "are identical!\n");
        else {
            System.out.println("The initial values and the Object's values "
                    + "are NOT identical!\n");
            bool = false;
        }
        
        if (bool)
            System.out.println("Testing the Author Class was a success!\n");
        else
            System.out.println("Testing the Author Class was NOT a success!\n");
        
        System.out.println("Testing the EBook Class:\n");
        
        bool = true;
        String isbn = "361-5278-487925525-111251";
        String title = "The Secret Book Of Secrets";
        int numberOfPages = 300;
        double price = 450.50;
        TechnicalType subject = TechnicalType.NETWORKS;
        EBook eBookObject = new TechnicalEBook(isbn, title, numberOfPages, price, rating, subject);
        
        System.out.println("Testing Constructor:\n\n"
                + "Initial values of parameters fed to Constructor:\n\n"
                + "    isbn: " + isbn + "\n"
                + "    title: " + title + "\n"
                + "    numberOfPages: " + numberOfPages + "\n"
                + "    price: " + price + "\n"
                + "    rating: " + rating + "\n"
                + "    subject: " + subject + "\n");
        
        System.out.println("Values of fields of the EBook Object created:\n\n"
                + "    isbn: " + eBookObject.getIsbnValue() + "\n"
                + "    title: " + eBookObject.getTitle() + "\n"
                + "    numberOfPages: " + eBookObject.getNumberOfPages() + "\n"
                + "    price: " + eBookObject.getPrice() + "\n"
                + "    rating: " + eBookObject.getRating() + "\n"
                + "    subject: " + eBookObject.getSpecialField().replaceFirst("Subject: ", "") + "\n");
        
        if(isbn.equals(eBookObject.getIsbn()) && title.equals(eBookObject.getTitle())
                && numberOfPages == eBookObject.getNumberOfPages()
                && price == eBookObject.getPrice()
                && rating == Double.parseDouble(eBookObject.getRating())
                && subject.name().equals(eBookObject.getSpecialField().replaceFirst("Subject: ", "")))
            System.out.println("The initial values and the Object's values "
                    + "are identical!\n");
        else {
            System.out.println("The initial values and the Object's values "
                    + "are NOT identical!\n");
            bool = false;
        }
        
        // the listOfAuthors should be empty
        if (!eBookObject.getListOfAuthors().isEmpty()) {
            System.out.println("The initial size of the listOfAuthors is NOT 0!\n");
            bool = false;
        }
        
        // the listOfRatings should have one element
        if (!(eBookObject.getListOfRatings().size() == 1)) {
            System.out.println("The initial size of the listOfRatings is NOT 1!\n");
            bool = false;
        }
        
        double rating2 = 4.0;
        double rating3 = 3.0;
        eBookObject.addRating(rating2);
        eBookObject.addRating(rating3);
        double expectedRating = 0;
        
        expectedRating = eBookObject.getListOfRatings().stream().map((_rating) -> _rating)
                .reduce(expectedRating, (accumulator, _item) -> accumulator + _item);
        expectedRating = new DoublePrecision()
                .doPrecision((expectedRating/eBookObject.getListOfRatings().size()), 2);
        
        System.out.println("Testing addRating() Method:\n\n"
                + "    oldRating: " + rating + "\n"
                + "    expectedRating: " + expectedRating + "\n"
                + "    newRating: " + eBookObject.getRating() + "\n");
        
        if (expectedRating == Double.parseDouble(eBookObject.getRating()))
            System.out.println("The oldRating and the newRating are identical!\n");
        else {
            System.out.println("The oldRating and the newRating are NOT identical!\n");
            bool = false;
        }
        
        System.out.println("Testing adding an Author Object to the listOfAuthors:\n");
        
        eBookObject.getListOfAuthors().add(authorObject);
        
        // the listOfRatings should have one element
        if (!(eBookObject.getListOfAuthors().size() == 1)) {
            System.out.println("The size of the listOfAuthors is NOT 1!\n");
            bool = false;
        }
        
        System.out.println("Values of the Author Object to be added:\n\n"
                + "    userId: " + authorObject.getId() + "\n"
                + "    firstName: " + authorObject.getFirstName() + "\n"
                + "    familyName: " + authorObject.getFamilyName() + "\n");
        
        System.out.println("Values of fields of the Author Object added:\n\n"
                + "    userId: " + eBookObject.getListOfAuthors().get(0).getId() + "\n"
                + "    firstName: " + eBookObject.getListOfAuthors().get(0).getFirstName() + "\n"
                + "    familyName: " + eBookObject.getListOfAuthors().get(0).getFamilyName() + "\n");
        
        if(authorObject.getId() == eBookObject.getListOfAuthors().get(0).getId()
                && authorObject.getFirstName().equals(eBookObject.getListOfAuthors().get(0).getFirstName())
                && authorObject.getFamilyName().equals(eBookObject.getListOfAuthors().get(0).getFamilyName()))
            System.out.println("The values of the Author Object to be added and the Author Object's added values "
                    + "are identical!\n");
        else {
            System.out.println("The values of the Author Object to be added and the Author Object's added values "
                    + "are NOT identical!\n");
            bool = false;
        }
        
        if (bool)
            System.out.println("Testing the EBook Class was a success!");
        else
            System.out.println("Testing the EBook Class was NOT a success!");
        
    }
 
}
