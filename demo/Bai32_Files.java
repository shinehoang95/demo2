package javademo.demo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bai32_Files {

    public static void main(String[] args) throws IOException {
        String locate, locate_c, locate_c_c;
        int i;
        int k = 1;
        Scanner input = new Scanner(System.in);
        System.out.println("Press [ stop ] to stop process");
        label:
        do {
            System.out.print("E:\\\\");
            locate = input.nextLine();
            if (locate.compareTo("stop") == 0) {
                break;
            }
            if (locate.length() < 4) {
            } else {
                if ((locate.substring(0, 3).compareTo("cd ") == 0)
                        && (locate.substring(3) != null)) {
                    try {
                        File f = new File(locate.substring(3)); // 4
                        File dir = new File("E:\\");
                        File[] listf = dir.listFiles();
                        for (i = 0; i < listf.length; i++) {
                            if (((listf[i].getName()).compareTo(locate
                                    .substring(3)) == 0)
                                    && listf[i].isDirectory()) {
                                System.out.println("E:\\\\"
                                        + locate.substring(3) + "\\");
                                System.out
                                        .println("You want to create a file? press [ makeFile file_name ] to create or [ stop ] to stop process");
                                locate_c = input.nextLine();
                                if (locate_c.compareTo("stop") == 0) {
                                    k = 0;
                                    return;
                                }
                                if ((locate_c.substring(0, 9).compareTo(
                                        "makeFile ") == 0)
                                        && (locate_c.substring(9) != null)) {
                                    try {
                                        File fc = new File("E:\\\\"
                                                + locate.substring(3) + "\\"
                                                + locate_c.substring(9) + "\\");
                                        fc.createNewFile();
                                        System.out
                                                .println("Create file success");
                                        System.out
                                                .println("You want to show subfolder in this folder? [show/stop] ");
                                        locate_c_c = input.nextLine();
                                        if (locate_c_c.compareTo("stop") == 0) {
                                            k = 0;
                                            return;
                                        }
                                        if (locate_c_c.compareTo("show") == 0) {
                                            System.out.println("E:\\\\" + locate.substring(3) + "\\");
                                            File dir_c = new File("E:\\\\" + locate.substring(3) + "\\");
                                            File[] listf_c = dir_c.listFiles();
                                            for (i = 1; i < listf_c.length; i++) {
                                                if (listf_c[i].isDirectory()) {
                                                    System.out.println("E:\\\\" + locate.substring(3) + "\\" + listf_c[i].getName());
                                                }
                                            }
                                            k = 0;
                                            return;
                                        }
                                        k = 0;
                                        return;
                                    } catch (IOException e) {
                                        System.out.println("Error: " + e);
                                    }
                                }
                                k = 0;
                                return;
                            }
                        }
                        if (k != 0) {
                            continue label;
                        }
                    } catch (Exception e) {
                        System.out.println("Folder not found");
                        throw e;
                    }
                }
            }
        } while (true);
    }
}
