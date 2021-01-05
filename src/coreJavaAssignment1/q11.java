package coreJavaAssignment1;

import java.util.Scanner;

class Matrix {
    int columns, rows;

    Matrix() {
        columns = 0;
        rows = 0;
    }

    Matrix(int r, int c) {
        Matrix m = new Matrix();
        rows = r;
        columns = c;
    }

    void setElement(int[][] mat, int r, int c, int value) {
        if (value > 0)
            mat[r][c] = value;
        else
            mat[r][c] = 0;

    }

    void transpose_matrix(int[][] original, int[][] transposed, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                transposed[i][j] = original[j][i];
            }
        }
    }

    void display(int[][] matrix, int r, int c) {
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                System.out.println(matrix[i][j]);
    }
}

public class q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        Matrix m = new Matrix();
        int[][] matrix = new int[r][c];
        int[][] matrix2 = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }

        }
        m.transpose_matrix(matrix, matrix2, r, c);
        m.display(matrix2, r, c);
    }
}
