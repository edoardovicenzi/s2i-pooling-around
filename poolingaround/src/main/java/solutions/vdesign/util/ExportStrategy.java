package solutions.vdesign.util;

import java.nio.charset.Charset;
import java.io.*;
import java.time.LocalDate;
import java.nio.file.*;

import solutions.vdesign.database.UnitOfWork;
import solutions.vdesign.datatransfer.Trip;

public class ExportStrategy implements IStrategy {

    @Override
    public void execute() {

        ConsoleTable.printBanner("Esportando in formato .csv ...");

        // prepare csv headers
        StringBuilder csvStringBuilder = new StringBuilder();
        csvStringBuilder.append("ID;");
        csvStringBuilder.append("Data;");
        csvStringBuilder.append("Durata;");
        csvStringBuilder.append("Partenza;");
        csvStringBuilder.append("Arrivo;");
        csvStringBuilder.append("\n");

        try {
            // Populate string builder
            for (Trip trip : UnitOfWork.trips.getAll()) {
                // Get only available
                if (trip.getIsDisponibile()) {
                    csvStringBuilder.append(trip.getId() + ";");
                    csvStringBuilder.append(trip.getDataString() + ";");
                    csvStringBuilder.append(trip.getDurata() + ";");
                    csvStringBuilder.append(trip.getPartenza() + ";");
                    csvStringBuilder.append(trip.getArrivo() + ";");
                    csvStringBuilder.append("\n");
                }
            }

            exportToCsv(csvStringBuilder.toString());

            // User Feedback
            ConsoleTable.printBanner("Fatto! Controlla la tua cartella Downloads!");

        } catch (Exception e) {
            ConsoleTable.printBanner("Non è stato possibile esportare il file: " + e.getMessage());
        }
    }

    private void exportToCsv(String content) throws IOException {
        // Export to file in the downloads directory
        Charset charset = Charset.forName("UTF-8");
        String home = System.getProperty("user.home");
        String filename = "viaggi_" + LocalDate.now().toString().replace("-", "_") + ".csv";
        Path filePath = Paths.get(home, "Downloads", filename);

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, charset)) {
            writer.write(content, 0, content.length());
        } catch (IOException e) {
            throw new IOException(e);
        }

    }
}
