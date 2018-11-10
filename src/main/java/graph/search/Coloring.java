
package graph.search;

import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;

public class Coloring {
    
    private final int numOfColors = MAX_VALUE;
    private final int V;
    private final int[] color; 
    private final int[][] graph;
    private int colorsUsed;
    
    public Coloring(int numVertices, int [][] matrix) {
        this.colorsUsed = 0;
        this.V = numVertices;
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
        String cores[] = new String[] {
            "Vermelho", "Azul", "Branco", 
            "Preto", "Amarelho", "Verde", 
            "Roxo", "Rosa", "Marrom", "Laranja"
        };
        
        String result = "";
        for (int i = 0; i < V; i++) {
            result = result.concat("Vértice ( " + (i +1) + ") -> Cor :" + cores[i] + "\n");
        }
        
        System.out.println(result);
    }
    
}
