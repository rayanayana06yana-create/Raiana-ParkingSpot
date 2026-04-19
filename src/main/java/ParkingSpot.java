public class ParkingSpot {
    // Unique identifier for parking spot
    private int id;

    // Availability status of the spot
    private boolean available;

    // Constructor
    public ParkingSpot(int id, boolean available) {
        this.id = id;
        this.available = available;
    }

    // Getter methods
    public int getId() { return id; }
    public boolean isAvailable() { return available; }

    // Update availability status
    public void setAvailable(boolean available) {
        this.available = available;
    }
}