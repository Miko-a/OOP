import java.util.List;
import java.util.ArrayList;

public class Field {
    private Object[][] field;

    public Field (int depth, int width) {
        field = new Object[depth][width];
    }
    
    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    public void place(Object object, Location location) {
        field[location.getRow()][location.getCol()] = object;
    }

    public Object getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public Location freeAdjacentLocation(Location location) {
        List<Location> free = new ArrayList<>();
        List<Location> adjacent = adjacentLocations(location);
        
        for(Location loc : adjacent) {
            if (getObjectAt(loc) == null) {
                free.add(loc);
            }
        }
        return free.isEmpty() ? null : free.get(0);
    }

    public List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();
        if (location == null) return locations;

        int row = location.getRow();
        int col = location.getCol();

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                
                if (dr == 0 && dc == 0) continue;
                int newRow = row + dr;
                int newCol = col + dc;
                Location loc = new Location(newRow, newCol);
                if (inBounds(loc)) {
                    locations.add(loc);
                }
            }
        }
        return locations;
    }

    private boolean inBounds(int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field[0].length;
    }

    // overload
    private boolean inBounds(Location loc) {
        return inBounds(loc.getRow(), loc.getCol());
    }

    public int getRow(){
        return field.length;
    }

    public int getCol(){
        return field[0].length;
    }

    public void clearAll(){
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[i].length; j++){
                field[i][j] = null;
            }
        }
    }

}