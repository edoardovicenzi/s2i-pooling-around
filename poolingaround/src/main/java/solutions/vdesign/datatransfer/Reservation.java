package solutions.vdesign.datatransfer;

public class Reservation extends BaseDTO {
    private int id;
    private int tripId;
    private int userId;

    // Builder pattern setters

    public Reservation setId(int newId) {
        this.id = newId;
        return this;
    }

    public Reservation setTripId(int newTripId) {
        this.tripId = newTripId;
        return this;
    }

    public Reservation setUserId(int newUserId) {
        this.userId = newUserId;
        return this;
    }

    // Getters

    public int getId() {
        return this.id;
    }

    public int getTripId() {
        return this.tripId;
    }

    public int getUserId() {
        return this.userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append("\n");

        sb.append("\t");
        sb.append("ID: " + this.id);
        sb.append("\n");

        sb.append("\t");
        sb.append("Id Viaggio: " + this.tripId);
        sb.append("\n");

        sb.append("\t");
        sb.append("Id Utente: " + this.userId);
        sb.append("\n");


        sb.append("}");
        return sb.toString();
    }
}
