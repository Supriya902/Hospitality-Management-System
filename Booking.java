import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Booking {
    private static final String FILE_NAME = "bookings.txt";

    public static void saveBooking(Guest guest, Room room) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(guest + " -> " + room + "\n");
            System.out.println("Booking saved.");
        } catch (IOException e) {
            System.out.println("Error saving booking: " + e.getMessage());
        }
    }

    public static void displayBookings() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Bookings ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No bookings found.");
        }
    }
}