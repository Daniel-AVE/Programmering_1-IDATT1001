import java.util.*;

public class MatrixClient {
    private static Scanner in = new Scanner(System.in);
    private static Matrix[] matrix = new Matrix[2];

    public static void main(String[] args) {
        while (true) {
            System.out.println("Create the first matrix");
            matrix[0] = Matrix.fillMatrix(createMatrix());
            System.out.println("Matrix nr. 1: ");
            printMatrix(matrix[0]);
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("Press 1 to add a matrix to this matrix");
        System.out.println("Press 2 to multiplicate this matrix with another matrix");
        System.out.println("Press 3 to transpose this matrix");
        System.out.println("Press 4 to cancel");

        int menuInput = in.nextInt();
        if (menuInput == 4) {
            System.out.println("Cancelling...");
            System.exit(0);
        }
        switch (menuInput) {
            case 1:
                matrix[1] = Matrix.fillMatrix(createMatrix(matrix[0].getNumRows(), matrix[0].getNumColumns()));
                System.out.println("Matrix nr. 2: ");
                printMatrix(matrix[1]);
                Matrix a = Matrix.plusMatrix(matrix[0], matrix[1]);
                System.out.println("Result: ");
                printMatrix(a);
                break;

            case 2:
                System.out.println("Create matrix nr. 2 (number of rows must be equal to" + matrix[0].getNumColumns() + "):");
                matrix[1] = Matrix.fillMatrix(createMatrix());
                System.out.println("Matrix nr. 2: ");
                printMatrix(matrix[1]);
                Matrix b = Matrix.multiplationMatrix(matrix[0], matrix[1]);
                if (b != null) {
                    System.out.println("Result: ");
                    printMatrix(b);
                } else {
                    System.out.println("Something went wrong. Number of columns in matrix 1 must be equal to number of rows in matrix 2");
                }
                break;

            case 3:
                Matrix c = Matrix.transposeMatrix(matrix[0]);
                System.out.println("Result: ");
                printMatrix(c);
                break;

            default:
                System.out.println("You need to choose between choices 1-4");
                showMenu();
                break;
        }
    }
    public static double[][] createMatrix() {
        System.out.print("Enter number of rows: ");
        int rows = in.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = in.nextInt();

        double[][] m = new double[rows][columns];

        System.out.println("Fill in the matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("[" + i + "]" + "[" + j + "]");
                m[i][j] = in.nextDouble();
            }
        }
        return m;
    }

    public static void printMatrix(Matrix m) {
        int rows = m.getNumRows();
        int columns = m.getNumColumns();
        double[][] t = m.getMatrix();

        for (int i = 0; i < rows; i++) {
            String row = "";
            for (int j = 0; j < columns; j++) {
                row += t[i][j] + " ";
            }
            System.out.println(row);
        }
    }

}
