
package graph;

import java.util.List;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Map {
   
    private List<Coordinate> coordinates;
    
    public void addCoordinate(Coordinate cor) {
        this.coordinates.add(cor);
    }
    
    private List<Coordinate> getCoordinates() {
        return this.coordinates;
    }
       
    
    private XYDataset createDataset() {
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
    

