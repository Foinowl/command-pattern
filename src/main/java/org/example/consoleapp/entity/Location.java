package org.example.consoleapp.entity;

public enum Location {
    KITCHEN("Kitchen"),
    HALL("Hall"),
    LIVING_ROOM("Living room"),
    BAD_ROOM("Bad room"),
    CABINET("Cabinet");

    private final String roomName;

    /**
     * Constructor of class
     *
     * @param roomName name of room
     */
    Location(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    @Override
    public String toString() {
        return "Location{" +
            "roomName='" + roomName + '\'' +
            '}';
    }
}
