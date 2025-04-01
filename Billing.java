import java.io.FileWriter;
import java.io.IOException;

class Billing {
    private static final String FILE_NAME = "billing.txt";

    public static void generateBill(Guest guest, Room room, double totalAmount) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(guest + " stayed in " + room + " - Total: $" + totalAmount + "\n");
            System.out.println("Bill generated and saved.");
        } catch (IOException e) {
            System.out.println("Error generating bill: " + e.getMessage());
        }
    }
}