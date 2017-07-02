package javademo.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Bai27_FileStream_2 {

    public static void main(String[] args) throws IOException {
        b27 b = new b27();
        Scanner k = new Scanner(System.in);
        String c;
        System.out
                .println("Enter (copy) or (delete) that you want to do about something");
        c = k.nextLine();
        switch (c) {
            case "delete":
                b.delete27();
                break;
            case "copy":
                b.copy27();
                break;
        }
        k.close();
    }
}

class b27 {

    private FileInputStream fi;
    private FileOutputStream fo;
    private File file;
    Scanner k = new Scanner(System.in);

    public void copy27() throws IOException {
        try {
            System.out.println("Enter the path that you want to copy");
            //
            try {
                String pi;
                System.out.print("From : ");
                pi = k.nextLine();
                fi = new FileInputStream(pi);
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
                return;
            }
            //
            try {
                String po;
                System.out.print("To : ");
                po = k.nextLine();
                fo = new FileOutputStream(po);
            } catch (FileNotFoundException e) {
                System.out.println("Error Opening OutputFile ");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: CopyFile From To");
        }
        //
        int i = 0;
        try {
            do {
                i = fi.read();
                if (i != -1) {
                    fo.write(i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("File Error");
        }
        System.out.println("Done");
        fi.close();
        fo.close();
    }

    public void delete27() {
        System.out.println("Enter the path that you want to delete");
        String del;
        del = k.nextLine();
        try {
            file = new File(del);
            file.delete();
        } catch (Exception e) {
            System.out.println("File error");
            return;
        }
        System.out.println("Done");
    }
}
