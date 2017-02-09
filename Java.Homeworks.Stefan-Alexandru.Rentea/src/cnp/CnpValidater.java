/*
 * ValideCnp Class
 */
package cnp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stefan-Alexandru
 */
public class CnpValidater {
        
    private boolean valid;
    private static final Map<String, String> COUNTIES;
    StringBuilder error;
    
    static {
        COUNTIES = new HashMap<>();
        COUNTIES.put("01", "Alba");
        COUNTIES.put("02", "Arad");
        COUNTIES.put("03", "Arges");
        COUNTIES.put("04", "Bacau");
        COUNTIES.put("05", "Bihor");
        COUNTIES.put("06", "Bistrita-Nasau");
        COUNTIES.put("07", "Botosani");
        COUNTIES.put("08", "Brasov");
        COUNTIES.put("09", "Braila");
        COUNTIES.put("10", "Buzau");
        COUNTIES.put("11", "Caras-Severin");
        COUNTIES.put("12", "Cluj");
        COUNTIES.put("13", "Constanta");
        COUNTIES.put("14", "Covasna");
        COUNTIES.put("15", "Dambovita");
        COUNTIES.put("16", "Dolj");
        COUNTIES.put("17", "Galati");
        COUNTIES.put("18", "Gorj");
        COUNTIES.put("19", "Harghita");
        COUNTIES.put("20", "Hunedoara");
        COUNTIES.put("21", "Ialomita");
        COUNTIES.put("22", "Iasi");
        COUNTIES.put("23", "Ilfov");
        COUNTIES.put("24", "Maramures");
        COUNTIES.put("25", "Mehedinti");
        COUNTIES.put("26", "Mures");
        COUNTIES.put("27", "Neamt");
        COUNTIES.put("28", "Olt");
        COUNTIES.put("29", "Prahova");
        COUNTIES.put("30", "Satu Mare");
        COUNTIES.put("31", "Salaj");
        COUNTIES.put("32", "Sibiu");
        COUNTIES.put("33", "Suceava");
        COUNTIES.put("34", "Teleorman");
        COUNTIES.put("35", "Timis");
        COUNTIES.put("36", "Tulcea");
        COUNTIES.put("37", "Vaslui");
        COUNTIES.put("38", "Valcea");
        COUNTIES.put("39", "Vrancea");
        COUNTIES.put("40", "Bucuresti");
        COUNTIES.put("41", "Bucuresti, Sector 1");
        COUNTIES.put("42", "Bucuresti, Sector 2");
        COUNTIES.put("43", "Bucuresti, Sector 3");
        COUNTIES.put("44", "Bucuresti, Sector 4");
        COUNTIES.put("45", "Bucuresti, Sector 5");
        COUNTIES.put("46", "Bucuresti, Sector 6");
        COUNTIES.put("51", "Calarasi");
        COUNTIES.put("52", "Giurgiu");
    }
    
    /**
     * The constructor for the ValidateCnp Class.
     */
    public CnpValidater() {
        this.valid = true;
        this.error = new StringBuilder("");
    }
    
    /**
     * Verifies if the checksum is correct.
     * 
     * @param cnp represents the personal numerical code
     */
    private void validateCheckSum(String cnp) {
        int checkSum = Integer.parseInt(cnp.substring(cnp.length() - 1));
        int[] cnpNumbersMultiplier = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int sum = 0;
        
        for (int i = 0; i < 12; i++)
            sum += (cnp.charAt(i) - '0') * cnpNumbersMultiplier[i];
        
        sum = sum % 11;
        if (sum == 10)
            sum = 1;
        
        if (!(checkSum == sum)) {
            valid = false;
            error.append("Checksum Fail!\n\n");
        }
    }
    
    /**
     * Verifies if the 29th of February is present in the personal
     * numerical code, and if so, it verifies if a leap year is also
     * present in the personal numerical code.
     * 
     * @param syymmdd represents the first 7 characters of
     * the personal numerical code value
     */
    private void validateLeapYear(String syymmdd) {
        // the year 1800 and 1900 are not leap years
        if (syymmdd.charAt(3) == '0' && syymmdd.charAt(4) == '2'
                && syymmdd.charAt(5) == '2' && syymmdd.charAt(6) == '9'
                && (!(((syymmdd.charAt(1) - '0') * 10 + (syymmdd.charAt(2) - '0')) % 4 == 0)
                || (((syymmdd.charAt(0) == '3' || syymmdd.charAt(0) == '4')
                && (syymmdd.charAt(1) == '0' && syymmdd.charAt(2) == '0'))
                || ((syymmdd.charAt(0) == '1' || syymmdd.charAt(0) == '2')
                && (syymmdd.charAt(1) == '0' && syymmdd.charAt(2) == '0'))))) {
            valid = false;
            error.append("Not a leap year!\n\n");
        }
    }
    
    /**
     * @param jj represents the code for the county
     * @return the corresponding county for the code given as parameter
     */
    private String getCounty(String jj) {
        // validation for county is already done in regex
        return COUNTIES.get(jj);
    }
    
    /**
     * @param s represents the first character in the personal numerical code
     * @return "M" for male, "F" for female, "UNKNOWN" for people from
     * other countries
     */
    private String getSex(char s) {
        switch (s) {
            case '9':
                return "UNKNOWN";
                // break - not needed
            case '1':
            case '3':
            case '5':
            case '7':
                return "M";
                // break - not needed
            default:
                return "F";
                // break - not needed
        }
    }
    
    /**
     * @param syymmdd represents the first 7 characters of
     * the personal numerical code value
     * @return the date of birth for the corresponding personal
     * numerical code
     */
    private String getDateOfBirth(String syymmdd) {
        switch (syymmdd.charAt(0)) {
            case '1':
            case '2':
                return "" + syymmdd.charAt(5) + syymmdd.charAt(6) + "."
                        + syymmdd.charAt(3) + syymmdd.charAt(4) + "."
                        + "19" + syymmdd.charAt(1) + syymmdd.charAt(2);
                // break - not needed
            case '3':
            case '4':
                return "" + syymmdd.charAt(5) + syymmdd.charAt(6) + "."
                        + syymmdd.charAt(3) + syymmdd.charAt(4) + "."
                        + "18" + syymmdd.charAt(1) + syymmdd.charAt(2);
                // break - not needed
            default: 
                return "" + syymmdd.charAt(5) + syymmdd.charAt(6) + "."
                        + syymmdd.charAt(3) + syymmdd.charAt(4) + "."
                        + "20" + syymmdd.charAt(1) + syymmdd.charAt(2);
                // break - not needed
        }
    }
    
    /**
     * @param syymmdd represents the first 7 characters of
     * the personal numerical code value 
     * @return age of the corresponding personal numerical code
     */
    private String getAge(String syymmdd) {
        int age = 0;
        Calendar now = Calendar.getInstance();
        if ((Integer.parseInt(syymmdd.substring(3, 5)) > (now.get(Calendar.MONTH) + 1))
                || ((Integer.parseInt(syymmdd.substring(3, 5)) == (now.get(Calendar.MONTH) + 1))
                && (Integer.parseInt(syymmdd.substring(3, 5)) >= (now.get(Calendar.DAY_OF_MONTH)))))
            age++;
        switch (syymmdd.charAt(0)) {
            case '1':
            case '2':
                age = now.get(Calendar.YEAR) - Integer.parseInt("19" + syymmdd.substring(1, 3));
                return "" + age;
            case '3':
            case '4':
                age = now.get(Calendar.YEAR) - Integer.parseInt("18" + syymmdd.substring(1, 3));
                return "" + age;
            default: 
                return "UNKNOWN";
        }
    }
    
    /**
     * Displays data based on the personal numerical code
     * 
     * @param cnp - represents the personal numerical code 
     */
    private void printDetails(String cnp) {
        System.out.println("Sex: " + getSex(cnp.charAt(0)) + "\n");
        System.out.println("Age: " + getAge(cnp.substring(0, 7)) + "\n");
        System.out.println("Date of Birth: " 
                + getDateOfBirth(cnp.substring(0, 7)) + "\n");
        System.out.println("Born/Had/Has residency in: " + getCounty(cnp.substring(7, 9)) + "\n");
    }
    
    /**
     * Applies the validation methods to the personal numerical code.
     * 
     * @param cnp represents the personal numerical code
     */
    void validate(String cnp) {
        validateCheckSum(cnp);
        validateLeapYear(cnp.substring(0, 7));
        getCounty(cnp.substring(7, 9));
        if (valid) {
            System.out.println("CNP is valid!\n");
            printDetails(cnp);
        }
        else
            System.out.println("CNP is NOT valid!\n\n" + error);
    }
    
}
