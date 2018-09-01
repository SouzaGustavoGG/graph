package graph.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class BreadthFirstSearch <V, E extends Number>{
	
	private final Graph<V,E> graph;
	
	private final Vertex<V,E> initialVertex;
	private final List<Vertex<V,E>> finalVertices;
	
	private List<Vertex<V,E>> openedVertices;
	private List<Vertex<V,E>> closedVertices;
	
	private List<Predecessor<V,E>> predecessors;
	
	public BreadthFirstSearch(Graph<V,E> graph, Vertex<V,E> initialVertex, List<Vertex<V,E>> finalVertices) {
		this.graph = graph;
		
		this.initialVertex  = initialVertex;
		this.finalVertices = finalVertices;
		this.openedVertices = new LinkedList<>();
		this.closedVertices = new ArrayList<>();
		this.predecessors = new ArrayList<>();
		
		this.openedVertices.add(initialVertex);
	}
	
	public void search() {
		Vertex<V,E> v = null;
		while(openedVertices.size() > 0) {
			v = openedVertices.get(0).clone();
			List<Edge<V,E>> adjacents = v.getEdges();
			closedVertices.add(v);
			openedVertices.remove(0);
			
			for(Edge<V,E> adjacent : adjacents) {
				openedVertices.add(adjacent.getVertex());
				calculateMinDistance(v, adjacent);
			}
		}
		getBestFinal();
	}
	
	@SuppressWarnings("unchecked")
	private void calculateMinDistance(Vertex<V,E> currentVertex, Edge<V,E> adjacent) {
		E distance = adjacent.getValue();
		
		Predecessor <V,E> predecessor = getPredecessor((V) adjacent.getVertex().getId());
		Predecessor <V,E> lastPredecessor = getPredecessor((V) currentVertex.getId());
		
		if(lastPredecessor != null) {
			distance = (E) new Double(lastPredecessor.getDistance().doubleValue() + distance.doubleValue());
		}
		
		if( predecessor == null) {
			predecessors.add(new Predecessor<V,E>(distance, adjacent.getVertex(), currentVertex));
		} else if (predecessor.getDistance().doubleValue() > distance.doubleValue()) {
			predecessor.setDistance(distance);
			predecessor.setLastVertex(currentVertex);
		}

	}
	
	@SuppressWarnings("unchecked")
	private void getBestFinal() {
		Predecessor<V,E> bestFinal = null;
		
		for(Vertex<V,E> finalVertex : finalVertices) {
			Predecessor<V,E> currentP = getPredecessor((V)finalVertex.getId());
			if( bestFinal == null || 
					currentP.getDistance().doubleValue() < bestFinal.getDistance().doubleValue()) {
				bestFinal = currentP;
			}
		}
		List<Predecessor<V,E>> linkedPredecessors = new LinkedList<>();
		getBestWay((V)bestFinal.getVertex().getId(), linkedPredecessors);
		
		System.err.println("Best Final: Vertex -> " + bestFinal.getVertex().getId() +
				" - Distance ->" + bestFinal.getDistance().doubleValue() + "\n");
		System.err.print("Best Way: " );
		for(Predecessor<V,E> predecessor : linkedPredecessors) {
			System.err.print( "g(" +predecessor.getVertex().getId() + ") ");
		}
		System.err.println("\n");
	}
	
	@SuppressWarnings("unchecked")
	private void getBestWay(V id, List<Predecessor<V,E>> linkedPredecessors) {
		Predecessor<V,E> current = getPredecessor(id);
		if( current == null) {
			return;
		}
		linkedPredecessors.add(0, current);
		getBestWay((V)current.getLastVertex().getId(), linkedPredecessors);
	}
	
	public Graph<V,E> getGraph(){
		return graph;
	}
	
	public Vertex<V,E> getInitialVertex() {
		return initialVertex;
	}
	
	public List<Vertex<V,E>> getFinalVertices(){
		return finalVertices;
	}
	
	public List<Vertex<V,E>> getOpenedVertices(){
		return openedVertices;
	}
	
	public List<Vertex<V,E>> getClosedVertices(){
		return closedVertices;
	}
	
	public List<Predecessor<V,E>> getPredecessors(){
		return predecessors;
	}
	
	public Predecessor<V,E> getPredecessor(V id){
		for( Predecessor<V,E> p : predecessors) {
			if(p.getVertex().getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	public Predecessor<V,E> getPredecessor(V id, V lastid){
		for( Predecessor<V,E> p : predecessors) {
			if(p.getVertex().getId().equals(id) && p.getLastVertex().getId().equals(lastid)) {
				return p;
			}
		}
		return null;
	}
	
	private class Predecessor<T,N> {
		
		private Vertex<T,N> vertex;
		private Vertex<T,N> lastVertex;
		private N distance;
		
		public Predecessor(N distance,Vertex<T,N> vertex, Vertex<T,N> lastVertex){
			this.distance = distance;
			this.vertex = vertex;
			this.lastVertex = lastVertex;
		}
		
		public N getDistance() {
			return distance;
		}
		
		public void setDistance(N distance) {
			this.distance = distance;
		}
		
		public Vertex<T,N> getLastVertex(){
			return lastVertex;
		}
		
		public void setLastVertex(Vertex<T,N> lastVertex) {
			this.lastVertex = lastVertex;
		}
		
		public Vertex<T,N> getVertex(){
			return vertex;
		}

	}

}
