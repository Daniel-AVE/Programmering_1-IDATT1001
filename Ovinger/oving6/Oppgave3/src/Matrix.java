import java.util.*;

public final class Matrix {
    private final double[][] m;
    private static Scanner in = new Scanner(System.in);

    private Matrix(double[][] n) {
        m = n;
    }

    public static Matrix fillMatrix(double[][] n) {
        return new Matrix(n);
    }

    public double[][] getMatrix() {
        return m;
    }

    public static Matrix plusMatrix(Matrix matrix1, Matrix matrix2) {
        int rows = matrix1.getNumRows();
        int columns = matrix1.getNumColumns();
        double[][] n = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                n[i][j] = matrix1.m[i][j] + matrix2.m[i][j];
            }
        }
        return new Matrix(n);
    }

    public static Matrix multiplationMatrix(Matrix a, Matrix b) {
        int aRows = a.getMatrix().length;
        int aColumns = a.getMatrix()[0].length;
        int bRows = b.getMatrix().length;
        int bColumns = b.getMatrix()[0].length;
        if (aColumns == bRows) {
            double[][] n = new double[aRows][bColumns];
            for (int i = 0; i < bColumns; i++) {
                for (int j = 0; i < aRows; j++) {
                    for (int k = 0; k < aColumns; k++) {
                        n[j][i] = n[j][i] + a.getMatrix()[j][k] * b.getMatrix()[k][i];
                    }
                }
            }
            return new Matrix(n);
        } else {
            return null;
        }
    }

    public static Matrix transposeMatrix(Matrix a) {
        int rows = a.getMatrix().length;
        int columns = a.getMatrix()[0].length;
        double[][] n= new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                n[j][i] = a.getMatrix()[i][j];
            }
        }
        return new Matrix(n);
    }

    public int getNumRows() {
        int rows = m.length;
        return rows;
    }

    public int getNumColumns() {
        int columns = m[0].length;
        return columns;
    }
}
