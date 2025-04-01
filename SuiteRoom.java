class SuiteRoom extends Room {
    public SuiteRoom(int roomNumber) { super(roomNumber, 4000); }

    @Override
    public String toString() { return "Suite " + super.toString(); }
}