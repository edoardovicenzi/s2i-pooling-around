package solutions.vdesign.util;

import solutions.vdesign.database.UnitOfWork;
import solutions.vdesign.datatransfer.User;

public class AddUserStrategy implements IStrategy {

    @Override
    public void execute() {

        UserDecorator newUser = new UserDecorator();
        ConsoleTable.printBanner("Aggiungi un utente");

        try {
            newUser.inputName()
                    .inputSurname()
                    .inputBirthDate()
                    .inputAddress()
                    .inputIDCardIdentifier();

            UnitOfWork.users.add(newUser.getUser());
            ConsoleTable.printBanner("Nuovo utente salvato!");

        } catch (Exception e) {
            ConsoleTable.printBanner("Impossibile salvare l'utente: " + e.getMessage());
        }


    }
}
