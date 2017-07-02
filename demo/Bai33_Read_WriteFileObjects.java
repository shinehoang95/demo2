package javademo.demo;

//Read & Write file as Object in Java
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Bai33_Read_WriteFileObjects {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap So luong SV: ");
        int n1 = sc.nextInt();
		// Tạo file lưu dữ liệu
//		try {
//			FileOutputStream Nfile = new FileOutputStream("example.txt");
//			ObjectOutputStream Nob = new ObjectOutputStream(Nfile);
//			ListSV1 A;
//			A = new ListSV1(n1);
//			Nob.writeObject(A);
//			Nfile.close();
//			Nob.close();
//		} catch (IOException e1) {
//			System.out.print("Co loi xay ra");
//		}

        // A1= new ListSV1(n1);
        // dọc file
        try {
            FileInputStream Nfile = new FileInputStream("example.txt");
            ObjectInputStream Nin = new ObjectInputStream(Nfile);
            ListSV1 A1;
            A1 = (ListSV1) Nin.readObject();
            A1.Dislay(n1);
            Nin.close();
            Nfile.close();
        } catch (IOException e2) {
            System.out.print("Co loi xay ra");
        }
        // SinhVien[n1] s;
        for (int j = 0; j < n1; j++) {
            // a=A1[j];
        }

    }
}

// tạo class sinh viên:tên , mã thẻ, số sách nợ
class SinhVien1 implements Serializable {

    private String name, mathe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMathe() {
        return mathe;
    }

    public void setMathe(String mathe) {
        this.mathe = mathe;
    }

    public int getNumberbook() {
        return numberbook;
    }

    public void setNumberbook(int numberbook) {
        this.numberbook = numberbook;
    }

    private int numberbook;

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ho Ten: ");
        name = sc.nextLine();
        System.out.print("Nhap Ma The: ");
        mathe = sc.nextLine();
        System.out.print("Sach Con No: ");
        numberbook = sc.nextInt();
    }

}

@SuppressWarnings("serial")
// tạo class lưu trữ danh sách sinh viên,một thuộc tính List của dữ liệu lớp
// SinhVien, phương thức nhập và hiển thị.
class ListSV1 implements Serializable {

    SinhVien1[] List1;

    public ListSV1(int n) {
        List1 = new SinhVien1[n];
        for (int i = 0; i < n; i++) {
            List1[i] = new SinhVien1();
            List1[i].Nhap();

        }
    }

    public void Dislay(int n) {
        SinhVien1 ds[];
        ds = new SinhVien1[n];
        for (int j = 0; j < n; j++) {
            ds[j] = List1[j];
            System.out.println("Ho Ten: " + ds[j].getName());
            System.out.println("Ma The: " + ds[j].getMathe());
            System.out.println("No Sach: " + ds[j].getNumberbook());
        }

    }
}
