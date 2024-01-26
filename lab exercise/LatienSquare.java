import java.util.Scanner;

public class LatienSquare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the Latin Square (N): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer for N.");
            return;
        }

        int[][] latinSquare = generateLatinSquare(n);

        System.out.println("Latin Square:");
        printLatinSquare(latinSquare);
    }

  
    private static int[][] generateLatinSquare(int n) {
        int[][] square = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = (i + j) % n + 1;
            }
        }

        return square;
    }


    private static void printLatinSquare(int[][] square) {
        int n = square.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }
}
