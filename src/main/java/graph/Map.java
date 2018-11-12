
package graph;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import graph.search.AStar;

public class Map {
   
    private final List<Coordinate> coordinates;
    private Graph<Double, Double> graphAStar;
    
    public Map() {
        this.coordinates = new ArrayList<>();
        this.graphAStar = new Graph<>(false);
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
    
    public String calculateDistance(String corName1, String corName2) {
        Coordinate cor1 = this.getCordinateByName(corName1);
        Coordinate cor2 = this.getCordinateByName(corName2);
        
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
    
    public void getAStar(String startId, String stopId){
    	
    	this.graphAStar = new Graph<>(false);
    	this.graphAStar.addVertex("F", stopId.equals("F") ? new Double(0.0) : Double.valueOf(calculateDistance("F", stopId)));
    	this.graphAStar.addVertex("G", stopId.equals("G") ? new Double(0.0) :Double.valueOf(calculateDistance("G", stopId)));
    	this.graphAStar.addVertex("H", stopId.equals("H") ? new Double(0.0) :Double.valueOf(calculateDistance("H", stopId)));
    	this.graphAStar.addVertex("I", stopId.equals("I") ? new Double(0.0) :Double.valueOf(calculateDistance("I", stopId)));
    	this.graphAStar.addVertex("J", stopId.equals("J") ? new Double(0.0) :Double.valueOf(calculateDistance("J", stopId)));
    	this.graphAStar.addVertex("K", stopId.equals("K") ? new Double(0.0) :Double.valueOf(calculateDistance("K", stopId)));
    	this.graphAStar.addVertex("L", stopId.equals("L") ? new Double(0.0) :Double.valueOf(calculateDistance("L", stopId)));
    	this.graphAStar.addVertex("M", stopId.equals("M") ? new Double(0.0) :Double.valueOf(calculateDistance("M", stopId)));
    	this.graphAStar.addVertex("N", stopId.equals("N") ? new Double(0.0) :Double.valueOf(calculateDistance("N", stopId)));
    	this.graphAStar.addVertex("O", stopId.equals("O") ? new Double(0.0) :Double.valueOf(calculateDistance("O", stopId)));
    	this.graphAStar.addVertex("P", stopId.equals("P") ? new Double(0.0) :Double.valueOf(calculateDistance("P", stopId)));
    	this.graphAStar.addVertex("Q", stopId.equals("Q") ? new Double(0.0) :Double.valueOf(calculateDistance("Q", stopId)));
    	this.graphAStar.addVertex("R", stopId.equals("R") ? new Double(0.0) :Double.valueOf(calculateDistance("R", stopId)));
    	this.graphAStar.addVertex("S", stopId.equals("S") ? new Double(0.0) :Double.valueOf(calculateDistance("S", stopId)));
    	this.graphAStar.addVertex("T", stopId.equals("T") ? new Double(0.0) :Double.valueOf(calculateDistance("T", stopId)));
    	
    	this.graphAStar.addEdge("PK", Double.valueOf(calculateDistance("P","K")), "P", "K");
    	this.graphAStar.addEdge("PH", Double.valueOf(calculateDistance("P","H")), "P", "H");
    	this.graphAStar.addEdge("PN", Double.valueOf(calculateDistance("P","N")), "P", "N");
    	this.graphAStar.addEdge("PT", Double.valueOf(calculateDistance("P","T")), "P", "T");
    	this.graphAStar.addEdge("PJ", Double.valueOf(calculateDistance("P","J")), "P", "J");
    	
    	this.graphAStar.addEdge("MK", Double.valueOf(calculateDistance("M","K")), "M", "K");
    	this.graphAStar.addEdge("MO", Double.valueOf(calculateDistance("M","O")), "M", "O");
    	this.graphAStar.addEdge("MD", Double.valueOf(calculateDistance("M","D")), "M", "D");
    	
    	this.graphAStar.addEdge("DR", Double.valueOf(calculateDistance("D","R")), "D", "R");
    	this.graphAStar.addEdge("MD", Double.valueOf(calculateDistance("D","L")), "D", "L");
    	
    	this.graphAStar.addEdge("LA", Double.valueOf(calculateDistance("L","A")), "L", "A");
    	this.graphAStar.addEdge("LR", Double.valueOf(calculateDistance("L","R")), "L", "R");
    	
    	this.graphAStar.addEdge("AE", Double.valueOf(calculateDistance("A","E")), "A", "E");
    	this.graphAStar.addEdge("AS", Double.valueOf(calculateDistance("A","S")), "A", "S");
    	this.graphAStar.addEdge("AG", Double.valueOf(calculateDistance("A","G")), "A", "G");
    	
    	this.graphAStar.addEdge("GS", Double.valueOf(calculateDistance("G","S")), "G", "S");
    	this.graphAStar.addEdge("GC", Double.valueOf(calculateDistance("G","C")), "G", "C");
    	this.graphAStar.addEdge("GI", Double.valueOf(calculateDistance("G","I")), "G", "I");
    	
    	this.graphAStar.addEdge("IC", Double.valueOf(calculateDistance("I","C")), "I", "C");
    	this.graphAStar.addEdge("IQ", Double.valueOf(calculateDistance("I","Q")), "I", "Q");
    	
    	this.graphAStar.addEdge("JQ", Double.valueOf(calculateDistance("J","Q")), "J", "Q");
    	this.graphAStar.addEdge("JF", Double.valueOf(calculateDistance("J","F")), "J", "F");
    	this.graphAStar.addEdge("JB", Double.valueOf(calculateDistance("J","B")), "J", "B");
    	this.graphAStar.addEdge("JT", Double.valueOf(calculateDistance("J","T")), "J", "T");
    	
    	this.graphAStar.addEdge("BF", Double.valueOf(calculateDistance("B","F")), "B", "F");
    	this.graphAStar.addEdge("BS", Double.valueOf(calculateDistance("B","S")), "B", "S");
    	this.graphAStar.addEdge("BE", Double.valueOf(calculateDistance("B","E")), "B", "E");
    	this.graphAStar.addEdge("BR", Double.valueOf(calculateDistance("B","R")), "B", "R");
    	this.graphAStar.addEdge("BT", Double.valueOf(calculateDistance("B","T")), "B", "T");
    	
    	this.graphAStar.addEdge("FC", Double.valueOf(calculateDistance("F","C")), "F", "C");
    	this.graphAStar.addEdge("FS", Double.valueOf(calculateDistance("F","S")), "F", "S");
    	
    	this.graphAStar.addEdge("NT", Double.valueOf(calculateDistance("N","T")), "N", "T");
    	this.graphAStar.addEdge("NR", Double.valueOf(calculateDistance("N","R")), "N", "R");
    	this.graphAStar.addEdge("NH", Double.valueOf(calculateDistance("N","H")), "N", "H");
    	
    	this.graphAStar.addEdge("OH", Double.valueOf(calculateDistance("O","H")), "O", "H");
    	this.graphAStar.addEdge("OR", Double.valueOf(calculateDistance("O","R")), "O", "R");
    	
    	AStar astar = new AStar(this.graphAStar);
    	astar.algorithm(startId, stopId);
    }
    
}
    

