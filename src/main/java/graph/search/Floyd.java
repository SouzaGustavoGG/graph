package graph.search;

import java.util.ArrayList;
import java.util.List;

import graph.Graph;

public class Floyd <V,E  extends Number> {
	
	private static String[] vertices = null;
	
	private double[][] matrixD = null;
	private int[][] matrixP = null;
	
	public Floyd(Graph<V, E> g){
		int size = g.getVertices().size();
		if(!g.isOriented())
                    throw new IllegalArgumentException("Graph must be oriented");
                
		matrixD = new double[size][size];
		setMatrixP(new int[size][size]);
		vertices = new String[size];
		
		initializeVertices(g);
		initializeMatrixD(g);
		initializeMatrixP();
	}
	
	private void initializeVertices(Graph<V,E> g){
		for(int i=0; i< g.getVertices().size(); i++){
			vertices[i] = g.getVertices().get(i).getId();
		}
	}

	@SuppressWarnings("unchecked")
	private void initializeMatrixD(Graph<V,E> g){
		for(int i=0; i< matrixD.length; i++){
			for(int j=0; j < matrixD.length; j++){
				if(g.adjacent(vertices[i], vertices[j])){
					matrixD[i][j] = (double) g.getVertexById(vertices[i]).getEdgeByVertexId(vertices[j]);
				}else if( i == j){
					matrixD[i][j] = 0.0;
				} else {
					matrixD[i][j] = Double.MAX_VALUE;
				}
				System.out.println(matrixD[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private void initializeMatrixP(){
		for(int i=0; i< matrixP.length; i++){
			for(int j=0; j < matrixP.length; j++){
				if( i != j){
					matrixP[i][j] = i;
				}else{
					matrixP[i][j] = 0;
				}
			}
		}
	}
	
	public void algorithm(){
		for(int k=0; k < vertices.length; k++){			
			for(int i=0; i< matrixD.length; i++){
				for(int j=0; j < matrixD.length; j++){
					if(i != k && j != k){
						double valor = matrixD[k][j]+matrixD[i][k];
						if(matrixD[i][j] > valor){
							matrixD[i][j] = valor;
							matrixP[i][j] = k;
						}
					}
				}
			}
		}
	}
	
	public void getBest(String startId, String stopId){
		int start = -1;
		int stop = -1;
		int count = 0;
		for(String v : vertices){
			if(v.equals(startId))
				start = count;
			else if(v.equals(stopId))
				stop = count;
			count++;
		}
		System.out.println("Distance: " + matrixD[start][stop]);
		
		List<String> predecessors = new ArrayList<>();
		while(stop != start){
			predecessors.add(0, vertices[stop]);
			stop = matrixP[start][stop];
		}
		System.out.println("Best Way: " + predecessors);
	}

	public double[][] getMatrixD() {
		return matrixD;
	}

	public void setMatrixD(double[][] matrixD) {
		this.matrixD = matrixD;
	}

	public int[][] getMatrixP() {
		return matrixP;
	}

	public void setMatrixP(int[][] matrixP) {
		this.matrixP = matrixP;
	}

}
