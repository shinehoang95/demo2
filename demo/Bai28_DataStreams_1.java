package javademo.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Reader & Writer Binary Using Byte Streams
public class Bai28_DataStreams_1 {

    public static void main(String[] args) throws IOException {
        b28 bai = new b28();
        bai.write28();
        bai.read28();
    }
}

class b28 {

    DataOutputStream dos;
    DataInputStream dis;
    int i;
    char c;
    double d;
    String str;
    boolean b;

    public void write28() throws IOException {
        c = 'c';
        i = 1;
        d = 1.1;
        str = "str";
        b = true;
        try {
            dos = new DataOutputStream(new FileOutputStream(
                    "C:\\Users/Administrator/Desktop/text1.txt"));
        } catch (IOException e) {
            e.getStackTrace();
        }
        try {
            System.out.println("Writing Integer : " + i);
            dos.writeInt(i);
            System.out.println("Writing Boolean : " + b);
            dos.writeBoolean(b);
            System.out.println("Writing String : " + str);
            dos.writeUTF(str);
            System.out.println("Writing Double : " + d);
            dos.writeDouble(d);
            System.out.println("Writing Character : " + c);
            dos.writeChar(c);
            System.out.println("Done");
        } catch (IOException e) {
        }
        dos.close();
    }

    public void read28() throws IOException {
        try {
            dis = new DataInputStream(new FileInputStream(
                    "C:\\Users/Administrator/Desktop/text1.txt"));
        } catch (FileNotFoundException e) {
        }
        try {
            i = dis.readInt();
            System.out.println("Read Integer : " + i);

            b = dis.readBoolean();
            System.out.println("Read Boolean : " + b);

            str = dis.readUTF();
            System.out.println("Read String : " + str);

            d = dis.readDouble();
            System.out.println("Read Double : " + d);

            c = dis.readChar();
            System.out.println("Read Character : " + c);

        } catch (IOException e) {
        }
        dis.close();
    }
}
