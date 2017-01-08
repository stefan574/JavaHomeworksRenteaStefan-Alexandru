/*
 * EBook class
 */
package ebookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan-Alexandru Rentea
 */
abstract class EBook implements Book {
    
    private final String isbn;
    private final String title;
    private final int numberOfPages;
    private final double price;
    private double rating;
    private final List<Double> listOfRatings;
    private final List<Author> listOfAuthors;

    public EBook() {
        this.isbn = getIsbnValue();
        this.title = new LegalValue().getLegalValue("Title: ");
        this.numberOfPages = Integer.parseInt(new LegalValue()
                .getLegalValue("Number of Pages: "));
        this.price = Double.parseDouble(new LegalValue()
                .getLegalValue("Price: "));
        this.rating = 0;
        this.listOfRatings = new ArrayList<>();
        this.listOfAuthors = new ArrayList<>();
        System.out.println("\nAdd Author:");
        addAuthor();
    }
    
    private String getRating() {
        if (rating == 0)
            return "No rating!";
        else
            return rating + "";
    }
    
    @Override
    public void printListOfAuthors() {
        if (listOfAuthors.size() == 1) {
            System.out.print("Author: ");
            listOfAuthors.get(0).printAuthor();
        }
        else {
            int i = 0;
            for (Author author : listOfAuthors) {
                System.out.print("Author_" + i++ + ": ");
                author.printAuthor();
            }
        }
    }
    
    @Override
    public void addRating(double rating) {
        this.rating = 0;
        listOfRatings.add(rating);
        listOfRatings.forEach((ratingToAdd) -> {
            this.rating += ratingToAdd;
        });
        this.rating = new DoublePrecision()
                .doPrecision(this.rating/listOfRatings.size(), 2);
    }

    // The isbn value will be something like "xxx-xx-xxxxx-xx".
    @Override
    public final String getIsbnValue() {
        return (int)(Math.random()*899)+100 + "-"
                + (int)(Math.random()*89)+10 + "-"
                + (int)(Math.random()*89999)+10000 + "-"
                + (int)(Math.random()*899)+100;
    }
    
    @Override
    public final void addAuthor() {
        int firstAuthor, choice;
        firstAuthor = 0;
        while (true) {
            System.out.println("\n1. New Author.\n2. Existing Author.\n3."
                    + " Anonymous Author.\n4. Exit Authors Menu.");
            choice = new LegalValue().getLegalValue(4);
            if (choice == 1) {
                Author author = new Author();
                Authors.listOfAuthors.add(author);
                listOfAuthors.add(author);
                firstAuthor = 1;
            }
            else
                if (choice == 2) 
                    if (!Authors.listOfAuthors.isEmpty()) {
                        choice = new Authors().chooseFromListOfAuthors();
                        Author author = new Author(Authors.listOfAuthors.get(choice));
                        listOfAuthors.add(author);
                        firstAuthor = 1;
                    }
                    else 
                        System.out.println("\nThe list of Authors is Empty!");
                else 
                    if (choice == 3) {
                        Author author = new Author("Anonymous");
                        Authors.listOfAuthors.add(author);
                        listOfAuthors.add(author);
                        firstAuthor = 1;
                    }
                    else
                        /*
                         * If "exit" is selected and no author was created,
                         * an anonymous author will be automatically created.
                         */
                        if (choice == 4 && firstAuthor == 0) {
                            Author author = new Author("Anonymous");
                            Authors.listOfAuthors.add(author);
                            listOfAuthors.add(author);
                            break;
                        }
                        else
                            break;
        }
    }
    
    String printEBook() {
         return "Title: " + title + ", ISBN: " + isbn;
    }
    
    void printDetailedEBook() {
        System.out.println("ISBN: " + isbn + "\nTitle: " + title
                + "\nNumber of Pages: " + numberOfPages
                + "\nPrice: " + price + "\nRating: " 
                + getRating() + "\n" + getSpecialField());
        printListOfAuthors();
    }
    
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public List<Author> getListOfAuthors() {
        return listOfAuthors;
    }
    
    public String getIsbn() {
        return this.isbn;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    @Override
    public abstract String getSpecialField();
    
}
