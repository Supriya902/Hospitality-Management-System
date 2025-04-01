import java.util.Scanner;

public class HospitalityManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Room[] rooms = {
            new DeluxeRoom(101), new DeluxeRoom(102),
            new SuiteRoom(201), new SuiteRoom(202)
        };

        while (true) {
            System.out.println("\nHospitality Management System");
            System.out.println("1. Book a Room");
            System.out.println("2. View Bookings");
            System.out.println("3. Check-in Guest");
            System.out.println("4. Check-out Guest & Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Stay Duration (nights): ");
                    int nights = scanner.nextInt();

                    System.out.println("\nAvailable Rooms:");
                    for (Room room : rooms) {
                        if (room.isAvailable()) {
                            System.out.println(room);
                        }
                    }

                    System.out.print("Enter Room Number to Book: ");
                    int roomNum = scanner.nextInt();

                    Room selectedRoom = null;
                    for (Room room : rooms) {
                        if (room.roomNumber == roomNum && room.isAvailable()) {
                            selectedRoom = room;
                            break;
                        }
                    }

                    if (selectedRoom != null) {
                        Guest guest = new Guest(name, contact, email, nights);
                        selectedRoom.checkIn(guest);
                        Booking.saveBooking(guest, selectedRoom);
                    } else {
                        System.out.println("Invalid room number or already booked.");
                    }
                    break;

                case 2:
                    Booking.displayBookings();
                    break;

                case 3:
                    System.out.println("Check-in process handled during booking.");
                    break;

                case 4:
                    System.out.print("Enter Room Number to Check-Out: ");
                    int checkOutRoomNum = scanner.nextInt();

                    for (Room room : rooms) {
                        if (room.roomNumber == checkOutRoomNum && !room.isAvailable()) {
                            double totalAmount = room.checkOut();
                            Billing.generateBill(room.currentGuest, room, totalAmount);
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting System. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}