package javademo.demo;

import java.util.*;

public class Bai09_Array {

    String arrStr[] = new String[100];
    int n, i;
    Scanner kb = new Scanner(System.in);

    public void input() {
        System.out.println("Nhap vao so hoc sinh can nhap : ");
        n = kb.nextInt();
        kb.nextLine();
        for (i = 0; i < n; i++) {
            System.out.println("Nhap ten cua hoc sinh a[" + i + "] : ");
            arrStr[i] = kb.nextLine();
        }
    }

    public void output() {
        for (i = 0; i < n; i++) {
            System.out.println("Ten cua hoc sinh a[" + i + "] : " + arrStr[i]);
        }
    }

    public void find() {
        String a;
        boolean kq = false;
        System.out.println("Nhap vao ten hoc sinh muon tim : ");
        a = kb.nextLine();
        for (i = 0; i < n; i++) {
            if (a.equals(arrStr[i])) {
                System.out.println("co trong danh sach");
                kq = true;
            }
        }
        if (kq == false) {
            System.out.println("khong có trong danh sách");
        }
    }

    public static void main(String[] args) {
        Bai09_Array b9 = new Bai09_Array();
        b9.input();
//        b9.output();
        b9.find();

    }
}
