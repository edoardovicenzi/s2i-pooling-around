package solutions.vdesign.util;

public class MainMenuStrategy implements IStrategy {

    public MainMenuStrategy() {

    };

    @Override
    public void execute() {

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
        mainMenu.append("Cosa vuoi fare? ");

        System.out.print(mainMenu.toString());
    }
}
