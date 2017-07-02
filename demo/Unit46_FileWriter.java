package javademo.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//File Writer
public class Unit46_FileWriter {

    public static void main(String[] args) {
        File file = new File("example.txt");
        try {
            file.createNewFile();

            FileWriter fw = new FileWriter(file);
//            FileWriter fw = new FileWriter(file.getName(),false); tránh ghi đè dữ liệu
            BufferedWriter bw = new BufferedWriter(fw);

            String str = "Nguyen Xuan Lam";
            bw.write(str);
            bw.close();
            fw.close();

        } catch (IOException e) {
        }
    }
}
