package solutions.vdesign.util;

import java.util.ArrayList;

import solutions.vdesign.datatransfer.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class CsvParser {
    private static String assetsPathString = "src/main/java/solutions/vdesign/assets";
    private static Charset charset = Charset.forName("UTF-8");

    private static enum Tables {
        USER,
        RESERVATION,
        TRIP
    };

    public static ArrayList<User> getUsers() {
        ArrayList<User> savedUsers = new ArrayList<User>();
        savedUsers = populateFromCSV(Tables.USER, User.class);

        return savedUsers;
    }

    public static ArrayList<Trip> getTrips() {
        ArrayList<Trip> savedTrips = new ArrayList<Trip>();
        savedTrips = populateFromCSV(Tables.TRIP, Trip.class);
        return savedTrips;
    }

    public static ArrayList<Reservation> getReservations() {
        ArrayList<Reservation> savedReservations = new ArrayList<Reservation>();
        savedReservations = populateFromCSV(Tables.RESERVATION, Reservation.class);
        return savedReservations;
    }

    private static Path getCSVPath(Tables tableRef) {
        String resourceName;
        switch (tableRef) {
            case USER:
                resourceName = "utenti";
                break;

            case RESERVATION:
                resourceName = "prenotazioni";
                break;

            case TRIP:
                resourceName = "viaggi";
                break;

            default:
                throw new RuntimeException("CSV Table not found.");
        }
        return Paths.get(assetsPathString, resourceName + ".csv");
    }

    private static <T> ArrayList<T> populateFromCSV(Tables type, Class<T> clazz) {

        ArrayList<T> resultArrayList = new ArrayList<>();

        Path filePath = getCSVPath(type);

        try (BufferedReader inputStream = Files.newBufferedReader(filePath, charset)) {
            // Skip the first line
            inputStream.readLine();

            String line;
            while ((line = inputStream.readLine()) != null) {
                String[] fields = line.split(";");
                if (clazz.equals(User.class)) {
                    User newUser = new User();

                    newUser
                            .setId(Integer.parseInt(fields[0]))
                            .setNome(fields[1])
                            .setCognome(fields[2])
                            .setDataNascita(CustomFormatter.parseStringToDate(fields[3]).get())
                            .setIndirizzo(fields[4])
                            .setIdDocumento(fields[5]);

                    resultArrayList.add(clazz.cast(newUser));

                } else if (clazz.equals(Reservation.class)) {

                    Reservation newReservation = new Reservation();

                    newReservation
                            .setId(Integer.parseInt(fields[0]))
                            .setTripId(Integer.parseInt(fields[1]))
                            .setUserId(Integer.parseInt(fields[2]));

                    resultArrayList.add(clazz.cast(newReservation));
                }

                else if (clazz.equals(Trip.class)) {
                    Trip newTrip = new Trip();

                    newTrip
                            .setId(Integer.parseInt(fields[0]))
                            .setData(CustomFormatter.parseStringToDate(fields[1]).get())
                            .setDurata(Integer.parseInt(fields[2]))
                            .setPartenza(fields[3])
                            .setArrivo(fields[4])
                            .setIsDisponibile(fields[5]);

                    resultArrayList.add(clazz.cast(newTrip));
                } else {
                    throw new RuntimeException("Table type does not exist, unable to load data...");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultArrayList;

    }

}
