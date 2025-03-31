package solutions.vdesign.util;

import java.util.Scanner;

public class ScannerSingleton {
    private static Scanner instance;

    private ScannerSingleton() {
        instance = new Scanner(System.in);
    }

    public static Scanner getInstance() {
        if (instance == null) {
            new ScannerSingleton();
        }
        return instance;
    }

    public static int getNextInt() {
        int input = instance.nextInt();
        instance.nextLine();
        return input;
    }

    public static String getNextString() {
        String input = instance.next();
        instance.nextLine();
        return input;
    }
}
