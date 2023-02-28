package Bonus;

import java.util.Scanner;

public class Prob2 {
    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter a number of vertices: ");
        int vertices = read.nextInt();

        System.out.println("Enter the vertex degree: ");
        int degree = read.nextInt();

        int[][] matrix = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if ( ((i - j)% degree != 0 || (j - i) % degree != 0) && i!=j) {
                    matrix[i][j] = 1;
                }
            }
        }
        if(degree==vertices-1) //graful e complet
        {
            matrix[0][vertices-1]=1;
            matrix[vertices-1][0]=1;
        }
        printMatrix(matrix);
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

