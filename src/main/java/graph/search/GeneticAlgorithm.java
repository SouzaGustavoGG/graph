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
        GENERATIONS_MAX
    }

    private static int currentGeneration;
    private int numberOfGenerations;

    private final int populationSize;
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

    public void execute(){}

    public String run() {
        createInitialPopulation();
        currentGeneration = 0;
        double bestValue = Double.MAX_VALUE;
        String bestPath = "";

        do {
            naturalSelection();
            crossover();              
            mutation(2);
            ArrayList<String> currentBest = result();
            double curentBestValue = Double.parseDouble(currentBest.get(1));

            if(curentBestValue < bestValue) {
                bestValue = curentBestValue;
                bestPath = currentBest.get(0);
            }

        } while(checkStop(++currentGeneration));

        return bestPath + " " + Double.toString(bestValue);
    }

    private boolean checkStop(int currentGeneration){
        switch(stopMode){
            case GENERATIONS_MAX: return currentGeneration <= numberOfGenerations;
        }
        return true;
    }

    private ArrayList<String> result() {		
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
        System.out.println("Gen (" + currentGeneration + "): " + Arrays.toString(bestWay) + " " + bestWayValue);
        ArrayList<String> bestResult = new ArrayList();

        bestResult.add(Arrays.toString(bestWay));
        bestResult.add(String.valueOf(bestWayValue));

        return bestResult; 
    }

    private double calculateDistance(String[] chromosome){
        double currentWayValue = 0.0;
        String gene1, gene2;
        for(int j = 0; j <= chromosome.length-2; j++){
            gene1 = chromosome[j];
            gene2 = chromosome[j+1];

            currentWayValue += (graph.adjacent(gene1, gene2)) ?
                graph.getVertexById(gene1).getEdgeByVertexId(gene2).doubleValue() :
                999.0;
        }

        gene1 = chromosome[0];
        gene2 = chromosome[chromosome.length -1];
        currentWayValue += (graph.adjacent(gene1, gene2)) ?
            graph.getVertexById(gene1).getEdgeByVertexId(gene2).doubleValue() :
            999.0;

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

            this.population.add(verticesSortedArr);
        }
    }

    private void naturalSelection() {
        List<String[]> newPopulation = new ArrayList<>();
        final double K = 0.75;

        for(int i = 0; i < populationSize; i++){

            String[] chromosome1 = population.get(ThreadLocalRandom.current().nextInt(0, population.size()));
            String[] chromosome2 = population.get(ThreadLocalRandom.current().nextInt(0, population.size()));

            double result1 = calculateDistance(chromosome1);
            double result2 = calculateDistance(chromosome2);

            int r = ThreadLocalRandom.current().nextInt(0, 1);

            String[] bestChromosome, worstChromosome;

            if(result1 < result2) {
                bestChromosome = chromosome1;
                worstChromosome = chromosome2;
            } else {
                bestChromosome = chromosome2;
                worstChromosome = chromosome1;
            }

            newPopulation.add((r < K) ? bestChromosome : worstChromosome);
        }

        this.population = newPopulation;
    }

    private boolean isNewChromosome(String[] chromosome){
        for(int i = 0; i < population.size(); i++){
            if( Arrays.equals(population.get(i), chromosome)){
                return false;
            }
        }

        return true;
    }

    private void crossover(){
        int start = 2;
        int stop = 5;
        int crossingSize = (int) ((int) population.size() * crossingRate); // num individuos que sofreram cruzamento
        int diff = (population.size() - crossingSize);

        int minRange = ThreadLocalRandom.current().nextInt(0, diff > 0 ? diff : 1); //range de cruzamento
        int maxRange = minRange + crossingSize;

        List<String[]> newPopulation = new ArrayList<>();

        for(int i = 0; i <= (population.size() -2); i+=2){
            
            String[] father1 = population.get(ThreadLocalRandom.current().nextInt(0, population.size()));
            String[] father2 = population.get(ThreadLocalRandom.current().nextInt(0, population.size()));
            
            if( i >= minRange  && i <= (maxRange)){ //sofre cruzamento
                newPopulation.add(createChild(father1, father2, start, stop));
                newPopulation.add(createChild(father2, father1, start, stop));
            } else { //nao sofre cruzamento
                newPopulation.add(father1);
                newPopulation.add(father2);
            }
        }

        this.population = newPopulation;
    }

    private String[] createChild(String[] fatherX, String[] fatherY, int start, int stop){
        String[] child = new String[fatherX.length];
        List<String> visitedGenes = new ArrayList<>();
        String gene;

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
        String gene;
        for (String father1 : father) {
            gene = father1;
            if(!visitedGenes.contains(gene)){
                return gene;
            }
        }
        return null;
    }

    private void mutation(int countGenesMutation){
        List<Integer> visitedMutation = new ArrayList<>();
        Integer mutationIndex = null;

        List<Integer> indexMutation = new ArrayList<>();
        for(int i = 0; i < countGenesMutation; i++){
            do {
                mutationIndex = ThreadLocalRandom.current().nextInt(0, 6);
            } while(visitedMutation.contains(mutationIndex));
            
            indexMutation.add(mutationIndex);
        }

        int mutationSize = (int) ((int) population.size() * mutationRate); // num individuos que sofreram mutacao
        int diff = (population.size() - mutationSize);
        int minRange = ThreadLocalRandom.current().nextInt(diff > 0 ? diff : 1); // range de mutacao
        int maxRange = minRange + mutationSize;

        List<String[]> newPopulation = new ArrayList<>();

        for(int i = 0; i < this.population.size(); i++){
            if(i >= minRange && i <= maxRange){ // sofre mutacao

                String[] child = this.population.get(i);
                String[] newChild = child.clone();
                for(int j = 0; j <= (indexMutation.size() -2); j+=2){

                    String auxGene1 = child[indexMutation.get(j)];
                    String auxGene2 = child[indexMutation.get(j+1)];

                    newChild[indexMutation.get(j)] = auxGene2;
                    newChild[indexMutation.get(j+1)] = auxGene1;

                    newPopulation.add(newChild);
                }

            } else { //nao sofre cruzamento
                newPopulation.add(this.population.get(i));
            }
        }

        this.population = newPopulation;
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
}
