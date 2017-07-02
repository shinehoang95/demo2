package javademo.demo;

import java.util.Date;
import java.util.Scanner;

class giangVien15 {
    private String hoTen;
    private String lopDay;
    private Date namSinh;
    private double luong;
    public giangVien15(){}

    public giangVien15(String hoTen, String lopDay, Date namSinh, double luong) {
        this.hoTen = hoTen;
        this.lopDay = lopDay;
        this.namSinh = namSinh;
        this.luong = luong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLopDay() {
        return lopDay;
    }

    public void setLopDay(String lopDay) {
        this.lopDay = lopDay;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    
}

class hocSinh15   {
    private String hoTen;
    private String lopHoc;
    private double diemToan,diemLy,diemHoa;
    public hocSinh15(){}

    public hocSinh15(String hoTen, String lopHoc, double diemToan, double diemLy, double diemHoa) {
        this.hoTen = hoTen;
        this.lopHoc = lopHoc;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
    }

    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public double getDiemLy() {
        return diemLy;
    }

    public double getDiemHoa() {
        return diemHoa;
    }
    
    
}

public class Bai15_Getter_Setter {
//    public static String hocLuc(double dtb)    {
//        if(dtb)
//    }
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        hocSinh15 hs = new hocSinh15();
        System.out.println("Nhap vao thong tin cua hoc sinh ");
        System.out.println("Ten : ");   hs.setHoTen(k.nextLine());
        System.out.println("Lop hoc : ");   hs.setLopHoc(k.nextLine());
        System.out.println("Diem toan : "); hs.setDiemToan(k.nextDouble());
        System.out.println("Diem ly : "); hs.setDiemLy(k.nextDouble());
        System.out.println("Diem hoa : "); hs.setDiemHoa(k.nextDouble());
        
        giangVien15 gv = new giangVien15();
        System.out.println("Nhap vao thong tin cua giang vien ");
        System.out.println("Ten: "+gv.getHoTen());
        System.out.println("Lop day : "+gv.getLopDay());
        System.out.println("Nam sinh : "+gv.getNamSinh());
        System.out.println("Luong : "+gv.getLuong());
        k.close();
    }
}
