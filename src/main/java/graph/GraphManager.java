package graph;

import java.io.IOException;

import console.ConsoleScanner;
import console.Draw;

public class GraphManager {
	
	private Graph<String,Integer> graph;
	private Draw<String,Integer> draw;
	private static ConsoleScanner console;
	
	public GraphManager(){
		this.draw = new Draw<String, Integer>();
		console = new ConsoleScanner();
	}
	
	public void run(){
		String inputOption = null;
		createGraph();
		do{
			showOptions();
			inputOption = console.readString("Enter a option: ");
			execute(inputOption);
		}while(!inputOption.equals("0"));
	}
	
	private void createGraph() {
		Boolean oriented = null;
		do {
			oriented = console.readBoolean("* Oriented Graph [Y] \n* Non-oriented Graph [N]:");
		}while(oriented == null);
		this.graph = new Graph<String,Integer>(oriented);
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
	
	private void addEdge(){
		printVertices();
		String vertexId1;
		String vertexId2;
		while(true) {
			vertexId1 = console.readString("Source Edge ID: ");
			if(graph.contains(vertexId1)) {
				break;
			}
			System.out.println("Invalid Source ID, please enter again \n");
		}
		
		while(true) {
			vertexId2 = console.readString("Destination Edge ID: ");
			if(graph.contains(vertexId2)) {
				break;
			}
			System.out.println("Invalid Destination ID, please enter again \n");
		}

		String edgeId = console.readString("Edge ID: ");
		Integer edgeValue = console.readInt("Edge Value: ");
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
	
	private void showGraph(){
		graph.showGraph();
		try {
			draw.drawGraph(graph, "exemplo");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printVertices() {
		System.out.println("Available Vertexes IDs:");
		int verticesSize = graph.getVertices().size();
		for(int x = 0; x < verticesSize; x++ ) {
			System.out.println(" * " + graph.getVertices().get(x).getId());
		}
	}

}
