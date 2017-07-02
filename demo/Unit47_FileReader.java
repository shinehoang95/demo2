package javademo.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//File Reader
public class Unit47_FileReader {

    public static void main(String[] args) {
        try {
            File file = new File("example.txt");

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(++i + " : " + line);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

    }
}
