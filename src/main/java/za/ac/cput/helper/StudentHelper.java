/*
 * StudentHelper.java
 * StudentHelper class to help manage functions for the StudentFactory
 * Rhegan Albert Fortuin 219273693
 * Date of last edit:2022/06/18
 */

package za.ac.cput.helper;

import org.apache.commons.lang3.StringUtils;

public class StudentHelper {
    //***check for blank or null values string***
    public static boolean isBlankOrNull(String str) {
        return StringUtils.isEmpty(str);
    }

    //***display which IllegalArgumentException***
    public static void checkParam(String paramName, String paramValue) {
        if (isBlankOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
    }
}
