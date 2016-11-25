/*
 * RequestsMenu class
 */
package carfactory;

/**
 * @author Stefan-Alexandru Rentea
 */
public class RequestsMenu {
    
    static void requestsMenu(Requests requests) {
        String string = "Choice:   ";
        System.out.println("1. Display Requests.\n2. Resolve Request.\n3. Delete Requests."
                + "\n4. Factory View.\n5. Exit.\n");
        string = new LegalValue().getLegalValue(string);
        SwitchRequests.doRequestsSwitch(requests, string);
    }
    
}
