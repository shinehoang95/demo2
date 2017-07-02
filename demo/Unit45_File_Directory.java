package javademo.demo;

import java.io.File;
import java.io.IOException;

//File Reader & Writer
public class Unit45_File_Directory {

    public static void main(String[] args) {
        File file = new File("example.txt");
        File directory = new File("Example");
        try {
            file.createNewFile();
            directory.mkdir();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        directory.mkdir();
    }
}
