package javademo.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Test_ObjectStreams {

    public static void main(String[] args) {
        StudentTest[] student1 = null, student2 = null;
        ProcessStudentTest ps = new ProcessStudentTest();
        student1 = ps.create();
        ps.write(student1);
        student2 = ps.read();
        ps.show(student2);
    }
}

class StudentTest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class ProcessStudentTest {

    StudentTest[] student;
    Scanner k = new Scanner(System.in);

    public StudentTest[] create() {
        System.out.print("Enter number of student : ");
        int n = Integer.parseInt(k.nextLine());
        student = new StudentTest[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name : ");
            String name = k.nextLine();
            System.out.print("Enter age : ");
            int age = Integer.parseInt(k.nextLine());
            student[i] = new StudentTest(name, age);
        }
        return student;
    }

    public void write(StudentTest[] student) {
        try {
            FileOutputStream fos = new FileOutputStream("example.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StudentTest[] read() {
        try {
            FileInputStream fis = new FileInputStream("example.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            student = (StudentTest[]) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void show(StudentTest[] student) {
        for (int i = 0; i < student.length; i++) {
            System.out.println("Name : " + student[i].getName() + "\nAge : "
                    + student[i].getAge());
        }
    }
}
