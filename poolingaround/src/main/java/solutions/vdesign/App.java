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
        Scanner sc = ScannerSingleton.getInstance();
        StrategyContext context = new StrategyContext(new MainMenuStrategy());

        do {
            // always return to the main menu
            context.setStrategy(new MainMenuStrategy());
            context.execute();

            int userChoice = sc.nextInt();
            System.out.println();

            // Parse user action. No action recognize = refresh main menu
            // Quit signal
            if (userChoice == 0) {
                break;
            }
            // View all trips
            if (userChoice == 1) {
                context.setStrategy(new ViewTripsStrategy());
            }
            // Book existing trip
            if (userChoice == 2) {
                context.setStrategy(new BookingTripStrategy());
            }
            // Cancel reservation
            if (userChoice == 3) {
                context.setStrategy(new CancelReservationStrategy());
            }
            // Add User
            if (userChoice == 4) {
                context.setStrategy(new AddUserStrategy());
            }
            // Export available trips
            if (userChoice == 5) {
                context.setStrategy(new ExportStrategy());
            }
            //Admin only option
            if (UserEntity.getInstance().getIsAdmin()){

                if (userChoice == 6) {
                    context.setStrategy(new ViewAllReservationsStrategy());
                }

                if (userChoice == 7) {
                    context.setStrategy(new ViewAllUsersStrategy());
                }
            }
            else{
                if (userChoice == 6) {
                    context.setStrategy(new AdminLoginStrategy());
                }
            }

            // exectute the strategy
            context.execute();
        } while (true);
    }

}
