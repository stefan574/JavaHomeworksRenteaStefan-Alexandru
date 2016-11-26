/*
 * SwitchCustomer
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class SwitchCustomer {
    
    /*
     * Chooses the appropriate response depending on the String operation
     */
    static void doCustomerSwitch(Customer customer, String operation) {
        switch(operation) {
            case "1" : 
                customer.displayDetails();
                break;
            case "2" :
                customer.makeRequest();
                break;
            case "3" :
                customer.buyCar();
                break;
            case "4" :
                customer.sellCar();
                break;
            case "5" :
                customer.repaintCar();
                break;
            case "6" :
                CustomersMenu.customersMenu(customer.getCustomers());
                break;
            case "7" :
                FactoryMenu.factoryMenu(customer.getCustomers().getFactory());
                break;
            case "8" :
                System.exit(0);
                //break; - not necessary
            default :
                //write to log file
                break;
        }
        CustomerMenu.customerMenu(customer);
    }
    
}
