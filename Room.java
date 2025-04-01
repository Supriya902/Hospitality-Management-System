import java.io.Serializable;

class Room implements Serializable {
    protected int roomNumber;
    protected double pricePerNight;
    protected boolean isAvailable;
    protected Guest currentGuest;

    public Room(int roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    public boolean isAvailable() { return isAvailable; }

    public void checkIn(Guest guest) {
        if (isAvailable) {
            this.currentGuest = guest;
            this.isAvailable = false;
            System.out.println("Room " + roomNumber + " checked in successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is already occupied.");
        }
    }

    public double checkOut() {
        if (!isAvailable) {
            double totalBill = pricePerNight * currentGuest.getStayDuration();
            System.out.println("Room " + roomNumber + " checked out. Bill: $" + totalBill);
            this.isAvailable = true;
            return totalBill;
        }
        System.out.println("Room is already available.");
        return 0;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " - $" + pricePerNight + " per night - " + (isAvailable ? "Available" : "Occupied");
    }
}