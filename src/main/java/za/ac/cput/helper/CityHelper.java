package za.ac.cput.helper;
/*
 CityHelper.java
 Helper for the City factory
 Author: Mogamad Githr Parker (220408025)
 Date: 18/06/2022
 */

import org.apache.commons.lang3.StringUtils;

public class CityHelper {

    public static boolean isEmptyOrNull(String str) {
        return StringUtils.isEmpty(str);
    }

    public static void checkStringParam(String paramName, String paramValue) {
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }

    public static void checkingEntityParam(String paramName, Object paramValue){
        if(paramValue.equals(null)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
        }
    }
}
