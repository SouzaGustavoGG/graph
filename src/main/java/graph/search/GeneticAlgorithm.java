package graph.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import graph.Graph;
import graph.Vertex;

public class GeneticAlgorithm <V  extends Number, E  extends Number> implements Algorithm{

	public enum StopMode {
		GENERATIONS_MAX, BEST_VALUE, CONVERGENCE
	}
	
	private static int currentGeneration;
	private int numberOfGenerations;
	//private E expectedValue;
	
	private int populationSize;
	private StopMode stopMode;
	private double crossingRate;
	private double mutationRate;
	
	private Graph<V,E> graph;
	private List<String[]> population;
	
	public GeneticAlgorithm(Graph<V,E> graph, int populationSize, int numberOfGenerations, double crossingRate, double mutationRate, StopMode stopMode){
		this.populationSize = populationSize;
		this.numberOfGenerations = numberOfGenerations;
		this.crossingRate = crossingRate;
		this.mutationRate = mutationRate;
		this.stopMode = stopMode;
		
		this.setGraph(graph);
		population = new ArrayList<>();
	}
	
	public void execute(){
		createInitialPopulation();
		naturalSelection();
		currentGeneration = 0;
		double bestValue = 0.0;
		do{
			crossover(2,5);
			mutation(2);
			bestValue = result();
		}while(checkStop(currentGeneration++));
		System.err.println("Melhor caminho valor: "+ bestValue);
	}
	
	private boolean checkStop(int currentGeneration){
		switch(stopMode){
			case GENERATIONS_MAX: return currentGeneration > numberOfGenerations ? false : true;
			//case BEST_VALUE: return bestValue.doubleValue() < 
			//case CONVERGENCE: break;
		}
		return true;
	}
	
	private double result(){
		String[] currentWay, bestWay = null;
		double bestWayValue = 999999999999.0;
		
		double currentWayValue = 0.0;
		for(int i = 0; i < population.size(); i++){
			currentWay = population.get(i);
			
			currentWayValue = calculateDistance(currentWay);
			if(currentWayValue < bestWayValue){
				bestWayValue = currentWayValue;
				bestWay = currentWay;
			}
		}
		System.out.println("Gera��o numero (" + currentGeneration + "): " + Arrays.toString(bestWay) + " "+bestWayValue);
		return bestWayValue; 
	}
	
	private double calculateDistance(String[] chromosome){
		double currentWayValue = 0.0;
		String gene1 = "", gene2 = "";
		for(int j = 0; j <= chromosome.length-2; j+=2){
			gene1 = chromosome[j];
			gene2 = chromosome[j+1];
			
			if(graph.adjacent(gene1, gene2)){
				currentWayValue += graph.getVertexById(gene1).getEdgeByVertexId(gene2).doubleValue();
			} else {
				currentWayValue += 999.0;
			}
		}
		return currentWayValue;
	}
	
	private void createInitialPopulation(){
		String[] vertices = new String[graph.getVertices().size()];
		int index = 0;
		for(Vertex<V,E> v : graph.getVertices()){
			vertices[index] = v.getId();
			index++;
		}
		
		List<String> verticesSorted = Arrays.asList(vertices.clone());
		String[] verticesSortedArr = null;
		for(int i = 0; i < populationSize; i++){
			do {
				Collections.shuffle(verticesSorted);
				verticesSortedArr = new String[verticesSorted.size()];
				verticesSorted.toArray(verticesSortedArr);
			} while(!isNewChromosome(verticesSortedArr));
			population.add(verticesSortedArr);
		}
		System.out.println("Tamanho popula��o inicial: " + population.size());
	}
	
	private void naturalSelection(){
		List<String[]> newPopulation = new ArrayList<>();
		final double K = 0.75;
		
		for(int i = 0; i < populationSize*2; i++){
			
			String[] chromosome1 = population.get( ThreadLocalRandom.current().nextInt(0, population.size()));
			String[] chromosome2 = population.get( ThreadLocalRandom.current().nextInt(0, population.size()));
			double result1 = calculateDistance(chromosome1);
			double result2 = calculateDistance(chromosome2);
			
			int r = ThreadLocalRandom.current().nextInt(0, 1);
			
			if(r < K){
				newPopulation.add(result1 > result2 ? chromosome1: chromosome2);
			} else {
				newPopulation.add(result1 > result2 ? chromosome2: chromosome1);
			}
			
		}
	}

	private boolean isNewChromosome(String[] chromosome){
		for(int i = 0; i < population.size(); i++){
			if( population.get(i).equals(chromosome)){
				return false;
			}
		}
		return true;
	}
	
	private void crossover(int start, int stop){
		int crossingSize = (int) ((int) population.size() * crossingRate); // qtd de individuos que sofreram cruzamento
		int minRange = ThreadLocalRandom.current().nextInt(0, population.size() - crossingSize); //range de cruzamento
		int maxRange = minRange+crossingSize;
		
		List<String[]> newPopulation = new ArrayList<>();
		
		String[] father1 = null;
		String[] father2 = null;
		
		String[] child1 = null;
		String[] child2 = null;
		
		for(int i = 0; i <= (population.size() -2); i+=2){
			if( i >= minRange  && i <= (maxRange)){ //sofre cruzamento
				
				father1 = population.get(i);
				father2 = population.get(i+1);
				
				child1= createChild(father1, father2, start, stop);
				child2= createChild(father2, father1, start, stop);
				
				newPopulation.add(child1);
				newPopulation.add(child2);
				
			} else { //n�o sofre cruzamento
				newPopulation.add(population.get(i));
				newPopulation.add(population.get(i+1));
			}
		}
		population = newPopulation;
	}
	
	private String[] createChild(String[] fatherX, String[] fatherY, int start, int stop){
		String[] child = new String[fatherX.length];
		List<String> visitedGenes = new ArrayList<>();
		String gene = "";
		for(int j = 0 ; j < fatherX.length; j++){
			
			gene = ((j <= start || j >= stop) ? fatherY[j] : fatherX[j]);
			
			if(visitedGenes.contains(gene)){
				gene = getFirstGeneNotVisitedFather(fatherX, visitedGenes);
			}
			child[j] = gene;
			visitedGenes.add(gene);
		}
		return child;
	}
	
	private String getFirstGeneNotVisitedFather(String[] father, List<String> visitedGenes){
		String gene = "";
		for(int i = 0 ; i < father.length; i++){
			gene = father[i];
			if(!visitedGenes.contains(gene)){
				return gene;
			}
		}
		return null;
	}
	
	private void mutation(int countGenesMutation){
		List<Integer> visitedMutation = new ArrayList<>();
		if(countGenesMutation % 2 != 0){
			throw new IllegalArgumentException("Muta��o deve ocorrer em pares, ou seja parametro countGenesMutation deve ser par");
		}
		Integer mutationIndex = null;
		
		List<Integer> indexMutation = new ArrayList<>();
		for(int i = 0; i < countGenesMutation; i++){
			do {
				mutationIndex = ThreadLocalRandom.current().nextInt(0, 6);
			} while(visitedMutation.contains(mutationIndex));
			indexMutation.add(mutationIndex);
		}
		
		int mutationSize = (int) ((int) population.size() * mutationRate); // qtd de individuos que sofreram mutacao
		int minRange = ThreadLocalRandom.current().nextInt(0, population.size() - mutationSize); //range de mutacao
		int maxRange = minRange + mutationSize;
		
		List<String[]> newPopulation = new ArrayList<>();
		
		String[] child = null, newChild = null;
		String auxGene1 = "", auxGene2 = "";
		
		for(int i = 0; i < (population.size()); i++){
			if( i >= minRange  && i <= (maxRange)){ //sofre cruzamento
				
				child = population.get(i);
				newChild = child.clone();
				for(int j = 0; j <= (indexMutation.size()-2); j+=2){
					auxGene1 = child[indexMutation.get(j)];
					auxGene2 = child[indexMutation.get(j+1)];
					
					newChild[indexMutation.get(j)] = auxGene2;
					newChild[indexMutation.get(j+1)] = auxGene1;
					
					newPopulation.add(newChild);
					
				}
				
			} else { //n�o sofre cruzamento
				newPopulation.add(population.get(i));
			}
		}
		population = newPopulation;
	}

	public StopMode getStopMode() {

		return stopMode;
	}

	public void setStopMode(StopMode stopMode) {
		this.stopMode = stopMode;
	}

	public int getNumberOfGenerations() {
		return numberOfGenerations;
	}

	public void setNumberOfGenerations(int numberOfGenerations) {
		this.numberOfGenerations = numberOfGenerations;
	}

	public double getCrossingRate() {
		return crossingRate;
	}

	public void setCrossingRate(double crossingRate) {
		this.crossingRate = crossingRate;
	}

	public double getMutationRate() {
		return mutationRate;
	}

	public void setMutationRate(double mutationRate) {
		this.mutationRate = mutationRate;
	}

	public List<String[]> getPopulation() {
		return population;
	}

	public void setPopulation(List<String[]> population) {
		this.population = population;
	}

	public Graph<V,E> getGraph() {
		return graph;
	}

	public void setGraph(Graph<V,E> graph) {
		this.graph = graph;
	}
	
	public static void main(String[] args){
		Graph<Double,Double> graph = new Graph<>(false);
		graph.addVertex("N");
		graph.addVertex("F");
		graph.addVertex("L");
		graph.addVertex("K");
		graph.addVertex("E");
		graph.addVertex("H");
		graph.addVertex("G");
		
		graph.addEdge("NF", 47.0, "N", "F");
		graph.addEdge("NK", 60.0, "N", "K");
		graph.addEdge("FK", 70.0, "F", "K");
		graph.addEdge("FL", 10.0, "F", "L");
		graph.addEdge("FH", 30.0, "F", "H");
		graph.addEdge("FE", 10.0, "F", "E");
		graph.addEdge("LH", 40.0, "L", "H");
		graph.addEdge("LE", 5.0, "L", "E");
		graph.addEdge("KH", 73.0, "K", "H");
		graph.addEdge("KE", 10.0, "K", "E");
		graph.addEdge("KG", 90.0, "K", "G");
		graph.addEdge("HG", 80.0, "H", "G");
		graph.addEdge("HE", 60.0, "H", "E");
		graph.addEdge("EG", 40.0, "E", "G");
		
		GeneticAlgorithm<Double,Double> ga = new GeneticAlgorithm<>(graph, 
				100, 100, 0.60, 0.01, StopMode.GENERATIONS_MAX);
		ga.execute();
		
		
		
	}
}
