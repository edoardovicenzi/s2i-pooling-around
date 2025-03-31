package solutions.vdesign.database;

public class UnitOfWork {
    private static UnitOfWork instance = new UnitOfWork();

    public static TripRepository trips = new TripRepository();
    public static ReservationRepository reservations = new ReservationRepository();
    public static UserRepository users = new UserRepository();

    private UnitOfWork() {
    };

    public static UnitOfWork getInstance() {
        return instance;
    }

}
