public class Reservation {
    // Reservation ID
    private int id;

    // User email linked to reservation
    private String email;

    // Reserved parking spot ID
    private int spotId;

    // Constructor
    public Reservation(int id, String email, int spotId) {
        this.id = id;
        this.email = email;
        this.spotId = spotId;
    }

    // Getters
    public int getId() { return id; }
    public String getEmail() { return email; }
    public int getSpotId() { return spotId; }

    // Convert object to CSV format (used for file saving)
    @Override
    public String toString() {
        return id + "," + email + "," + spotId;
    }
}