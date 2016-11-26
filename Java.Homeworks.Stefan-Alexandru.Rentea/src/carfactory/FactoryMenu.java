/*
 * FactoryMenu class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class FactoryMenu {
    
    /*
     * Displays the menu for the factory variable and switches to the
     * selected operation.
     */
    static void factoryMenu(Factory factory) {
        String string = "Choice:";
        System.out.println("1. Display Delivered Cars Per Customer."
                + "\n2. Display Available Cars.\n3. Add Car to Available Cars List."
                + "\n4. Delete Car from Available Cars List. \n5. Customers View.");
        
        if (!factory.getRequests().getRequestsList().isEmpty()) {
            if (factory.getRequests().getRequestsList().size() == 1)
                System.out.println("6. Requests View(You have 1 request "
                        + "unresolved).\n7. Exit.\n");
            else 
                System.out.println("6. Requests View(You have "
                        + factory.getRequests().getRequestsList().size()
                        + " requests unresolved).\n7. Exit.\n");
        }
        else 
            System.out.println("6. Exit.\n");
        
        if (!factory.getRequests().getRequestsList().isEmpty())
                string = new LegalValue().getLegalValue(string + " ");
        else
            string = new LegalValue().getLegalValue(string);
        
        SwitchFactory.doFactorySwitch(factory, string);
    }
    
}
