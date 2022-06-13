package za.ac.cput.helper;

import java.util.UUID;

public class Helper {
    public static boolean isNullEmpty(String s){
        return (s == null || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    public static String generateId(){
        return UUID.randomUUID().toString();
    }

}
