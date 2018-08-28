package console;

import static guru.nidi.graphviz.model.Factory.mutGraph;
import static guru.nidi.graphviz.model.Factory.mutNode;

import java.io.File;
import java.io.IOException;
import java.util.List;

import graph.Vertex;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;

public class Draw<V,E> {
	
	private MutableGraph g = null;
	
	public Draw() {
		
	}
	
	public void drawGraph(List<Vertex<V,E>> vertices, String title) throws IOException {
		g = mutGraph(title).setDirected(true);
		
		vertices.forEach( vertex -> {
			if(vertex.getEdges().size() > 0) {
				vertex.getEdges().forEach( edge -> {
					g.add(mutNode(vertex.getId())).addLink(mutNode(edge.getId()));
				});	
			} else {
				g.add(mutNode(vertex.getId()));
			}
		});
		
		Graphviz.fromGraph(g).width(600).render(Format.PNG).toFile(new File("C:\\Users\\conta\\Desktop\\ex.png"));
	}

}
