public class Room {
    public String description;
    public Room northExit;
    public Room southExit;
    public Room westExit;
    public Room eastExit;

    public Room(String description) {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        if (north != null) northExit = north;
        if (east != null) eastExit = east;
        if (south != null) southExit = south;
        if (west != null) westExit = west;
    }

    public String getDescription() {
        return description;
    }
}
