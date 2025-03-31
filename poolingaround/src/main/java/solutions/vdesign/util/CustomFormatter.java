package solutions.vdesign.util;

import java.text.*;
import java.util.*;
import java.util.regex.*;

public class CustomFormatter {
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    public static void setDateFormat(String newDateFormat) {
        dateFormatter = new SimpleDateFormat(newDateFormat);
    }

    public static boolean isValidDate(String input){
        dateFormatter.setLenient(false);
        try {
            Date date = dateFormatter.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static Optional<Date> parseStringToDate(String input){
        //Allows to strictly match the pattern
        dateFormatter.setLenient(false);
        try {
            return Optional.of(dateFormatter.parse(input));
        } catch (ParseException e) {
            return Optional.of(null);
        }
    }

    public static String getDateString(Date date){
        return dateFormatter.format(date);
    }

    public static boolean isStringWordOnly(String input){
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]$");
        Matcher matcher = pattern.matcher(input);
        boolean isDigitFound = matcher.find();
        return !isDigitFound;
    }
}
