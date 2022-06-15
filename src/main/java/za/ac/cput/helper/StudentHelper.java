package za.ac.cput.helper;

import java.util.UUID;
import org.apache.commons.validator.routines.EmailValidator;

public class StudentHelper {
    //check for blank, empty or null values
    public static boolean isBlankOrEmptyOrNull(String string){
        return (string.isBlank() ||
                string.isEmpty() ||
                string.equals(null) ||
                string.equalsIgnoreCase("null"));
    }

    //display which IllegalArgumentException
    public static void checkParam(String paramName, String param){
        if (isBlankOrEmptyOrNull(param)){
            throw new IllegalArgumentException(String.format("Invalid value for parameter: %s", param));
        }
    }

    public static boolean checkEmail(String email){
        return EmailValidator.getInstance().isValid(email);
    }
}
