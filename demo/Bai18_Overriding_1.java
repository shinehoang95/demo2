package javademo.demo;
//Overriding

class HocSinh18 {

    private String hoTen;
    private String lop;
    private float toan, ly, hoa;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    public float diemTrungBinh() {
        return (float) (this.toan + this.ly + this.hoa) / 3;
    }
}

class HocSinhChuyenToan18 extends HocSinh18 {

    @Override
    public float diemTrungBinh() {
        return (float) (this.getHoa() + this.getLy() + this.getToan() * 2) / 4;
    }
}

public class Bai18_Overriding_1 {

    public static void main(String[] args) {
        HocSinh18 a = new HocSinh18();
        a.setHoTen("Vu Van Tuong");
        a.setLop("At7a");
        a.setToan(10.0f);
        a.setLy(9.0f);
        a.setHoa(8.0f);
        System.out.println("Diem trung binh cua hoc sinh a la: " + a.diemTrungBinh());

        HocSinhChuyenToan18 b = new HocSinhChuyenToan18();
        b.setHoTen("Nguyen Van B");
        b.setToan(9.0f);
        b.setHoa(7.0f);
        b.setLy(8.0f);
        System.out.println("Diem trung binh cua hoc sinh chuyen Toan b la: " + b.diemTrungBinh());

    }
}
