package javademo.demo;

import java.util.Scanner;

class ThongTin {

    protected String hoTen;
    protected int namSinh;
    protected int maThe;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getMaThe() {
        return maThe;
    }

    public void setMaThe(int maThe) {
        this.maThe = maThe;
    }

}

class SinhVien extends ThongTin {

    private double hocPhi;

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

}

class GiangVien extends ThongTin {

    private double tienLuong;

    public double getTienLuong() {
        return tienLuong;
    }

    public void setTienLuong(double tienLuong) {
        this.tienLuong = tienLuong;
    }

}

class GiamDoc extends ThongTin {

    private double tienTieu;

    public double getTienTieu() {
        return tienTieu;
    }

    public void setTienTieu(double tienTieu) {
        this.tienTieu = tienTieu;
    }

}

public class Bai16_Inherritance {

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        SinhVien sv = new SinhVien();
        GiangVien gv = new GiangVien();
        GiamDoc gd = new GiamDoc();
        System.out.println("Nhap thong tin cua sinh vien ");
        System.out.print("Ten :");    sv.setHoTen(k.nextLine());
        System.out.print("Nam sinh : ");  sv.setNamSinh(k.nextInt());
        System.out.print("Ma the : ");    sv.setMaThe(k.nextInt());
        System.out.print("Hoc phi no : ");    sv.setHocPhi(k.nextDouble());
        k.nextLine();
        System.out.println("Nhap thong tin cua giang vien ");
        System.out.print("Ten :");    gv.setHoTen(k.nextLine());
        System.out.print("Nam sinh : ");  gv.setNamSinh(k.nextInt());
        System.out.print("Ma the : ");    gv.setMaThe(k.nextInt());
        System.out.print("Tien luong : ");  gv.setTienLuong(k.nextDouble());
        k.nextLine();
        System.out.println("Nhap thong tin cua giam doc ");
        System.out.print("Ten :");    gd.setHoTen(k.nextLine());
        System.out.print("Nam sinh : ");  gd.setNamSinh(k.nextInt());
        System.out.print("Ma the : ");    gd.setMaThe(k.nextInt());
        System.out.print("Tien tieu : ");   gd.setTienTieu(k.nextDouble());
        
        System.out.println("Thong tin cua SV vua nhap vao la ");
        System.out.print("Ten : " + sv.getHoTen());
        System.out.print("Nam sinh : " + sv.getNamSinh());
        System.out.print("Ma the : " + sv.getMaThe());
        System.out.print("Hoc phi no : " + sv.getHocPhi());
        
        System.out.println("Thong tin cua GV vua nhap vao la ");
        System.out.print("Ten : " + gv.getHoTen());
        System.out.print("Nam sinh : " + gv.getNamSinh());
        System.out.print("Ma the : " + gv.getMaThe());
        System.out.print("Tien luong : " + gv.getTienLuong());
        
        System.out.println("Thong tin cua GD vua nhap vao la ");
        System.out.print("Ten : " + gd.getHoTen());
        System.out.print("Nam sinh : " + gd.getNamSinh());
        System.out.print("Ma the : " + gd.getMaThe());
        System.out.print("Tien tieu : " + gd.getTienTieu());
        k.close();
    }

}
