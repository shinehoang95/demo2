package javademo.demo;

import java.util.*;

public class Bai12_Class {

    public static void main(String[] args) {
        HocSinh12 a = new HocSinh12();
        HocSinh12 b = new HocSinh12();
        Scanner k = new Scanner(System.in);
        System.out.println("Nhap vao thong tin cua hoc sinh A ");
        System.out.print("Ten : ");
        a.hoTen = k.nextLine();
        System.out.print("Lop : ");
        a.lop = k.nextLine();
        System.out.print("Diem trung binh : ");
        a.diemTB = k.nextFloat();

        System.out.println("Nhap vao thong tin cua hoc sinh B ");
        System.out.print("Ten : ");
        b.hoTen = k.nextLine();
        k.nextLine();
        System.out.print("Lop : ");
        b.lop = k.nextLine();
        System.out.print("Diem trung binh : ");
        b.diemTB = k.nextFloat();
        if (a.diemTB > b.diemTB) {
            System.out.println("A co diem trung binh cao hon B = " + a.diemTB);
        } else if (a.diemTB < b.diemTB) {
            System.out.println("B co diem trung binh cao hon A = " + b.diemTB);
        } else {
            System.out.println("Ca 2 deu co diem trung binh bang nhau = " + a.diemTB);
        }
        k.close();
    }
}

class HocSinh12 {

    protected String hoTen;
    protected String lop;
    protected float diemTB;
}
