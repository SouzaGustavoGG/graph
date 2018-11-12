package graph.search;

import java.util.ArrayList;
import java.util.List;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class AStar <V  extends Number, E  extends Number> {
	
	private Graph<V,E> graph = null;
	private List<Vertex<V,E>> opened = null;

	private List<Vertex<V,E>> closed = null;
	private List<Predecessor<V,E>> predecessors = null;
	private List<Predecessor<V,E>> predecessorsEdge = null;
	
	public AStar(Graph<V,E> g){
		this.graph = g;
		this.opened = new ArrayList<>();
		this.closed = new ArrayList<>();
		this.predecessors = new ArrayList<>();
		this.predecessorsEdge = new ArrayList<>();
	}
	
	@SuppressWarnings("unchecked")
	public void algorithm(String startId, String stopId){
		boolean error = false;
		Vertex<V,E> bestVertex = graph.getVertexById(startId);
		opened.add(bestVertex);
		predecessors.add(new Predecessor(new Double(0.0), bestVertex));
		predecessorsEdge.add(new Predecessor(new Double(0.0), bestVertex));
		
		while( !bestVertex.getId().equals(stopId)){
			expand(bestVertex);
			if(opened.size()== 0){
				error = true;
				break;
			}
			bestVertex = getBestF();
		}
		if(error){
			System.out.println("Fracasso!");
		}else if(bestVertex != null){
			System.out.println("Distance: " + (getPredecessor(bestVertex.getId(), predecessors).getDistance().doubleValue() - bestVertex.getValue().doubleValue()));
			List<Predecessor<V,E>> predecessorsResult = new ArrayList<>();
			getBest(startId, stopId, predecessorsResult);
			showResult(predecessorsResult);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void expand(Vertex<V,E> bestVertex){
		opened.remove(bestVertex);
		
		List<Edge<V,E>> edges = bestVertex.getEdges();
		Predecessor<V,E> bestPredecessor = getPredecessor(bestVertex.getId(), predecessorsEdge);
		for(Edge<V,E> e : edges){
			opened.add(e.getVertex());
			
			double f = e.getVertex().getValue().doubleValue() + 
					   e.getValue().doubleValue() +
					   bestPredecessor.getDistance().doubleValue();
			double fe = e.getValue().doubleValue() + bestPredecessor.getDistance().doubleValue();
			Predecessor<V,E> adjacentP = getPredecessor(e.getVertex().getId(), predecessors);
			if( adjacentP == null){
				predecessors.add(new Predecessor<V,E>((E) new Double(f), e.getVertex(), bestVertex));
			} else {
				if(adjacentP.getDistance().doubleValue() > f){
					adjacentP.setDistance((E) new Double(f));
					adjacentP.setLastVertex(bestVertex);
				}
			}
			Predecessor<V,E> adjacentE = getPredecessor(e.getVertex().getId(), predecessorsEdge);
			if( adjacentE == null){
				predecessorsEdge.add(new Predecessor<V,E>((E) new Double(fe), e.getVertex(), bestVertex));
			} else {
				if(adjacentE.getDistance().doubleValue() > fe){
					adjacentE.setDistance((E) new Double(fe));
					adjacentE.setLastVertex(bestVertex);
				}
			}
		}
	}
	
	private Vertex<V,E> getBestF(){
		double bestF = 999999999999.0;
		Vertex<V,E> bestVertex = null;
		double f = 999.9;
		for(Vertex<V,E> v : opened){
			List<Edge<V,E>> edges = v.getEdges();
				f = getPredecessor(v.getId(), predecessors).getDistance().doubleValue();
				if( f < bestF && !closed.contains(v)){
					bestF = f;
					bestVertex = v;
				}
		}
		if(bestVertex != null)
			closed.add(bestVertex);
		return bestVertex;
	}
	
	private void getBest(String startId, String stopId, List<Predecessor<V,E>> predecessorsResult){
		if(stopId.equals(startId)){
			Predecessor<V,E> predecessor = getPredecessor(stopId, predecessors);
			predecessorsResult.add(0, new Predecessor<V, E>(predecessor.getDistance(), predecessor.getVertex()));
			return;
		}
		Predecessor<V,E> predecessor = getPredecessor(stopId, predecessors);
		predecessorsResult.add(0, new Predecessor<V, E>(predecessor.getDistance(), predecessor.getVertex()));
		stopId = predecessor.getLastVertex().getId();
		getBest(startId, stopId, predecessorsResult);

	}
	
	private void showResult(List<Predecessor<V,E>> predecessorsResult){
		int count = 1;
		for(Predecessor<V,E> p : predecessorsResult){
			if(count != predecessorsResult.size())
				System.out.print(p.getVertex().getId() + " -> ");
			else
				System.out.print(p.getVertex().getId());
			count++;
		}
	}
	
	private Predecessor<V,E> getPredecessor(String id, List<Predecessor<V,E>> preds){
		for(Predecessor<V,E> p : preds){
			if(p.getVertex().getId().equals(id)){
				return p;
			}
		}
		return null;
	}
	
	public Graph<V, E> getGraph() {
		return graph;
	}

	public void setGraph(Graph<V, E> graph) {
		this.graph = graph;
	}

	public List<Vertex<V,E>> getOpened() {
		return opened;
	}

	public void setOpened(List<Vertex<V,E>> opened) {
		this.opened = opened;
	}

	public List<Vertex<V,E>> getClosed() {
		return closed;
	}

	public void setClosed(List<Vertex<V,E>> closed) {
		this.closed = closed;
	}

	public List<Predecessor<V,E>> getPredecessors() {
		return predecessors;
	}

	public void setPredecessors(List<Predecessor<V,E>> predecessors) {
		this.predecessors = predecessors;
	}
	
	public static void main(String[] args){
		Graph<Integer,Integer> g = new Graph<>(false);
		g.addVertex("a", 0);
		g.addVertex("b", 5);
		g.addVertex("c", 6);
		g.addVertex("d", 7);
		g.addVertex("e", 4);
		g.addVertex("f", 3);
		g.addVertex("g", 1);
		
		g.addEdge("ab", 1, "a", "b");
		g.addEdge("ac", 1, "a", "c");		
		g.addEdge("ad", 1, "a", "d");
//		
		g.addEdge("be", 1, "b", "e");		
		g.addEdge("bf", 1, "b", "f");
//		
		g.addEdge("fg", 1, "f", "g");
//		
		g.addEdge("fe", 1, "f", "e");
//		g.addEdge("ef", 1, "e", "f");
//		
		g.addEdge("eg", 1, "e", "g");
		
    	AStar aStar = new AStar(g);
    	aStar.algorithm("a", "g");
	}

}
