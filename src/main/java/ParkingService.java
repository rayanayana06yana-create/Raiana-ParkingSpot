import java.util.*;

public class ParkingService {

    public List<Reservation> getReservationsList() {
        return this.reservations;
    }

    public void setReservationsList(List<Reservation> newList) {
        this.reservations = newList;
    }
    // List of parking spots
    private List<ParkingSpot> spots = new ArrayList<>();

    // List of reservations
    private List<Reservation> reservations;

    // Initialize system with default spots and load data from file
    public ParkingService() {

        // Create default parking spots
        for (int i = 1; i <= 10; i++) {
            spots.add(new ParkingSpot(i, true));
        }

        // Load saved reservations (data persistence)
        reservations = FileManager.loadReservations();

        // Update availability based on existing reservations
        for (Reservation r : reservations) {
            for (ParkingSpot s : spots) {
                if (s.getId() == r.getSpotId()) {
                    s.setAvailable(false);
                }
            }
        }
    }

    // CREATE reservation
    public void reserveSpot(String email, int spotId) {

        // Simple email validation
        if (!email.contains("@")) {
            System.out.println("Invalid email");
            return;
        }

        for (ParkingSpot spot : spots) {

            if (spot.getId() == spotId) {

                if (!spot.isAvailable()) {
                    System.out.println("Spot already taken");
                    return;
                }

                spot.setAvailable(false);

                reservations.add(
                        new Reservation(reservations.size() + 1, email, spotId)
                );

                FileManager.saveReservations(reservations);

                System.out.println("Reservation successful");
                return;
            }
        }

        System.out.println("Spot not found");
    }

    // READ all spots
    public void viewSpots() {
        for (ParkingSpot s : spots) {
            System.out.println("Spot " + s.getId() + " | Available: " + s.isAvailable());
        }
    }

    // READ all reservations
    public void viewReservations() {
        for (Reservation r : reservations) {
            System.out.println(r.getId() + " | " + r.getEmail() + " | " + r.getSpotId());
        }
    }

    // DELETE reservation
    public void cancelReservation(int id) {

        for (Reservation r : reservations) {
            if (r.getId() == id) {

                // Free parking spot
                for (ParkingSpot s : spots) {
                    if (s.getId() == r.getSpotId()) {
                        s.setAvailable(true);
                    }
                }

                reservations.remove(r);
                FileManager.saveReservations(reservations);

                System.out.println("Reservation cancelled");
                return;
            }
        }

        System.out.println("Reservation not found");
    }

    // UPDATE reservation
    public void updateReservation(int id, int newSpotId) {

        for (Reservation r : reservations) {
            if (r.getId() == id) {

                for (ParkingSpot s : spots) {
                    if (s.getId() == newSpotId && s.isAvailable()) {

                        s.setAvailable(false);

                        reservations.remove(r);
                        reservations.add(new Reservation(id, r.getEmail(), newSpotId));

                        FileManager.saveReservations(reservations);

                        System.out.println("Updated successfully");
                        return;
                    }
                }

                System.out.println("New spot not available");
                return;
            }
        }

        System.out.println("Reservation not found");
    }
}