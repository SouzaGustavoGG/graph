
package graph.search;

public class Coloring {
    
    private final int V, numOfColors;
    private final int[] color; 
    private final int[][] graph;
    
    public Coloring(int numVertices, int numColors, int [][] matrix) {
        this.V = numVertices;
        this.numOfColors = numColors;
        this.color = new int[this.V];
        this.graph = matrix;
    }
 
    /** Function to assign color **/
    public void graphColor() {
        try {
            solve(0);
            System.out.println("No solution");
        }
        catch (Exception e) {
            System.out.println("\nSolution exists ");
            display();
        }
    }

    public void solve(int v) throws Exception {
        if (v == V)
            throw new Exception("Solution found");
        
        for (int c = 1; c <= numOfColors; c++) {
            if (isPossible(v, c)) {
                color[v] = c;
                solve(v + 1);
                color[v] = 0;
            }
        }    
    }
    
    public boolean isPossible(int v, int c) { 
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && c == color[i])
                return false;
        }

        return true;
    }
    
    public void display() {
        System.out.print("\nColors : ");
        for (int i = 0; i < V; i++)
            System.out.print(color[i] +" ");
        
        System.out.println();
    }
    
}
