package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import console.ConsoleScanner;
import console.Draw;
import ui.DisplayImage;
import ui.mainMenuView;

public class GraphManager {
	
	private Graph<String,Integer> graph;
	private Draw<String,Integer> draw;
	private static ConsoleScanner console;
	
	public GraphManager(){
		this.draw = new Draw<String, Integer>();
		console = new ConsoleScanner();
	}
	
	public void run(boolean orientado){
		String inputOption = null;
		createGraph(orientado);
                new mainMenuView(this.graph);
                
//		do{
//                    showOptions();
//                    inputOption = console.readString("Enter a option: ");
//                    execute(inputOption);
//		} while(!inputOption.equals("0"));
	}
	
	private void createGraph(boolean orientado) {
		this.graph = new Graph<String,Integer>(orientado);
	}
	
	private void showOptions(){            
            System.out.println(new StringBuilder()
                    .append("==== Menu ====\n")
                    .append("Add Vertx [1]\n")
                    .append("Remove Vertex[2] \n")
                    .append("Add Edge [3]\n")
                    .append("Remove Edge [4]\n")
                    .append("Show Graph [5]\n")
                    .append("Adjacent [6]\n")
                    .append("Search BFS [7]\n")
                    .append("==============")
                    .toString());
	}
	
	private void execute(String option){
            if(option == null) return;
            try{
                    switch(option.toUpperCase()){
                            case "1": addVertex(); break;
                            case "2": removeVertex(); break;
                            case "3": addEdge(); break;
                            case "4": removeEdge(); break;
                            case "5": showGraph(); break;
                            case "6": adjacent(); break;
                            case "7": bfs(); break;
                            case "0": break;
                    }
            } catch (IllegalArgumentException e){
                    System.out.println("**" + e.getMessage() + "**");
            }
	}
	
	private void addVertex(){
		String id = console.readString("Vertex id: ");
		String value = console.readString("Vertex value: ");
		graph.addVertex(id, value);
	}
	
	private void removeVertex(){
		printVertices();
		String id = console.readString("Vertex id: ");
		graph.removeVertex(id);
	}
	
	private void addEdge() {
		String vertexId1 = this.getAndVerifyIfExists("Source Edge ID: ", "Source ID doesn't exist! Please enter again \n");
		String vertexId2 = this.getAndVerifyIfExists("Destination Edge ID: ", "Destination ID doesn't exist! Please enter again \n");

		String edgeId = console.readString("New Edge ID: ");
		Integer edgeValue = console.readInt("New Edge Value: ");
		graph.addEdge(edgeId, edgeValue, vertexId1, vertexId2);
	}
	
	private void removeEdge(){
		String id1 = console.readString("Edge id1: ");
		String id2 = console.readString("Edge id2: ");
		
		graph.removeEdge(id1, id2);
	}
	
	private void adjacent(){
		String id1 = console.readString("Vertex id1: ");
		String id2 = console.readString("Vertex id2: ");
		System.err.println(graph.adjacent(id1, id2));
	}
	
	private void bfs() {
		List<String> finalIds = new ArrayList<>();
		String finalId = null;
		String startid = console.readString("Start Vertex: ");
		Boolean add = false;
		do {
			finalId = console.readString("Final Vertex: ");
			finalIds.add(finalId);
			add = console.readBoolean("* Add new Final [Y][N]:");
		}while(add && add != null);
		graph.bfs(startid , finalIds);
	}
	
	private void showGraph() {
            String graphName = "graph.png";
            graph.showGraph();
            try {
                    draw.drawGraph(graph, graphName);
            } catch (IOException e) {
                    e.printStackTrace();
            }
            
            new DisplayImage(graphName);                
	}
	
	public void printVertices() {
		System.out.println("Available Vertexes IDs:");
		graph.getVertices().forEach(e -> {
			System.out.println(" * " + e.getId());
		});
	}
	
	public String getAndVerifyIfExists(String msgInput, String msgOutput) {
		String id;
		while(true) {
			printVertices();
			id = console.readString(msgInput);
			if(graph.contains(id)) {
				break;
			}
			System.out.println(msgOutput);
		}
		
		return id;
	}

}
