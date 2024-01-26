import java.util.Arrays;

public class FourColorMap {
    static int V = 4; 

    public static void main(String[] args) {
        int graph[][] = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };

        if (colorMap(graph) == false) {
            System.out.println("Solution does not exist");
        }
    }

    static boolean isSafe(int v, int[][] graph, int[] color, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && c == color[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean graphColoringUtil(int[][] graph, int m, int[] color, int v) {
        if (v == V) {
            printSolution(color);
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1)) {
                    return true;
                }
                color[v] = 0; 
            }
        }

        return false;
    }

    static boolean colorMap(int[][] graph) {
        int m = 4; 
        int[] color = new int[V];
        Arrays.fill(color, 0);

        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        return true;
    }

    static void printSolution(int[] color) {
        System.out.println("Solution exists: Following are the assigned colors:");
        for (int value : color) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
