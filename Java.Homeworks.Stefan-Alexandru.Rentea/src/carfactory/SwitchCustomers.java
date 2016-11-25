/*
 * SwtichCustomers class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class SwitchCustomers {
    
    static void doCustomersSwitch(Customers customers, String option) {
        switch(option) {
            case "1" :
                customers.displayCustomersSimple();
                break;
            case "2" :
                customers.displayCustomers();
                break;
            case "3" :
                Customer customer = new Customer();
                System.out.println();
                customers.addToCustomersList(customer);
                break;
            case "4" :
                customers.removeFromCustomersList();
                break;
            case "5" :
                customers.chooseCustomer();
                break;
            case "6" :
                FactoryMenu.factoryMenu(customers.getFactory());
                break;
            case "7" : 
                System.exit(0);
                //break - not necessary
            default : 
                //write in log file
                break;
        }
        CustomersMenu.customersMenu(customers);
    }
    
}
