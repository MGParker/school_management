package za.ac.cput.helper;

/*
 * Name.java
 * entity for the Name
 * Author: Benelzane Kholani (218257465)
 * Date: 15 June 2022
 *
 */

import org.apache.commons.lang3.StringUtils;

public class NameHelper {
    public static boolean isEmptyOrNull(String str){return StringUtils.isEmpty(str);}
    public static void checkStringParam(String paramName, String paramValue){
        if (isEmptyOrNull(paramValue)){
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
        }
    }
}
