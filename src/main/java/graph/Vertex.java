package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex <V,E> implements Cloneable{
	
	private String id;
	private V value;
	private List<Edge<V,E>> edges;
	
	public Vertex(String id){
		this.id = id;
		this.edges = new ArrayList<>();
	}
	
	public String getId(){
		return id;
	}
	
	public List<Edge<V,E>> getEdges(){
		return edges;
	}
	
	public void setEdges(List<Edge<V,E>> edges){
		this.edges = edges;
	}
	
	public V getValue(){
		return value;
	}
	
	public void setValue(V value){
		this.value = value;
	}
	
//	@Override
//	public Vertex clone(){
//		Vertex vertexClone = new Vertex(this.id);
//		vertexClone.setEdges(this.edges);
//		return vertexClone;
//	}

}
