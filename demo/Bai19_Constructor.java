package javademo.demo;

import java.util.Scanner;

public class Bai19_Constructor {

    public static void main(String[] args) {
        donHang dh = new donHang();
        System.out.println("Nhap vao thong tin cua don hang");
        dh.input();
        dh.show();
    }
}

class donHang {

    private String tenHang;
    private String maHang;
    private double giaBan;
    private int soLuong;
    private int giamGia;

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public donHang() {
    }

    public donHang(String tenHang, String maHang, double giaBan, int soLuong) {
        this.tenHang = tenHang;
        this.maHang = maHang;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tongTien(int soLuong, double giaBan) {
        return this.getGiaBan() * this.getSoLuong();
    }

    public double tongTien(int soLuong, double giaBan, int giamGia) {
        return this.getSoLuong() * this.getGiaBan() * (100 - this.getGiamGia()) / 100;
    }

    public void input() {
        Scanner k = new Scanner(System.in);
        System.out.print("ma hang : ");
        setMaHang(k.nextLine());
        System.out.print("ten hang : ");
        setTenHang(k.nextLine());
        System.out.print("gia ban : ");
        setGiaBan(k.nextDouble());
        System.out.print("so luong : ");
        setSoLuong(k.nextInt());
        System.out.print("% giam gia : ");
        setGiamGia(k.nextInt());
        k.close();
    }

    public void show() {
        System.out.println("Thong tin cua don hang la ");
        System.out.print("ma hang : " + getMaHang());
        System.out.print("\nten hang : " + getTenHang());
        System.out.print("\ngia ban : " + getGiaBan());
        System.out.print("\nso luong : " + getSoLuong());
        if (getGiamGia() == 0) {
            System.out.print("\ntong tien : " + tongTien(getSoLuong(), getGiaBan()) + "\n");
        } else {
            System.out.print("\ntong tien : " + tongTien(getSoLuong(), getGiaBan(), getGiamGia()) + "\n");
        }
    }

}
