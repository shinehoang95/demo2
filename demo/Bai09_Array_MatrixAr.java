package javademo.demo;

import java.util.Scanner;

public class Bai09_Array_MatrixAr {

    private static Scanner scanner = new Scanner(System.in);

    public class Matrix {

        private int[][] matrix;
        private int row;
        private int column;

        // constructor

        public Matrix() {
            System.out.print("Enter number of row and column\n");
            boolean continueLoop = true;
            while (continueLoop) {
                try {
                    row = inputHandling("row");
                    column = inputHandling("column");

                    if (row <= 0 || column <= 0) {
                        throw new IllegalArgumentException("Row or column cannot have negative value");
                    } else {
                        continueLoop = false;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            matrix = new int[row][column];
        }

        // constructor with argument

        public Matrix(int row, int column) {
            this.row = row;
            this.column = column;
            matrix = new int[row][column];
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        // enter value of each elements of matrix

        public void passingValue() {
            System.out.print("Enter value for each element of matrix\n");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = inputHandling("[" + i + "][" + j + "]");
                }
            }
        }

        public void display() {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.printf("%d ", matrix[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // ensure the entered value is a integer

    private static int inputHandling(String str) {
        boolean continueLoop = true;
        int result = 0;
        while (continueLoop) {
            try {
                System.out.print(str + ":\t");
                result = Integer.parseInt(scanner.nextLine());
                continueLoop = false;
            } catch (Exception e) {
                System.out.println("Value is invalid! Please enter again");
            }
        }
        return result;
    }

    // method to plus two matrices

    public static Matrix addition(Bai09_Array_MatrixAr temp, Matrix ma1, Matrix ma2) throws Exception {
        if (ma1.row != ma2.row || ma1.column != ma2.column) {
            throw new Exception("Rows or column of two matrices aren't equal. Operation plus cannot be processed.");
        } else {
            int numberOfRow = ma1.row, numberOfColumn = ma1.column;
            Matrix result = temp.new Matrix(numberOfRow, numberOfColumn);

            for (int i = 0; i < numberOfRow; i++) {
                for (int j = 0; j < numberOfColumn; j++) {
                    result.matrix[i][j] = ma1.matrix[i][j] + ma2.matrix[i][j];
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Bai09_Array_MatrixAr newTest = new Bai09_Array_MatrixAr();
        Matrix ma1 = newTest.new Matrix();
        ma1.passingValue();
        ma1.display();
        Matrix ma2 = newTest.new Matrix();
        ma2.passingValue();
        ma2.display();
        Matrix ma3;
        try {
            ma3 = addition(newTest, ma1, ma2);
            ma3.display();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
