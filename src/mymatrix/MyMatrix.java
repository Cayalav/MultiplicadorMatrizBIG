/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymatrix;

import java.util.Scanner;

/**
 *
 * @author Cayalav
 */
public class MyMatrix {

    int[][] A = {{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 0}, {1, 0, 1, 0}};
    int[][] B = {{0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 0}, {1, 0, 1, 0}};

    public static long[][] multiplicar(int[][] A, int[][] B, int n) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        long[][] C = new long[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < aRows; i++) { // aRow
                for (int j = 0; j < bColumns; j++) { // bColumn
                    for (int q = 0; q < aColumns; q++) { // aColumn
                        C[i][j] += A[i][q] * B[q][j];
                    }
                }
            }
        }

        return C;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Digite n");
        n = sc.nextInt();

        MyMatrix matrix = new MyMatrix();
        long[][] result = multiplicar(matrix.A, matrix.B, n);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

}
