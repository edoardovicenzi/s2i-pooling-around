package solutions.vdesign.util;

import solutions.vdesign.database.UnitOfWork;
import solutions.vdesign.datatransfer.*;

public class ViewAllReservationsStrategy implements IStrategy {

    @Override
    public void execute() {

        try {
            ConsoleTable.printBanner("Visualizzando tutte le prenotazioni...");

            ConsoleTable table = new ConsoleTable();
            table.addHeader("ID", 5)
                    .addHeader("ID Utente", 5)
                    .addHeader("ID Viaggio", 5);

            for (Reservation reservation : UnitOfWork.reservations.getAll()) {
                table.addRow(new String[] {
                        String.valueOf(reservation.getId()),
                        String.valueOf(reservation.getUserId()),
                        String.valueOf(reservation.getTripId()),
                });
            }
            System.out.println(table.getTableString());

        } catch (Exception e) {
            ConsoleTable.printBanner("Errore visualizzando le prenotazioni: " + e.getMessage());
        }
    }
}
