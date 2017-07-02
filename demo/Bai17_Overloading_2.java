package javademo.demo;

import java.util.Scanner;

public class Bai17_Overloading_2 {

    public static void main(String[] args) {
        hangHoa hh = new hangHoa();
        System.out.println("Nhap vao thong tin cua hang hoa ");
        hh.input();
        hh.show();
    }
}

class hangHoa {

    private String maHang;
    private String tenHang;
    private int soLuong;
    private double giaTien;
    private int giamGia;

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tongTien(int soLuong, double giaTien) {
        return this.getGiaTien() * this.getSoLuong();
    }

    public double tongTien(int soLuong, double giaTien, int giamGia) {
        return this.getGiaTien() * this.getSoLuong() * (100-this.getGiamGia())/100;
    }

    public void input() {
        Scanner k = new Scanner(System.in);
        System.out.print("ma hang : ");
        setMaHang(k.nextLine());
        System.out.print("ten hang : ");
        setTenHang(k.nextLine());
        System.out.print("gia hang : ");
        setGiaTien(k.nextDouble());
        System.out.print("so luong hang : ");
        setSoLuong(k.nextInt());
        System.out.print("% giam gia : ");
        setGiamGia(k.nextInt());
        k.close();
    }
    public void show()  {
        System.out.println("thong tin hang vua nhap vao la ");
        System.out.print("ma hang : " + getMaHang());
        System.out.print("\nten hang : "+getTenHang());
        System.out.print("\ngia hang : "+getGiaTien());
        System.out.print("\nso luong : "+getSoLuong());
        if(getGiamGia()==0)
            System.out.print("\ntong tien : "+tongTien(getSoLuong(),getGiaTien())+"\n");
        else
            System.out.print("\ntong tien : "+tongTien(getSoLuong(),getGiaTien(),getGiamGia())+"\n");
    }
}
