package graph;

import java.util.Scanner;

public class GraphManager {
	
	private Graph<String,String> graph;
	private Scanner scanner;
	
	public GraphManager(){
		this.graph = new Graph<String,String>();
		this.scanner  = new Scanner(System.in);
	}
	
	public void run(){
		String inputOption = null;
		do{
			showOptions();
			System.out.println("Enter a option: ");
			inputOption = scanner.nextLine();
			execute(inputOption);
		}while(!inputOption.equals("0"));
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
		System.out.println("Vertex id: ");
		String id = scanner.nextLine();
		System.out.println(id);
		graph.addVertex(id);
	}
	
	private void removeVertex(){
		System.out.println("Vertex id: ");
		String id = scanner.nextLine();
		graph.removeVertex(id);
	}
	
	private void addEdge(){
		System.out.println("Edge vertex id1: ");
		String id1 = scanner.nextLine();
		System.out.println("Edge vertex id2: ");
		String id2 = scanner.nextLine();
		System.out.println("Edge id: ");
		String id = scanner.nextLine();
		graph.addEdge(id, id1, id2);
	}
	
	private void removeEdge(){
		System.out.println("Edge id1: ");
		String id1 = scanner.nextLine();
		System.out.println("Edge id2: ");
		String id2 = scanner.nextLine();
		graph.removeEdge(id1, id2);
	}
	
	private void adjacent(){
		System.out.println("Vertex id1: ");
		String id1 = scanner.nextLine();
		System.out.println("Vertex id2: ");
		String id2 = scanner.nextLine();
		System.err.println(graph.adjacent(id1, id2));
	}
	
	private void showGraph(){
		graph.showGraph();
	}

}
