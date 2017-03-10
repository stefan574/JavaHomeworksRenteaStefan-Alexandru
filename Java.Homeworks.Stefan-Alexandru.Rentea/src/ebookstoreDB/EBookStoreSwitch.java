/*
 * EBookStoreSwitch
 */
package ebookstoreDB;

/**
 * @author Stefan-Alexandru Rentea
 */
class EBookStoreSwitch {
    
    /**
     * The switch method corresponding to the eBookStoreMenu method
     * 
     * @param eBookStore contains the list of ebooks
     * @param choice is the menu choice of the user
     */
    static void eBookStoreSwitch(EBookStore eBookStore, int choice) {
        switch(choice) {
            case 1 :
                EBookSelectTypeMenu.ebookSelectTypeMenu(eBookStore.getEBooks());
                break;
            case 2 :
                //eBookStore.getEBooks().deleteEBook();
                System.out.println();
                break;
            case 3 :
                //eBookStore.getEBooks().printListOfEBooks();
                System.out.println();
                break;
            case 4 :
                //eBookStore.getEBooks().printDetailedListOfEBooks();
                break;
            case 5 :
                //eBookStore.getEBooks().addRatingToEBook();
                System.out.println();
                break;
            case 6 :
                //eBookStore.getEBooks().modifyDescriptionOfRating();
                System.out.println();
                break;
            case 7 :
                //Test.test();
                //System.out.println();
                break;
            case 8 :
                eBookStore.getEBooks().addAuthorToEbook();
                System.out.println();
                break;
            case 9 :
                eBookStore.getEBooks().addEBookToAuthor();
                System.out.println();
                break;
            case 10 :
                System.exit(0);
                //break; - not necessary
            default :
                // write in log file
                break;
        }
        EBooksMenu.eBookStoreMenu(eBookStore);
    }
    
}
