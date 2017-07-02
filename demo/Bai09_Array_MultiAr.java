package javademo.demo;

import java.util.*;

public class Bai09_Array_MultiAr {

    int colums, rows, i, j;
    Scanner kb = new Scanner(System.in);
    protected int[][] multiArrInt;

    public void input() {
        System.out.println("Enter the multi array");
        System.out.print("Enter the row(s) : ");
        rows = kb.nextInt();
        System.out.print("Enter the colum(s) : ");
        colums = kb.nextInt();
        int[][] multiArrInt = new int[rows][colums];
        for (i = 0; i < rows; i++) {
            for (j = 0; j < colums; j++) {
                System.out.print("Enter the values for the a[" + i + "]");
                System.out.print("[" + j + "]: ");
                multiArrInt[i][j] = kb.nextInt();
            }
        }
    }

    public void output() {
        System.out.println("Multi Array Entered");
        for (i = 0; i < rows; i++) {
            for (j = 0; j < colums; j++) {
                System.out.print("\t" + multiArrInt[i][j]);
            }
            System.out.print("\n");
        }
    }

    public void sum() {
        int s = 0;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < colums; j++) {
                s = s + multiArrInt[i][j];
            }
        }
        System.out.println("Sum of multi array : " + s);
    }

    public static void main(String[] args) {
        Bai09_Array_MultiAr b9 = new Bai09_Array_MultiAr();
        b9.input();
        b9.output();
        b9.sum();
    }
}
