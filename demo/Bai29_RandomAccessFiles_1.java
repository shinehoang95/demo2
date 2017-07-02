package javademo.demo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Bai29_RandomAccessFiles_1 {

    public static void main(String[] args) throws IOException {
        Scanner indata = new Scanner(System.in);
        Bai29_RandomAccessFiles_1 u = new Bai29_RandomAccessFiles_1();
        System.out.println("Nhap ten file: ");
        String file = indata.nextLine();
        if (u.CheckFile(file) == true) {
            System.out.println("File da ton tai");
            System.out.println("Noi dung file: ");
            u.InputData(file);
        } else {
            u.OutputData(file);
        }
        indata.close();
    }

    public void InputData(String filename) throws IOException {
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile(filename, "rw");
            int i = 0;
            while ((i * 4) < raf.length()) {
                raf.seek(4 * i);
                System.out.print(raf.getFilePointer());
                System.out.println(" " + raf.readFloat());
                i += 2;
            }
            raf.close();
        } catch (IOException exc) {
            System.out.println("Co loi xay ra");
        }
    }

    public void OutputData(String filename) {
        float[] arrSoThuc = new float[10];
        for (int i = 0; i < arrSoThuc.length; i++) {
            arrSoThuc[i] = new Random().nextFloat();
        }
        try {
            RandomAccessFile raf = new RandomAccessFile(filename, "rw");
            for (int i = 0; i < arrSoThuc.length; i++) {
                {
                    raf.writeFloat(arrSoThuc[i]);
                }
            }
            raf.close();
        } catch (IOException exc) {
            System.out.println("co loi xay ra : " + exc);
        }
    }

    public boolean CheckFile(String filename) {
        File f = new File(filename);
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }
}
