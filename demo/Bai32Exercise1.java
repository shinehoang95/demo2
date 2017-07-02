package javademo.demo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bai32Exercise1 {

    public static void main(String[] args) {
        doing32 doing = new doing32();
        String location, location1, location2;
        String kb;
        Scanner k = new Scanner(System.in);
        boolean continueLoop = true, continueLoop1 = true, continueLoop3 = true;
        do {
            File current = new File("E:\\");
            System.out
                    .println("Enter [cd directoryname] that you want to open directory\n"
                            + "Enter [exit] to exit\n"
                            + "Enter [show] that you want to show directory at current path\n"
                            + "Enter [makefile filename] that you want to create file\n"
                            + "Enter [makedir dirname] that you want to create directory\n"
                            + "Enter [cd..] that you want to turn back to E:\\\\");
            System.out.print("E:\\\\");
            location = k.nextLine();
            String location_c = ("E:\\");
            File file = new File(location);
            File[] listf = current.listFiles();
            if (location.length() > 4) {
                if (location.substring(0, 3).compareTo("cd ") == 0) {
                    for (int i = 0; i < listf.length; i++) {
                        // do {
                        if (listf[i].getName().equals(location.substring(3))) {
                            location1 = current + location.substring(3);
                            File current1 = new File(location1);
                            System.out.print(current1 + "\\");
                            File[] listf1 = current1.listFiles();
                            kb = k.nextLine();
                            if ((kb.equals("show"))) {
                                doing.show32(listf1, location1);
                            }
                            if (kb.substring(0, 9).equals("makefile ")) {
                                doing.createFile(current1 + "\\" + kb.substring(9));
                                continueLoop = true;
                            }
                        }
						// continueLoop1 = true;
                        // } while (continueLoop1);
                    }
                    continueLoop = true;
                }
                if (location.substring(0, 9).equals("makefile ")) {
                    doing.createFile(location_c + "\\" + location.substring(9));
                    continueLoop = true;
                }
            } else {
                if ((location.equals("show"))) {
                    doing.show32(listf, location_c);
                    continueLoop = true;
                }
                if (location.equals("exit")) {
                    continueLoop = false;
                }
            }
        } while (continueLoop);
    }
}

class doing32 {

    public void show32(File[] listf, String location) {
        File current = new File(location);
        for (int i = 0; i < listf.length; i++) {
            System.out.println(current + "\\" + listf[i].getName() + "\\");
        }
        System.out
                .println("---------------------------------------------------------------");
    }

    public void createFile(String location) {
        File a = new File(location);
        try {
            a.createNewFile();
            System.out.println("Create new file success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out
                .println("---------------------------------------------------------------");
    }
}
