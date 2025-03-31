package solutions.vdesign.database;

import java.util.*;
import solutions.vdesign.datatransfer.*;
import solutions.vdesign.util.*;

public class ReservationRepository {
    // Needed since we wont implement an update only a save functionality (our
    // database is a static file)
    private ArrayList<Reservation> reservations = CsvParser.getReservations();
    // Needed since we are dealing with static csv
    private int lastId = 0;

    ReservationRepository() {
        lastId = reservations.get(reservations.size() - 1).getId();
    }

    // CRUD operations
    public boolean add(Reservation newReservation) {
        newReservation.setId(lastId + 1);
        this.lastId = lastId + 1;
        return reservations.add(newReservation);
    }

    public void deleteById(int id) {
        Optional<Reservation> reservationInDatabase = getById(id);
        if (reservationInDatabase.isPresent()) {
            reservations.remove(reservationInDatabase.get().getId());
        }
    }

    public ArrayList<Reservation> getAll() {
        return reservations;
    }

    public Optional<Reservation> getById(int id) {
        return reservations
                .stream()
                .filter((reservation) -> reservation.getId() == id)
                .findFirst();
    }

    public void update(Reservation newReservation) {
        for (Reservation reservation : reservations) {
            if (reservation.getId() == newReservation.getId()){
                reservation = newReservation;
                return;
            }
        }
        // no match found = add resource
        add(newReservation);
    }

}
