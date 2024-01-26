import java.util.Arrays;
import java.util.PriorityQueue;

class EightPuzzle {

    static final int N = 3; 
    static final int[][] goalState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}}; // Goal state

    static class Node implements Comparable<Node> {
        int[][] puzzle;
        int cost;
        int heuristic;
        int row;
        int col;

        Node(int[][] puzzle, int cost, int row, int col) {
            this.puzzle = puzzle;
            this.cost = cost;
            this.row = row;
            this.col = col;
            this.heuristic = calculateHeuristic();
        }

        private int calculateHeuristic() {
            int h = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (puzzle[i][j] != 0) {
                        int targetRow = (puzzle[i][j] - 1) / N;
                        int targetCol = (puzzle[i][j] - 1) % N;
                        h += Math.abs(i - targetRow) + Math.abs(j - targetCol);
                    }
                }
            }
            return h;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(cost + heuristic, other.cost + other.heuristic);
        }
    }

    static void printPuzzle(int[][] puzzle) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isGoalState(int[][] puzzle) {
        return Arrays.deepEquals(puzzle, goalState);
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }

    static void solvePuzzle(int[][] initial) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        openSet.add(new Node(initial, 0, 0, 0));

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[N][N];

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            visited[current.row][current.col] = true;

            if (isGoalState(current.puzzle)) {
                System.out.println("Goal state reached:");
                printPuzzle(current.puzzle);
                return;
            }

            for (int[] dir : directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                if (isValidMove(newRow, newCol) && !visited[newRow][newCol]) {
                    int[][] newPuzzle = new int[N][N];
                    for (int i = 0; i < N; i++) {
                        System.arraycopy(current.puzzle[i], 0, newPuzzle[i], 0, N);
                    }

                   
                    newPuzzle[current.row][current.col] = newPuzzle[newRow][newCol];
                    newPuzzle[newRow][newCol] = 0;

                    openSet.add(new Node(newPuzzle, current.cost + 1, newRow, newCol));
                }
            }
        }

        System.out.println("No solution found.");
    }

    public static void main(String[] args) {
        int[][] initial = {{1, 2, 3}, {0, 4, 6}, {7, 5, 8}}; // Initial state
        solvePuzzle(initial);
    }
}
