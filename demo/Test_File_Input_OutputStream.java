package javademo.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Test_File_Input_OutputStream {

    public static void main(String args[]) throws IOException {
        FileInputStream fin;
        FileOutputStream fout;
        try {
            // open input file
            try {
                fin = new FileInputStream(
                        "C:\\Users/PC/Desktop/java/JavaBasic/example1.txt");
            } catch (FileNotFoundException exc) {
                System.out.println("Input File Not Found");
                return;
            }

            // open output file
            try {
                fout = new FileOutputStream(
                        "C:\\Users/PC/Desktop/java/JavaBasic/example2.txt");
            } catch (FileNotFoundException exc) {
                System.out.println("Error Opening OutputFile");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Usage: CopyFile From To");
            return;
        }

        // Copy File
        int i;
        try {
            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                }
            } while (i != -1);
        } catch (IOException exc) {
            System.out.println("File Error");
        }
        fin.close();
        fout.close();
    }
}
