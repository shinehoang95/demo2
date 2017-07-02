package javademo.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Bai33Exercise2 {

    public static void main(String args[]) throws Exception {
        ProcessStudent ps = new ProcessStudent(); // tao doi tuong cua lop
        // ProcessStudent
        Student[] student1 = null, student2 = null; // tao 2 doi tuong student
        student1 = ps.creat(); // nhap student
        ps.write(student1); // viet vao file
        student2 = ps.read(); // doc tu file
        ps.show(student2); // hien thi kq
    }
}

class Student implements Serializable { // Serializable dung de ghi va doc theo
    // Object

    private static final long serialVersionUID = 1L; // ID of Serializable
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // cac ham get, set gia tri cac bien
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

// class xu ly thong tin
class ProcessStudent {

    public Student[] creat() { // Input the data from Keyboard
        int n;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of student: ");
        n = Integer.parseInt(scan.nextLine()); // nhap so sinh vien

        Student[] student = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: "); // nhap ten sv thu i
            String name = scan.nextLine();
            System.out.print("Enter age: "); // nhap tuoi
            int age = Integer.parseInt(scan.nextLine()); // tranh troi lenh nhu
            // khi dung
            // scan.nextInt()
            student[i] = new Student(name, age); // khoi tao doi tuong Student
            // thu i
        }

        scan.close();
        return student;
    }

    public void write(Student[] student) { // ghi theo Object
        try { // dat try cacth de tranh ngoai le khi tao va ghi File
            FileOutputStream f = new FileOutputStream("student.dat"); // tao
            // file
            // f tro
            // den
            // student.dat
            ObjectOutputStream oStream = new ObjectOutputStream(f); // dung de
            // ghi theo
            // Object
            // vao file
            // f
            oStream.writeObject(student); // ghi student theo kieu Object vao
            // file
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
        }
    }

    public Student[] read() { // doc theo Object
        Student[] student = null;
        try { // dat try cacth de tranh ngoai le khi tao va doc File
            FileInputStream f = new FileInputStream("student.dat"); // tao file
            // f tro den
            // student.dat
            ObjectInputStream inStream = new ObjectInputStream(f); // dung de
            // doc theo
            // Object
            // vao file
            // f
            // dung inStream doc theo Object, ep kieu tra ve la Student
            student = (Student[]) inStream.readObject();
            inStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error Read file");
        }
        return student;
    }

    public void show(Student[] student) throws Exception { // In data doc duoc
        // tu file ra man
        // hinh
        try {
            for (int i = 0; i < student.length; i++) {
                System.out.println((i + 1) + " : My name is "
                        + student[i].getName() + ". I am "
                        + student[i].getAge() + " years old");
            }
        } catch (NullPointerException e) {
            System.out.println("File Empty");
        }
    }
}
