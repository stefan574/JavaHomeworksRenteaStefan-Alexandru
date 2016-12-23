/*
 * SwitchMenu class
 */
package FileManagement;

/**
 * @author Stefan-Alexandru Rentea
 */
public class SwitchMenu {
    
    static void switchMenu(int choice, Contents contents) {
        switch(choice) {
            case 1 :
                contents.addContent();
                break;
            case 2 :
                contents.printListOfContents();
                break;
            case 3 :
                contents.createFile();
                break;
            case 4 :
                contents.readFile();
                break;
            case 5 :
                contents.writeContentToFile();
                break;
            case 6 :
                contents.deleteContentFromListOfContents();
                break;
            case 7 :
                contents.deleteFile();
                break;
            case 8 :
                contents.deleteContentOfFile();
                break;
            case 9 :
                System.exit(0);
                //break; - not necessary
            default :
                // write to log file
                break;
        }
        Menu.menu(contents);
    }
    
}
