package javademo.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//Using BufferReader and InputStreamReader
public class Bai30_BufferReader_InputStreamReader {

    public static void main(String[] args) throws IOException {
        b30 b = new b30();
        b.read30();
    }
}

class b30 {

    BufferedReader br;

    public void read30() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        char c;
        System.out.print("Enter anything : ");
        do {
            c = (char) br.read();
        } while (c != '.');
        System.out.print("by the way : " + c);
    }

    public void readLine30() {

    }

    public void printWriter30() {
        String str = "Nguyen Xuan Lam ";
        int i = 2015;
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("I am " + str + i);
    }
}
