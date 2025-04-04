package solutions.vdesign.util;

public class MainMenuStrategy implements IStrategy {

    public MainMenuStrategy() {

    };

    @Override
    public void execute() {
        StrategyContext context = new StrategyContext(new MainMenuStrategy());

        do {
            // always return to the main menu
            printMainMenu();

            //get user input
            String userInput = ConsoleUtil.getInputString("Cosa vuoi fare: ", "\\d{1}");
            int userChoice = Integer.parseInt(userInput);
            System.out.println();

            // Parse user action. No action recognize = refresh main menu
            // Quit option, parse immediately
            if (userChoice == 0) {
                break;
            }

            switch (userChoice) {
                case 1:
                    // View all trips
                    context.setStrategy(new ViewTripsStrategy());
                    break;
                case 2:
                    // Book existing trip
                    context.setStrategy(new BookingTripStrategy());
                    break;
                case 3:
                    // Cancel reservation
                    context.setStrategy(new CancelReservationStrategy());
                    break;
                case 4:
                    // Add User
                    context.setStrategy(new AddUserStrategy());
                    break;
                case 5:
                    // Export available trips
                    context.setStrategy(new ExportStrategy());
                    break;
                case 6:
                    //Admin only option
                    if (UserEntity.getInstance().getIsAdmin()){
                        context.setStrategy(new ViewAllReservationsStrategy());
                    }
                    //Default to ask admin credentials
                    else {
                        context.setStrategy(new AdminLoginStrategy());
                    }
                    break;
                case 7:
                    //Admin only option
                    if (UserEntity.getInstance().getIsAdmin()){
                        context.setStrategy(new ViewAllUsersStrategy());
                    }
                    break;
            
                default:
                    context.setStrategy(new MainMenuStrategy());
                    break;
            }

            // exectute the strategy
            context.execute();
        } while (true);
    }
    private void printMainMenu (){
        ConsoleTable.printBanner("Menu Principale");

        StringBuilder mainMenu = new StringBuilder("\n");

        mainMenu.append("\n");
        mainMenu.append("\t");
        mainMenu.append("1) Visualizzare tutti i viaggi all'interno del sistema");

        mainMenu.append("\n");
        mainMenu.append("\t");
        mainMenu.append("2) Prenotare un viaggio esistente");

        mainMenu.append("\n");
        mainMenu.append("\t");
        mainMenu.append("3) Disdire prenotazione di un viaggio");

        mainMenu.append("\n");
        mainMenu.append("\t");
        mainMenu.append("4) Aggiungere nuovo utente");

        mainMenu.append("\n");
        mainMenu.append("\t");
        mainMenu.append("5) Esportare un file con i viaggi disponibili");
        // Admin only option
        if (UserEntity.getInstance().getIsAdmin()) {
            mainMenu.append("\n");

            mainMenu.append("\n");
            mainMenu.append("\t");
            mainMenu.append("6) Mostra tutte le prentozaioni");

            mainMenu.append("\n");
            mainMenu.append("\t");
            mainMenu.append("7) Mostra tutti gli utenti");
        } else {
            mainMenu.append("\n");

            mainMenu.append("\n");
            mainMenu.append("\t");
            mainMenu.append("6) Effettua login come admin");

        }

        mainMenu.append("\n");
        mainMenu.append("\n");
        mainMenu.append("\t");
        mainMenu.append("0) Uscire dal programma");
        mainMenu.append("\n");

        mainMenu.append("\n");
        mainMenu.append("\n");

        System.out.print(mainMenu.toString());
    }

}
