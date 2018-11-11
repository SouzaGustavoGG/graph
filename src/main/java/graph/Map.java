
package graph;

import java.util.ArrayList;
import java.util.List;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Map {
   
    private final List<Coordinate> coordinates;
    
    public Map() {
        this.coordinates = new ArrayList<>();
    }
    
    public void addCoordinate(Coordinate cor) {
        try {
            this.coordinates.add(cor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private List<Coordinate> getCoordinates() {
        return this.coordinates;
    }
       
    public XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Cidades");

        List<Coordinate> coordinates = this.getCoordinates();
        
        coordinates.forEach((coordinate) -> {
            series.add(coordinate.getPosX(), coordinate.getPosY());
        });
        
        
        dataset.addSeries(series);        
        return dataset;
    }
    
    
}
    

