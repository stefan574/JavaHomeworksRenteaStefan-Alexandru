/*
 * Main class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class CarFactory {
    
    // used in the getMoney() function
    static long start = System.currentTimeMillis();
    
    /*
     * Starts the program by creating a new Factory object and making a 
     * call to the FactoryMenu.factoryMenu() function.
     */
    public static void main(String[] args) {
        Factory factory = new Factory();
        FactoryMenu.factoryMenu(factory);
    }
    
}
