package javademo.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

//Random Access Files in Java
public class Bai29_RandomAccessFiles_2 {

    public static void main(String[] args) throws IOException {
        b29 b = new b29();
        Scanner k = new Scanner(System.in);
        String str;
        int n = 0;
        System.out.print("Enter the name of file that you want to create : ");
        str = k.nextLine();
        b.file = new File(str);
        if (b.file.exists()) {
            System.out
                    .println("File " + b.file.getName() + " already exists !");
            b.readFile2(str);
            // b.readFile(str, n);
        } else {
            n = b.inputNumber();
            b.createArray(n);
            b.writeFile(str, n);
            b.readFile2(str);
            // b.readFile(str, n);
        }
        k.close();
        System.out.print("\nDone");
    }
}

class b29 {

    RandomAccessFile raf;
    Scanner k = new Scanner(System.in);
    File file;
    double data[];
    double d;
    int n;
    BufferedReader br;

    public int inputNumber() throws IOException {
        String str;
        System.out.print("Enter number of elements in array : ");
        boolean continueLoop = true;
        while (continueLoop) {
//			str = k.nextLine();
            n = Integer.parseInt(k.nextLine());
//			n = Integer.valueOf(str).intValue();
            if (n > 0) {
                continueLoop = false;
            } else {
                throw new IllegalArgumentException(
                        "The number of students is greater than 0 !");
            }
        }
        return n;
    }

    public void createArray(int n) {
        data = new double[n];
        System.out.println("Enter values into double array : ");
        for (int i = 0; i < n; i++) {
            System.out.print("\td[" + (i) + "] : ");
            data[i] = k.nextDouble();
        }
    }

    public void createRAF(String str) {
        try {
            raf = new RandomAccessFile(str, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String str, int n) throws IOException {
        createRAF(str);
        for (int i = 0; i < n; i++) {
            raf.writeDouble(data[i]);
        }
        raf.close();
    }

    public void readFile(String str, int n) throws IOException {
        createRAF(str);
        System.out.println("Read all : ");
        for (int i = 0; i < n; i++) {
            raf.seek(8 * i);
            d = raf.readDouble();
            System.out.println("\tdata[" + (i + 1) + "] = " + d);
        }
        raf.close();
    }

    public void readFile2(String str) throws IOException {
        file = new File(str);
        FileReader fr = new FileReader(file);
        br = new BufferedReader(fr);
        int dongThu = 1;
        while (br.readLine() != null) {
            dongThu++;
        }
//		dongThu++;
//		System.out.println("number of columns : " + dongThu);
        createRAF(str);
        System.out.println("Read all : ");
        for (int i = 0; i <= dongThu; i++) {
            raf.seek(8 * i);
            d = raf.readDouble();
            System.out.println("\tdata[" + (i + 1) + "] = " + d);
        }
        br.close();
        fr.close();
        raf.close();
    }
}
