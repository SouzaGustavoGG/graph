
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
            Coordinate tmp = this.getCordinateByName(cor.getName());
            if(tmp == null) { // Check to see if this name has been used already
                this.coordinates.add(cor);
            }           
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private List<Coordinate> getCoordinates() {
        return this.coordinates;
    }
    
    public String calculateDistance(Coordinate cor1, Coordinate cor2) {
        int diff_x = Math.abs(cor1.getPosX() - cor2.getPosX());
        int diff_y = Math.abs(cor1.getPosY() - cor2.getPosY());
        
        return diff_x + diff_y + "";        
    }
    
    public Coordinate getCordinateByName(String name) {        
        for(Coordinate cor : this.getCoordinates()){
            if(cor.getName().equals(name)){
                    return cor; 
            }
        }
  
        return null;       
    }
       
    public XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        

        List<Coordinate> coordinates = this.getCoordinates();
        
        coordinates.forEach((coordinate) -> {
            XYSeries series = new XYSeries(coordinate.getName());
            series.add(coordinate.getPosX(), coordinate.getPosY());
            dataset.addSeries(series);
        });
        

        return dataset;
    }
    
    
}
    

