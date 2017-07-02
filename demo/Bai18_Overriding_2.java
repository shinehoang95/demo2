package javademo.demo;
//Override
import java.util.Scanner;

class usb {

    private String maHang;
    private double gia;
    private int soLuong;

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tongTien(int soluong, double dongia) {
        return this.getGia() * this.getSoLuong();
    }

    public void show() {
        System.out.print("ma hang : " + this.getMaHang());
        System.out.print("\ngia : " + this.getGia());
        System.out.print("\nso luong : " + this.getSoLuong());
        double total = tongTien(getSoLuong(), getGia());
        System.out.print("\ngia : "+total);
        System.out.println("");
    }

    public void input() {
        Scanner k = new Scanner(System.in);
        System.out.print("ma hang : ");
        setMaHang(k.nextLine());
        System.out.print("gia : ");
        setGia(k.nextDouble());
        System.out.print("so luong : ");
        setSoLuong(k.nextInt());
        k.close();
    }
}

class mouse extends usb {

    @Override
    public double tongTien(int soluong, double dongia) {
        return ((this.getGia() * this.getSoLuong()) * 80 / 100);
    }
}

public class Bai18_Overriding_2 {

    public static void main(String[] args) {
        mouse a = new mouse();
        usb b = new usb();

        System.out.println("Nhap vao thong tin cua usb ");
        b.input();
        System.out.println("\nNhap vao thong tin cua mouse ");
        a.input();

        System.out.println("\n-Hoa don mua usb ");
        a.show();

        System.out.println("\n-Hoa don mua mouse ");
        b.show();
    }
}
