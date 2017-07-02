package javademo.demo;

import java.util.*;

public class Bai09_Array_SortAr {

    int arrInt[] = new int[100];
    Scanner kb = new Scanner(System.in);
    int n, i;

    public void input() {
        System.out.println("Nhap vao so phan tu cua mang : ");
        n = kb.nextInt();
        kb.nextLine();
        for (i = 0; i < n; i++) {
            System.out.println("Nhap vao gia tri cua phan tu a[" + i + "] : ");
            arrInt[i] = kb.nextInt();
        }
    }

    public void output() {
        for (i = 0; i < n; i++) {
            System.out.print(arrInt[i] + " ");
        }
    }

    public void swap(int a, int b) {
        int c = 0;
        c = a;
        a = b;
        b = c;
    }

    public void arrangement() {
        int temp;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<=i;j++){
//              if(arrInt[i] > arrInt[j]){
//                temp = arrInt[i];
//                arrInt[i]=arrInt[j];
//                arrInt[j]=temp;
//              }
//            }
//        }
        for (int ii = 0; ii < n - 1; ii++) {
            for (int j = ii + 1; j < n; j++) {
                if (arrInt[ii] > arrInt[j]) {
                    temp = arrInt[ii];
                    arrInt[ii] = arrInt[j];
                    arrInt[j] = temp;
                }
            }
//        }
//        for (int ii = 0; ii < n - 1; ii++) {      // chạy không được
//            for (int j = ii + 1; j < n; j++) {
//                if (arrInt[ii] > arrInt[j]) {
//                    swap(arrInt[ii],arrInt[j]);
//                }
//            }
//        }
        }
    }

    public static void main(String[] args) {
        Bai09_Array_SortAr b9 = new Bai09_Array_SortAr();
        b9.input();
        b9.arrangement();
        System.out.println("Mang sau khi sap xep la : ");
        b9.output();

    }
}
