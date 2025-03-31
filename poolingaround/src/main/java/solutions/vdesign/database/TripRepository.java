package solutions.vdesign.database;

import java.util.*;
import solutions.vdesign.datatransfer.*;
import solutions.vdesign.util.*;

public class TripRepository {
    // Needed since we wont implement an update only a save functionality (our
    // database is a file)
    private ArrayList<Trip> trips = CsvParser.getTrips();
    // Needed since we are dealing with static csv
    private int lastId = 0;

    TripRepository() {
        lastId = trips.get(trips.size() - 1).getId();
    }

    // CRUD operations
    public boolean add(Trip newTrip) {
        newTrip.setId(lastId + 1);
        this.lastId = lastId + 1;
        return trips.add(newTrip);
    }

    public void deleteById(int id) {
        Optional<Trip> tripInDatabase = getById(id);
        if (tripInDatabase.isPresent()) {
            trips.remove(tripInDatabase.get().getId());
        }
    }

    public ArrayList<Trip> getAll() {
        return trips;
    }

    public Optional<Trip> getById(int id) {
        return trips
                .stream()
                .filter((trip) -> trip.getId() == id)
                .findFirst();
    }

    public void update(Trip newTrip) {
        for (Trip trip : this.getAll()) {
            if (trip.getId() == newTrip.getId()){
                trip = newTrip;
                return;
            }
        }
        // no match found = add resource
        add(newTrip);
    }

}
