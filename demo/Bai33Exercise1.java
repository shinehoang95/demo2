package javademo.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Bai33Exercise1 {

    public static void main(String[] args) throws IOException {
        ProcessStudent33 ps = new ProcessStudent33();
        Student33[] student1 = null, student2 = null;
        // student1 = ps.create();
        // ps.write(student1);
        // student2 = ps.read();
        // ps.show(student2);
        ps.menu();

    }
}

class Student33 implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Student33(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ProcessStudent33 {

    public Student33[] create() {
        int n;
        Scanner k = new Scanner(System.in);
        System.out.print("Enter number of student : ");
        n = Integer.parseInt(k.nextLine());
        Student33[] student = new Student33[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name : ");
            String name = k.nextLine();
            System.out.print("Enter age : ");
            int age = Integer.parseInt(k.nextLine());
            student[i] = new Student33(name, age);
        }
        k.close();
        return student;
    }

    public void write(Student33[] student) {
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

    public Student33[] read() {
        Student33[] student = null;
        try {
            FileInputStream fis = new FileInputStream("example.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            student = (Student33[]) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void show(Student33[] student) {
        try {
            for (int i = 0; i < student.length; i++) {
                System.out.println("Name : " + student[i].getName()
                        + "\nAge : " + student[i].getAge());
            }
        } catch (Exception e) {
            System.out.print("File Empty");
        }
    }

    public void menu() {
        int selected = 0;
        Student33[] student;
        Scanner k = new Scanner(System.in);
        do {
            System.out.println("------Menu------");
            System.out.println("1. Add a list of Students and save to File");
            System.out.println("2. Loading list of Students from a File");
            System.out.println("0. Exit program");
            System.out.println("----------------");
            System.out.print("Select option: ");
            selected = k.nextInt();
            switch (selected) {
                case 1: {
                    System.out
                            .println("1. Add a list of Students and save to File");
                    student = create();
                    write(student);
                    System.out
                            .print("-------------------------------------------------------");
                    break;
                }
                case 2: {
                    System.out.println("2. Loading list of Students from a File");
                    student = read();
                    show(student);
                    System.out
                            .print("-------------------------------------------------------");
                    break;
                }
                case 0: {
                    System.out.println("0. Exit program");
                    break;
                }
                default: {
                    System.out.println("Option not existing");
                    break;
                }
            }
        } while (selected != 0);
    }
}
