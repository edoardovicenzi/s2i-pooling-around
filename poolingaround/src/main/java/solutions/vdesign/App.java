package solutions.vdesign;

import java.util.*;

import solutions.vdesign.util.*;

public class App {

    public static void main(String[] args) {
        Scanner sc = ScannerSingleton.getInstance();

        ConsoleTable.printBanner("PoolingAround Console");

        start();

        // Cleanup Scanner
        sc.close();
    }

    private static void start() {
        StrategyContext context = new StrategyContext(new MainMenuStrategy());
        context.execute();
    }

}
