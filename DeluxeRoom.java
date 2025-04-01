class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber) { super(roomNumber, 2000); }

    @Override
    public String toString() { return "Deluxe " + super.toString(); }
}