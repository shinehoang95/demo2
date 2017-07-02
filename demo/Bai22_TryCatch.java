package javademo.demo;
//Try catch finally throw throws

import java.util.Scanner;

public class Bai22_TryCatch {

    public static void main(String[] args) {
        ptBac1 pt = new ptBac1();
        pt.timX();
    }
}

class ptBac1 {

    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void timX() {
        Scanner k = new Scanner(System.in);
        double x;
        try {
            System.out.println("Nhap vao gia tri a,b de giai phuong trinh bac 1 ");
            System.out.print("a = ");
            setA(k.nextInt());
            System.out.print("b = ");
            setB(k.nextInt());
            x = (double) this.getA() / this.getB();
            System.out.println("x = " + x);
        } catch (Exception e) {
            System.out.println("Error : " + e.toString());
        }
        k.close();
    }
}
