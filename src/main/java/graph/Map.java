
package graph;

import java.util.List;

public class Map {
    
    private List<Coordinate> coordinates;
    
    public Map(){}
    
    public void addCoordinateToMap(Coordinate cor) {
        this.coordinates.add(cor);
    }
    
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
    
}
