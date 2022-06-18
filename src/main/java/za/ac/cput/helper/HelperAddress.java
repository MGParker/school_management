/* HelperAddress.java
 Helper class for entities assigned to me Address, Employee and EmployeeAddress
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.helper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;

public class HelperAddress {

    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str){
        if(isEmptyOrNull(str))return StringUtils.EMPTY;
        return str;
    }

    public static void checkingStringParam(String paramName, String paramValue){
        if(isEmptyOrNull(paramValue)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s" , paramName));
        }
    }

    public static void checkingIntParam(String paramName, int paramValue){
        if(paramValue == 0 || paramName.isEmpty() || !(paramValue >= 1000 && paramValue <= 9999)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s" , paramName));
        }
    }

    public static void checkingEntityParam(String paramName, Object paramValue){
        if(paramValue.equals(null)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s" , paramName));
        }
    }

    public static void checkingEmailParam(String paramName, String paramValue){
        if(!EmailValidator.getInstance().isValid(paramValue)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s" , paramName));
        }
    }


}
