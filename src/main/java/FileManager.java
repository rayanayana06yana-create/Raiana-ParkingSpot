import java.io.*;
import java.util.*;

public class FileManager {

    // Save all reservations to file (Export functionality)
    public static void saveReservations(List<Reservation> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("reservations.txt"))) {

            for (Reservation r : list) {
                pw.println(r.toString());
            }

        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    // Load reservations from file (Import functionality)
    public static List<Reservation> loadReservations() {
        List<Reservation> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("reservations.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                list.add(new Reservation(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2])
                ));
            }

        } catch (IOException e) {
            System.out.println("No existing file found");
        }

        return list;
    }

    // Export data to CSV file (for presentation requirement)
    public static void exportToCSV(List<Reservation> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("export.csv"))) {

            pw.println("ID,Email,SpotID");

            for (Reservation r : list) {
                pw.println(r.getId() + "," + r.getEmail() + "," + r.getSpotId());
            }

        } catch (IOException e) {
            System.out.println("Export error");
        }
    }

    // Import data from CSV file
    public static List<Reservation> importFromCSV() {
        List<Reservation> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("export.csv"))) {

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                list.add(new Reservation(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2])
                ));
            }

        } catch (IOException e) {
            System.out.println("Import error");
        }

        return list;
    }
}