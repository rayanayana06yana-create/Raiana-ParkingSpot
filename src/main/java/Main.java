import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ParkingService service = new ParkingService();

        System.out.println("\nWelcome to the Smart Parking Manager!");
        System.out.println("Easily manage, track, and book parking spots.");
        System.out.println("\nPlease select an option from the menu below to start:");

        while (true) {
            System.out.println("\n1. View spots");
            System.out.println("2. Reserve Spot");
            System.out.println("3. View Reservations");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Update Reservation");
            System.out.println("6. Exit");
            System.out.println("\nYour choice: ");


            int choice = getValidInt(scanner);

            switch (choice) {
                case 1:
                    service.viewSpots();
                    break;

                case 2:
                    System.out.println("Enter email: ");
                    String email = scanner.next();
                    System.out.println("Enter spot ID: ");
                    int spot = scanner.nextInt();
                    service.reserveSpot(email, spot);
                    break;

                case 3:
                    service.viewReservations();
                    break;

                case 4:
                    System.out.println("Enter reservation ID: ");
                    int id = scanner.nextInt();
                    service.cancelReservation(id);
                    break;

                case 5:
                    System.out.println("Reservation ID: ");
                    int rid = scanner.nextInt();
                    System.out.println("New  Spot ID: ");
                    int newSpot = scanner.nextInt();
                    service.updateReservation(rid, newSpot);
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static int getValidInt(Scanner scanner) {
        while(true) {
            String input = scanner.next();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error! Please enter a number: ");
            }
        }
    }
}
