package solutions.vdesign.util;

import java.util.*;

public class ConsoleUtil {

    private static Scanner sc = ScannerSingleton.getInstance();

    public static String getInputString(String prompt) {
        return getInputString(prompt, ".+");
    }

    public static String getInputString(String prompt, String regex) {
        String input;

        System.out.print(prompt);

        while (true) {
            input = sc.nextLine();

            if (input.matches(regex)){
                break;
            }
        }
        return input;

    }

    public static Date getInputDate(String prompt) {
        String input;

        System.out.print(prompt);

        while (true) {
            input = sc.nextLine();

            if (CustomFormatter.isValidDate(input)){
                break;
            }
        }

        return CustomFormatter.parseStringToDate(input).get();

    }

}
