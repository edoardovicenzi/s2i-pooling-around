package solutions.vdesign.util;

import java.util.*;

import solutions.vdesign.database.UnitOfWork;
import solutions.vdesign.datatransfer.*;

public class BookingTripStrategy implements IStrategy {
    @Override
    public void execute() {
        try {
            Reservation newReservation = new Reservation();
            ConsoleTable.printBanner("Prenota un viaggio");

            //Get user input
            int userId = Integer.parseInt(ConsoleUtil.getInputString("Dammi l'ID dell'utente: ", "\\d+"));
            int tripId = Integer.parseInt(ConsoleUtil.getInputString("Dammi l'ID del viaggio: ", "\\d+"));

            Optional<Trip> thisTrip = UnitOfWork.trips.getById(tripId);
            Optional<User> thisUser = UnitOfWork.users.getById(userId);
            //Validate constraints or short circuit
            if (!thisTrip.isPresent() || !thisUser.isPresent()){
                ConsoleTable.printBanner("Utente o viaggio non trovato. Perfavore riprova.");
                return;
            }

            //Prepare and add the reservation
            newReservation
                .setUserId(userId)
                .setTripId(tripId);

            UnitOfWork.reservations.add(newReservation);
            // Update the trip availability status
            Trip existingTrip = thisTrip.get();
            existingTrip.setIsDisponibile(false);
            UnitOfWork.trips.update(existingTrip);

            //User feedback
            ConsoleTable.printBanner("Viaggio prenotato!");
            
        } catch (Exception e) {
            ConsoleTable.printBanner("Errore durante la prenotazione: " + e.getMessage());
        }
    }
}
