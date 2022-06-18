package za.ac.cput.helper;

/*
 CountryHelper.java
 Author: Kamaludien Sonday (218168128)
 */

import org.apache.commons.lang3.StringUtils;

public class CountryHelper {

    public static boolean isEmptyOrNull(String str){return StringUtils.isEmpty(str);}
    public static void checkStringParam(String paramName, String paramValue){
        if (isEmptyOrNull(paramValue)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
        }
    }


}
