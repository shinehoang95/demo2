package javademo.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//File Reader & Writer File Using Byte Streams
public class Bai27_FileStream_1 {

    public static void main(String[] args) throws IOException {
        file27 fl = new file27();
        fl.write27();
    }
}

class file27 {

    FileInputStream fi;
    FileOutputStream fo;
    File file;

    public void read27() throws IOException {
        try {
            fi = new FileInputStream(
                    "C:\\Users/PC/Desktop/java/JavaBasic/example.txt");
        } catch (FileNotFoundException exc) {
            System.out.println("File Not Found");
            return;
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Usage: ShowFile File");
            return;
        }

        int i;
        do {
            i = fi.read();
            if (i != -1) {
                System.out.print((char) i + " ");
            }
        } while (i != -1);
        fi.close();
    }

    public void write27() throws IOException {
        Scanner k = new Scanner(System.in);
        file = new File("C:\\Users/PC/Desktop/java/JavaBasic/example1.txt");
        if (file.exists()) {
            System.out.println("File " + file.getName() + " Already Exists !");
        } else {
            fo = new FileOutputStream(
                    "C:\\Users/PC/Desktop/java/JavaBasic/example1.txt");
        }
        int n = 0;
        System.out.println("How many peole in your family ? ");
        System.out.print("Answer : ");
        n = k.nextInt();
        // file.(n);
        k.close();
    }
}
