package Bonus;

import java.util.Scanner;

public class Prob1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter a num: ");
        int n = read.nextInt();

        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            A[i][(i + 1) % n] = 1;
            A[(i + 1) % n][i] = 1;
        }
        printMatrix(A);

        int[][] A_n = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A_n[i][j] = A[i][j];

        for (int i = 2; i <= n; i++) {
            A_n = multiplicationMatrix(A_n, A);
            System.out.println("A^" + i + ": ");
            printMatrix(A_n);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                for (int k = 0; k < matrix1.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}
