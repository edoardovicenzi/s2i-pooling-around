package solutions.vdesign.util;

import java.util.Optional;

import solutions.vdesign.database.UnitOfWork;
import solutions.vdesign.datatransfer.*;

public class CancelReservationStrategy implements IStrategy {
    @Override
    public void execute() {

        try {
            ConsoleTable.printBanner("Disdici una prenotazione");

            int reservationId = Integer.parseInt(ConsoleUtil.getInputString("Dimmi l'ID della prenotazione: ", "\\d+"));

            for (Reservation reservation : UnitOfWork.reservations.getAll()) {
                if (reservation.getId() == reservationId){
                    //Hold references
                    int tripId = reservation.getTripId();
                    //Delete reeservation
                    UnitOfWork.reservations.deleteById(reservationId);
                    //Update trip availability
                    Optional<Trip> correspondingTrip = UnitOfWork.trips.getById(tripId);
                    //This is another precaution to update only if there is a valid Trip
                    if (correspondingTrip.isPresent()){
                        Trip existingTrip = correspondingTrip.get();
                        correspondingTrip.get().setIsDisponibile(true);
                        UnitOfWork.trips.update(existingTrip);
                    }

                }
            }

        } catch (Exception e) {
            ConsoleTable.printBanner("Errore durante l'annullamento di una prenotazione: " + e.getMessage());
        }

    }
}
