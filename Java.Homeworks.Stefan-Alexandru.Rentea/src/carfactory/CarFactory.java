/*
 * Main class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class CarFactory {
    
    /*
     * Starts the program by creating a new Factory object and making a 
     * call to the FactoryMenu.factoryMenu() function.
     */
    public static void main(String[] args) {
        FactoryMenu.factoryMenu(new Factory());
    }
    
}
