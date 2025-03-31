package solutions.vdesign.util;

import solutions.vdesign.database.UnitOfWork;
import solutions.vdesign.datatransfer.*;

public class ViewAllUsersStrategy implements IStrategy {

    @Override
    public void execute() {

        try {
            ConsoleTable.printBanner("Visualizzando tutti gli utenti...");

            ConsoleTable table = new ConsoleTable();
            table.addHeader("ID", 5)
                    .addHeader("Nome", 15)
                    .addHeader("Cognome", 15)
                    .addHeader("Data di nascita", 0)
                    .addHeader("Indirizzo", 40)
                    .addHeader("ID Documento", 5);

            for (User user : UnitOfWork.users.getAll()) {
                table.addRow(new String[] {
                        String.valueOf(user.getId()),
                        user.getNome(),
                        user.getCognome(),
                        user.getDataNascitaString(),
                        user.getIndirizzo(),
                        user.getIdDocumento()
                });
            }
            System.out.println(table.getTableString());

        } catch (Exception e) {
            ConsoleTable.printBanner("Errore visualizzando gli utenti: " + e.getMessage());
        }
    }
}
