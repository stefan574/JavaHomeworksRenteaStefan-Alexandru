/*
 * SwitchFactory class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class SwitchFactory {
    
    /*
     * Chooses the appropriate response depending on the String operation
     */
    static void doFactorySwitch(Factory factory, String option) {
        switch(option) {
            case "1" :
                factory.displayCarsPerCustomers();
                break;
            case "2" :
                factory.displayAvailableCars();
                break;
            case "3" :
                Car car = new Car();
                factory.getAvailableCars().addToCarsList(car);
                break;
            case "4" :
                factory.removeFromAvailableCarsList();
                break;
            case "5" :
                CustomersMenu.customersMenu(factory.getCustomers());
                break;
            case "6" :
                if (factory.getRequests().getRequestsList().isEmpty())
                    System.exit(0);
                    //break; - not necessary
                else {
                    RequestsMenu.requestsMenu(factory.getRequests());
                    break;
                }
            case "7" :
                System.exit(0);
                //break; - not necessary
            default :
                //write in log file
                break;
        }
        FactoryMenu.factoryMenu(factory);
    }
    
}
