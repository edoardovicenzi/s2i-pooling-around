package solutions.vdesign.util;

import solutions.vdesign.database.UnitOfWork;
import solutions.vdesign.datatransfer.*;

public class ViewTripsStrategy implements IStrategy {

    @Override
    public void execute() {

        try {
            ConsoleTable.printBanner("Visualizzando tutti i viaggi...");

            ConsoleTable table = new ConsoleTable();
            table.addHeader("ID", 5)
                    .addHeader("Data")
                    .addHeader("Durata", 0)
                    .addHeader("Partenza")
                    .addHeader("Arrivo")
                    .addHeader("Disponibile", 0);

            for (Trip trip : UnitOfWork.trips.getAll()) {
                table.addRow(new String[] {
                        String.valueOf(trip.getId()),
                        trip.getDataString(),
                        String.valueOf(trip.getDurata()),
                        trip.getPartenza(),
                        trip.getArrivo(),
                        trip.getIsDisponibileString()
                });
            }
            System.out.println(table.getTableString());

        } catch (Exception e) {
            ConsoleTable.printBanner("Errore visualizzando i viaggi: " + e.getMessage());
        }
    }
}
