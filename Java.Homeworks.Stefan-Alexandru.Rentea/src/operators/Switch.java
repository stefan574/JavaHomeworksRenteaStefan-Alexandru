/*
 * Switch class
 */
package operators;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Switch {
    
    /*
     * Chooses the appropriate response for the request received
     * from the parse() method.
     */
    void doSwitch(String string){
        switch(string) {
            case "1" :
                AllOperators.forInt();  
                break;
            case "2" :
                AllOperators.forLong();
                break;
            case "3" :
                AllOperators.forShort();
                break;
            case "4" :
                AllOperators.forByte();
                break;
            case "5" :
                AllOperators.forChar();
                break;
            case "6" :
                AllOperators.forBoolean();
                break;
            case "7" :
                AllOperators.forFloat();
                break;
            case "8" :
                AllOperators.forDouble();
                break;
            case "9" :
                AllOperators.forIntWrapper();
                break;
            case "10" :
                AllOperators.forLongWrapper();
                break;
            case "11" :
                AllOperators.forByteWrapper();
                break;
            case "12" :
                AllOperators.forCharWrapper();
                break;
            case "13" :
                AllOperators.forShortWrapper();
                break;
            case "14" :
                AllOperators.forFloatWrapper();
                break;
            case "15" :
                AllOperators.forDoubleWrapper();
                break;
            case "16" :
                AllOperators.forBooleanWrapper();
                break;
            case "17" :
                AllOperators.forString();
                break;
            case "18" :
                System.exit(0);
                //break; - not necessary
            case "19" :
                AllOperators.forInt();
                AllOperators.forLong();
                AllOperators.forShort();
                AllOperators.forByte();
                AllOperators.forChar();
                AllOperators.forFloat();
                AllOperators.forDouble();
                AllOperators.forBoolean();
                AllOperators.forIntWrapper();
                AllOperators.forLongWrapper();
                AllOperators.forShortWrapper();
                AllOperators.forByteWrapper();
                AllOperators.forCharWrapper();
                AllOperators.forFloatWrapper();
                AllOperators.forDoubleWrapper();
                AllOperators.forBooleanWrapper();
                AllOperators.forString();
                break;
            default :
                //Write in log file
                break;
        }
    }
    
}